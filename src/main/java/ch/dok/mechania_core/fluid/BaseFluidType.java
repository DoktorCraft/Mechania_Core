package ch.dok.mechania_core.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class BaseFluidType extends FluidType {
    private final ResourceLocation stillTexture;
    private final ResourceLocation flowingTexture;
    private final ResourceLocation overlayTexture;
    private final int tintColor;
    private final Vector3f fogColor;

    public BaseFluidType(ResourceLocation stillTexture, ResourceLocation flowingTexture,
                         ResourceLocation overlayTexture, int tintColor,
                         Vector3f fogColor, Properties properties) {
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.overlayTexture = overlayTexture;
        this.tintColor = tintColor;
        this.fogColor = fogColor;
    }

    public ResourceLocation getStillTexture(){
        return stillTexture;
    }

    public ResourceLocation getFlowingTexture(){
        return flowingTexture;
    }

    public ResourceLocation getOverlayTexture(){
        return overlayTexture;
    }

    public int getTintColor(){
        return tintColor;
    }

    public Vector3f getFogColor(){
        return fogColor;
    }
}