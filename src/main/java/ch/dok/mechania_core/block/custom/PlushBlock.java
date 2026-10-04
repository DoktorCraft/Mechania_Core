package ch.dok.mechania_core.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

public class PlushBlock extends HorizontalDirectionalBlock implements Equipable {

    public static final MapCodec<PlushBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
        instance.group(
            propertiesCodec(),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("plush_sound").forGetter(b -> b.plushSound)
        ).apply(instance, PlushBlock::new)
    );

    private static final VoxelShape SHAPE_NORTH = Block.box(3,   0, 4.5, 13,   15.5, 14.5);
    private static final VoxelShape SHAPE_SOUTH = Block.box(3,   0, 1.5, 13,   15.5, 11.5);
    private static final VoxelShape SHAPE_EAST  = Block.box(1.5, 0, 3,   11.5, 15.5, 13  );
    private static final VoxelShape SHAPE_WEST  = Block.box(4.5, 0, 3,   14.5, 15.5, 13  );

    private static final Map<BlockPos, SoundInstance> ACTIVE_SOUNDS = new HashMap<>();

    private final SoundEvent plushSound;

    public PlushBlock(BlockBehaviour.Properties properties, SoundEvent plushSound) {
        super(properties);
        this.plushSound = plushSound;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    private VoxelShape shapeFor(Direction dir) {
        return switch (dir) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST  -> SHAPE_EAST;
            case WEST  -> SHAPE_WEST;
            default    -> SHAPE_NORTH;
        };
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapeFor(state.getValue(FACING));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapeFor(state.getValue(FACING));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            stopActiveSound(pos);

            float pitch = 1.0f + level.getRandom().nextFloat() * 0.25f - 0.1f;
            SoundInstance instance = new SimpleSoundInstance(
                plushSound.getLocation(), SoundSource.BLOCKS, 0.5f, pitch,
                level.getRandom(), false, 0, SoundInstance.Attenuation.LINEAR,
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, false
            );
            Minecraft.getInstance().getSoundManager().play(instance);
            ACTIVE_SOUNDS.put(pos.immutable(), instance);
        } else {
            level.playSound(player, pos, plushSound, SoundSource.BLOCKS, 0.5f, 1.0f);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (level.isClientSide() && !state.is(newState.getBlock())) {
            stopActiveSound(pos);
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    private static void stopActiveSound(BlockPos pos) {
        SoundInstance sound = ACTIVE_SOUNDS.remove(pos);
        if (sound != null) {
            Minecraft.getInstance().getSoundManager().stop(sound);
        }
    }
    public static void cleanupActiveSounds() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        ACTIVE_SOUNDS.entrySet().removeIf(entry -> {
            if (!(mc.level.getBlockState(entry.getKey()).getBlock() instanceof PlushBlock)) {
                mc.getSoundManager().stop(entry.getValue());
                return true;
            }
            return false;
        });
    }
}
