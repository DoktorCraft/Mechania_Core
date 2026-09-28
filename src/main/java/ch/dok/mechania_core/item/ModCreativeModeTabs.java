package ch.dok.mechania_core.item;

import ch.dok.mechania_core.Mechania_core;
import ch.dok.mechania_core.block.ModBlocks;
import ch.dok.mechania_core.item.ModItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mechania_core.MODID);

    public static final Supplier<CreativeModeTab> MECHANIA_CORE = CREATIVE_MODE_TAB.register("mechania_core",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.MECHANIUM_FRAGMENT.get()))
                    .title(Component.translatable("creativetab.mechania_core"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItem.MECHANIUM_INGOT);
                        output.accept(ModItem.MECHANIUM_CRYSTAL);
                        output.accept(ModItem.MECHANIUM_NUGGET);
                        output.accept(ModItem.MECHANIUM_SHEET);
                        output.accept(ModItem.NEPTUNIUM_INGOT);
                        output.accept(ModItem.YELLOWCAKE);
                        output.accept(ModItem.BLASTED_YELLOWCAKE);
                        output.accept(ModItem.MECHANIUM_FRAGMENT);
                        output.accept(ModItem.URANINIT);
                        output.accept(ModItem.URANIUM_HEXAFLOURITE);
                        output.accept(ModItem.CRUSHED_URANINIT);
                        output.accept(ModItem.PURE_URANIUM);
                        output.accept(ModItem.RAW_MECHANIUM_CRYSTAL);
                        output.accept(ModItem.PLUTONIUM_INGOT);
                        output.accept(ModItem.PALE_EYE);
                        output.accept(ModItem.ARCANEAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.BIOLOGICAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.SUBTERRESTIAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.TERRESTIAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.CHEMICAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.DIMENSIONAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.ELECTRICAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.SYNTHETIC_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.MECHANICAL_MECHANIUM_FRAGMENT);
                        output.accept(ModItem.OMINOUS_CAVE_TABLET);
                        output.accept(ModBlocks.MECHANIUM_BLOCK);
                        output.accept(ModBlocks.ELECTROMAGNETIC_COIL);
                        output.accept(ModBlocks.NUCLEAR_CASING);
                        output.accept(ModBlocks.NUCLEAR_CONTROLLER);
                        output.accept(ModBlocks.BAUXITE_DEPOSIT);
                        output.accept(ModBlocks.LITHIUM_DEPOSIT);
                        output.accept(ModBlocks.ALEX_URANIUM_DEPOSIT);
                        output.accept(ModBlocks.SULFUR_DEPOSIT);
                        output.accept(ModBlocks.FLUORITE_DEPOSIT);
                        output.accept(ModBlocks.MANDARINE);
                        output.accept(ModBlocks.DOK_PLUSH);
                        output.accept(ModBlocks.LEON_PLUSH);
                        output.accept(ModBlocks.COVER_PLUSH);
                        output.accept(ModBlocks.LACHSI_PLUSH);
                        output.accept(ModBlocks.MADDIE_PLUSH);
                        output.accept(ModBlocks.METE_PLUSH);
                        output.accept(ModBlocks.FLOWERY_PLUSH);
                        output.accept(ModBlocks.NULL_PLUSH);
                        output.accept(ModBlocks.VERITY_PLUSH);
                        output.accept(ModBlocks.TUNG_PLUSH);
                        output.accept(ModBlocks.TRS_PLUSH);
                        output.accept(ModBlocks.JIME_PLUSH);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}