package ch.dok.mechania_core.fluid;

import ch.dok.mechania_core.fluid.fluids.*;
import ch.dok.mechania_core.fluid.*;
import ch.dok.mechania_core.Mechania_core;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluid {
    public  static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Mechania_core.MODID);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_MOLTEN_MECHANIUM = FLUIDS.register("molten_mechanium_fluid",
            () -> new BaseFlowingFluid.Source(ModFluid.MOLTEN_MECHANIUM_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MOLTEN_MECHANIUM = FLUIDS.register("flowing_molten_mechanium_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluid.MOLTEN_MECHANIUM_FLUID_PROPERTIES));
    public static final BaseFlowingFluid.Properties MOLTEN_MECHANIUM_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            MoltenMechanium.MOLTEN_MECHANIUM_FLUID_TYPE, SOURCE_MOLTEN_MECHANIUM, FLOWING_MOLTEN_MECHANIUM)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModFluidBlock.MOLTEN_MECHANIUM_BLOCK)
            .bucket(ModFluidItem.MOLTEN_MECHANIUM_BUCKET);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_UNREFINED_MOLTEN_MECHANIUM = FLUIDS.register("molten_unrefined_mechanium_fluid",
            () -> new BaseFlowingFluid.Source(ModFluid.UNREFINED_MOLTEN_MECHANIUM_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_UNREFINED_MOLTEN_MECHANIUM = FLUIDS.register("flowing_unrefined_molten_mechanium_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluid.UNREFINED_MOLTEN_MECHANIUM_FLUID_PROPERTIES));
    public static final BaseFlowingFluid.Properties UNREFINED_MOLTEN_MECHANIUM_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            UnrefinedMoltenMechanium.UNREFINED_MOLTEN_MECHANIUM_FLUID_TYPE, SOURCE_UNREFINED_MOLTEN_MECHANIUM, FLOWING_UNREFINED_MOLTEN_MECHANIUM)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModFluidBlock.UNREFINED_MOLTEN_MECHANIUM_BLOCK)
            .bucket(ModFluidItem.UNREFINED_MOLTEN_MECHANIUM_BUCKET);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_MOLTEN_GUNMETAL = FLUIDS.register("molten_gunmetal_fluid",
            () -> new BaseFlowingFluid.Source(ModFluid.MOLTEN_GUNMETAL_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MOLTEN_GUNMETAL = FLUIDS.register("flowing_molten_gunmetal_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluid.MOLTEN_GUNMETAL_FLUID_PROPERTIES));
    public static final BaseFlowingFluid.Properties MOLTEN_GUNMETAL_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            MoltenGunmetal.MOLTEN_GUNMETAL_FLUID_TYPE, SOURCE_MOLTEN_GUNMETAL, FLOWING_MOLTEN_GUNMETAL)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModFluidBlock.MOLTEN_GUNMETAL_BLOCK)
            .bucket(ModFluidItem.MOLTEN_GUNMETAL_BUCKET);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_URANIUM_SOLUTION = FLUIDS.register("uranium_solution_fluid",
            () -> new BaseFlowingFluid.Source(ModFluid.URANIUM_SOLUTION_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_URANIUM_SOLUTION = FLUIDS.register("flowing_uranium_solution_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluid.URANIUM_SOLUTION_FLUID_PROPERTIES));
    public static final BaseFlowingFluid.Properties URANIUM_SOLUTION_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            UraniumSolution.URANIUM_SOLUTION_FLUID_TYPE, SOURCE_URANIUM_SOLUTION, FLOWING_URANIUM_SOLUTION)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModFluidBlock.URANIUM_SOLUTION_BLOCK)
            .bucket(ModFluidItem.URANIUM_SOLUTION_BUCKET);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_URANIUM_SLURRY = FLUIDS.register("uranium_slurry_fluid",
            () -> new BaseFlowingFluid.Source(ModFluid.URANIUM_SLURRY_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_URANIUM_SLURRY = FLUIDS.register("flowing_uranium_slurry_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluid.URANIUM_SLURRY_FLUID_PROPERTIES));
    public static final BaseFlowingFluid.Properties URANIUM_SLURRY_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            UraniumSlurry.URANIUM_SLURRY_FLUID_TYPE, SOURCE_URANIUM_SLURRY, FLOWING_URANIUM_SLURRY)
            .slopeFindDistance(4)
            .levelDecreasePerBlock(2)
            .block(ModFluidBlock.URANIUM_SLURRY_BLOCK)
            .bucket(ModFluidItem.URANIUM_SLURRY_BUCKET);

    public static void register (IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}