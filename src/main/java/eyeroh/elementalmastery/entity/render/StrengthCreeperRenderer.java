package eyeroh.elementalmastery.entity.render;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;

public class StrengthCreeperRenderer extends CreeperRenderer {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ElementalMastery.MODID, "textures/entity/strengthcreeper.png");

    public StrengthCreeperRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(CreeperEntity entity) {
        return TEXTURE;
    }
}
