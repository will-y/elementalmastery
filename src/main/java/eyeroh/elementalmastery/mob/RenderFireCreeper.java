package eyeroh.elementalmastery.mob;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFireCreeper extends RenderLiving<EntityFireCreeper>{
	private ResourceLocation mobTexture = new ResourceLocation("elementalmastery:textures/entity/firecreeper.png");

    public static final Factory FACTORY = new Factory();

    public RenderFireCreeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCreeper(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityFireCreeper entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityFireCreeper> {

        @Override
        public Render<? super EntityFireCreeper> createRenderFor(RenderManager manager) {
            return new RenderFireCreeper(manager);
        }
    }
}
