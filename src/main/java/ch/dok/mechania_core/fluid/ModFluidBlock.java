package ch.dok.mechania_core.fluid;

import ch.dok.mechania_core.fluid.ModFluid;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ch.dok.mechania_core.Mechania_core;

import java.util.function.Supplier;

public class ModFluidBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, Mechania_core.MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, Mechania_core.MODID);

    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_MECHANIUM_BLOCK =
            BLOCKS.register("molten_mechanium_block",
                    () -> new LiquidBlock(ModFluid.SOURCE_MOLTEN_MECHANIUM.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PURPLE)
                                    .replaceable()
                                    .noCollission()
                                    .strength(100.0F)
                                    .lightLevel(state -> 15)
                                    .noLootTable()
                                    .liquid()
                                    .sound(SoundType.BASALT)
                    )
            );
    public static final DeferredHolder<Block, LiquidBlock> UNREFINED_MOLTEN_MECHANIUM_BLOCK =
            BLOCKS.register("unrefined_molten_mechanium_block",
                    () -> new LiquidBlock(ModFluid.SOURCE_UNREFINED_MOLTEN_MECHANIUM.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PURPLE)
                                    .replaceable()
                                    .noCollission()
                                    .strength(100.0F)
                                    .lightLevel(state -> 15)
                                    .noLootTable()
                                    .liquid()
                                    .sound(SoundType.BASALT)
                    )
            );
    public static final DeferredHolder<Block, LiquidBlock> MOLTEN_GUNMETAL_BLOCK =
            BLOCKS.register("molten_gunmetal_block",
                    () -> new LiquidBlock(ModFluid.SOURCE_MOLTEN_GUNMETAL.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GRAY)
                                    .replaceable()
                                    .noCollission()
                                    .strength(100.0F)
                                    .lightLevel(state -> 15)
                                    .noLootTable()
                                    .liquid()
                                    .sound(SoundType.BASALT)
                    )
            );
    public static final DeferredHolder<Block, LiquidBlock> URANIUM_SOLUTION_BLOCK =
            BLOCKS.register("uranium_solution",
                    () -> new LiquidBlock(ModFluid.SOURCE_URANIUM_SOLUTION.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GREEN)
                                    .replaceable()
                                    .noCollission()
                                    .strength(100.0F)
                                    .lightLevel(state -> 15)
                                    .noLootTable()
                                    .liquid()
                                    .sound(SoundType.BASALT)
                    )
            );
    public static final DeferredHolder<Block, LiquidBlock> URANIUM_SLURRY_BLOCK =
            BLOCKS.register("uranium_slurry",
                    () -> new LiquidBlock(ModFluid.SOURCE_URANIUM_SLURRY.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GREEN)
                                    .replaceable()
                                    .noCollission()
                                    .strength(100.0F)
                                    .lightLevel(state -> 15)
                                    .noLootTable()
                                    .liquid()
                                    .sound(SoundType.BASALT)
                    )
            );

    private static DeferredHolder<Block, Block> registerBlock(String name, Supplier<Block> block) {
        DeferredHolder<Block, Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredHolder<T, T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}