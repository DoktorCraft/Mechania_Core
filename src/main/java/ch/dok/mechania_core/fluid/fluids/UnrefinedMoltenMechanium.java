package ch.dok.mechania_core.fluid.fluids;

import ch.dok.mechania_core.fluid.BaseFluidType;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import ch.dok.mechania_core.Mechania_core;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class UnrefinedMoltenMechanium {
    public static final ResourceLocation UNREFINED_MOLTEN_MECHANIUM_STILL_RL = ResourceLocation.fromNamespaceAndPath(Mechania_core.MODID, "block/fluid_still");
    public static final ResourceLocation UNREFINED_MOLTEN_MECHANIUM_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(Mechania_core.MODID, "block/fluid_flow");
    public static final ResourceLocation UNREFINED_MOLTEN_MECHANIUM_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(Mechania_core.MODID, "misc/in_fluid");
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Mechania_core.MODID);

    public static final DeferredHolder<FluidType, FluidType> UNREFINED_MOLTEN_MECHANIUM_FLUID_TYPE = register("unrefined_molten_mechanium_fluid",
            FluidType.Properties.create()
                    .lightLevel(15)
                    .density(5000)
                    .viscosity(7500)
                    .temperature(2500)
                    .canConvertToSource(false)
                    .canExtinguish(false)
                    .canDrown(false)
                    .canSwim(false)
                    .sound(SoundAction.get("ambient"), SoundEvents.LAVA_AMBIENT)
    );

    private static DeferredHolder<FluidType, FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(
                UNREFINED_MOLTEN_MECHANIUM_STILL_RL,
                UNREFINED_MOLTEN_MECHANIUM_FLOWING_RL,
                UNREFINED_MOLTEN_MECHANIUM_OVERLAY_RL,
                0x660078,
                new Vector3f(0.0078f, 0.090f, 0.074f),
                properties
        ) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return ResourceLocation.fromNamespaceAndPath("mechania_core", "block/fluid_still");
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return ResourceLocation.fromNamespaceAndPath("mechania_core", "block/fluid_flow");
                    }

                    @Override
                    public ResourceLocation getOverlayTexture() {
                        return ResourceLocation.fromNamespaceAndPath("mechania_core", "misc/in_fluid");
                    }

                    @Override
                    public int getTintColor() {
                        return 0x660078;
                    }


                    @Override
                    public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level,
                                                   int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                        return new Vector3f(0.0078f, 0.090f, 0.074f);
                    }

                    @Override
                    public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance,
                                                float partialTick, float nearDistance, float farDistance, FogShape shape) {
                        RenderSystem.setShaderFogStart(0.0F);
                        RenderSystem.setShaderFogEnd(2.5F);
                        RenderSystem.setShaderFogShape(FogShape.SPHERE);
                    }

                });
            }
        });
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }


}