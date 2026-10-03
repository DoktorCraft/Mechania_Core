package ch.dok.mechania_core.block;

import ch.dok.mechania_core.Mechania_core;
import ch.dok.mechania_core.item.ModItem;
import ch.dok.mechania_core.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import ch.dok.mechania_core.block.custom.PlushBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Mechania_core.MODID);

    public static final DeferredBlock<Block> MECHANIUM_BLOCK = registerBlock("mechanium_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ELECTROMAGNETIC_COIL = registerBlock("electromagnetic_coil",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> NUCLEAR_CASING = registerBlock("nuclear_casing",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> NUCLEAR_CONTROLLER = registerBlock("nuclear_controller",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BAUXITE_DEPOSIT = registerBlock("bauxite_deposit",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SULFUR_DEPOSIT = registerBlock("sulfur_deposit",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> LITHIUM_DEPOSIT = registerBlock("lithium_deposit",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> FLUORITE_DEPOSIT = registerBlock("fluorite_deposit",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> ALEX_URANIUM_DEPOSIT = registerBlock("alex_uranium_deposit",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MANDARINE = registerBlock("mandarine",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.METE_PLUSH.get()));
    public static final DeferredBlock<Block> METE_PLUSH = registerBlock("mete_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.METE_PLUSH.get()));
    public static final DeferredBlock<Block> DOK_PLUSH = registerBlock("dok_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.HDF_DOK.get()));
    public static final DeferredBlock<Block> LEON_PLUSH = registerBlock("leon_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.BIEN_PLUSH.get()));
    public static final DeferredBlock<Block> LACHSI_PLUSH = registerBlock("lachsi_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.LACHSI_PLUSH.get()));
    public static final DeferredBlock<Block> COVER_PLUSH = registerBlock("cover_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.COVER_PLUSH.get()));
    public static final DeferredBlock<Block> MADDIE_PLUSH = registerBlock("maddie_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.MADDIE_PLUSH.get()));
    public static final DeferredBlock<Block> FLOWERY_PLUSH = registerBlock("flowery_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.FLOWERY_PLUSH.get())); //Can you say Jarona?
    public static final DeferredBlock<Block> NULL_PLUSH = registerBlock("null_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.NULL_PLUSH.get()));
    public static final DeferredBlock<Block> VERITY_PLUSH = registerBlock("verity_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.VERITY_PLUSH.get()));
    public static final DeferredBlock<Block> TUNG_PLUSH = registerBlock("tung_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.TUNG_PLUSH.get()));
    public static final DeferredBlock<Block> TRS_PLUSH = registerBlock("trs_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.TRS_PLUSH.get()));
    public static final DeferredBlock<Block> JIME_PLUSH = registerBlock("jime_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.JIME_PLUSH.get()));
    public static final DeferredBlock<Block> JEB_PLUSH = registerBlock("jeb_plush",
            () -> new PlushBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.WOOL).noOcclusion(), ModSounds.JEB_PLUSH.get()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}