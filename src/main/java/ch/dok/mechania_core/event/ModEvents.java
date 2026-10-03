package ch.dok.mechania_core.event;

import ch.dok.mechania_core.Mechania_core;
import ch.dok.mechania_core.fluid.fluids.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.fluids.FluidType;

@EventBusSubscriber(modid = Mechania_core.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (entity.level().isClientSide()) return;

        FluidState fluid = entity.level().getFluidState(entity.blockPosition());
        if (!fluid.isEmpty() && isMoltenFluid(fluid.getType().getFluidType())) {
            entity.setRemainingFireTicks(80);
            if (entity instanceof LivingEntity living) {
                living.hurt(entity.damageSources().lava(), 4.0f);
            }
        }
    }

    private static boolean isMoltenFluid(FluidType type) {
        return type == MoltenMechanium.MOLTEN_MECHANIUM_FLUID_TYPE.get()
            || type == UnrefinedMoltenMechanium.UNREFINED_MOLTEN_MECHANIUM_FLUID_TYPE.get()
            || type == UraniumSlurry.URANIUM_SLURRY_FLUID_TYPE.get()
            || type == UraniumSolution.URANIUM_SOLUTION_FLUID_TYPE.get()
            || type == MoltenGunmetal.MOLTEN_GUNMETAL_FLUID_TYPE.get();
    }
}
