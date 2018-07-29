package eyeroh.elementalmastery.mob;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpeedCreeper extends RenderLiving<EntitySpeedCreeper>{
	private ResourceLocation mobTexture = new ResourceLocation("elementalmastery:textures/entity/speedcreeper.png");

    public static final Factory FACTORY = new Factory();

    public RenderSpeedCreeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCreeper(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntitySpeedCreeper entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntitySpeedCreeper> {

        @Override
        public Render<? super EntitySpeedCreeper> createRenderFor(RenderManager manager) {
            return new RenderSpeedCreeper(manager);
        }
    }
}
