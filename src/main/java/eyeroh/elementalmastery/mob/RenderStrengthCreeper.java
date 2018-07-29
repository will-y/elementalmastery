package eyeroh.elementalmastery.mob;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStrengthCreeper extends RenderLiving<EntityStrengthCreeper>{
	private ResourceLocation mobTexture = new ResourceLocation("elementalmastery:textures/entity/strengthcreeper.png");

    public static final Factory FACTORY = new Factory();

    public RenderStrengthCreeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCreeper(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityStrengthCreeper entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityStrengthCreeper> {

        @Override
        public Render<? super EntityStrengthCreeper> createRenderFor(RenderManager manager) {
            return new RenderStrengthCreeper(manager);
        }
    }
}
