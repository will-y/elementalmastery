package eyeroh.elementalmastery.mob;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHealCreeper extends RenderLiving<EntityHealCreeper>{
	private ResourceLocation mobTexture = new ResourceLocation("elementalmastery:textures/entity/healcreeper.png");

    public static final Factory FACTORY = new Factory();

    public RenderHealCreeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCreeper(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityHealCreeper entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<EntityHealCreeper> {

        @Override
        public Render<? super EntityHealCreeper> createRenderFor(RenderManager manager) {
            return new RenderHealCreeper(manager);
        }
    }
}
