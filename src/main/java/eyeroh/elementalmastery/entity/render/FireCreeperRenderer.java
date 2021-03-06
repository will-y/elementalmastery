package eyeroh.elementalmastery.entity.render;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;

public class FireCreeperRenderer extends CreeperRenderer {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ElementalMastery.MODID, "textures/entity/firecreeper.png");

    public FireCreeperRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(CreeperEntity entity) {
        return TEXTURE;
    }
}
