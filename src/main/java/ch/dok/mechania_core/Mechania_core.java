package ch.dok.mechania_core;

import ch.dok.mechania_core.fluid.ModFluid;
import ch.dok.mechania_core.fluid.ModFluidBlock;
import ch.dok.mechania_core.fluid.ModFluidItem;
import ch.dok.mechania_core.fluid.fluids.*;
import ch.dok.mechania_core.item.ModCreativeModeTabs;
import ch.dok.mechania_core.sound.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import ch.dok.mechania_core.item.ModItem;
import ch.dok.mechania_core.block.ModBlocks;

@Mod(Mechania_core.MODID)
public class Mechania_core {
    public static final String MODID = "mechania_core";

    public Mechania_core(IEventBus modEventBus) {
        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModSounds.register(modEventBus);
        MoltenMechanium.register(modEventBus);
        UnrefinedMoltenMechanium.register(modEventBus);
        MoltenGunmetal.register(modEventBus);
        UraniumSlurry.register(modEventBus);
        UraniumSolution.register(modEventBus);
        ModFluid.register(modEventBus);
        ModFluidBlock.register(modEventBus);
        ModFluidItem.register(modEventBus);
    }
}
