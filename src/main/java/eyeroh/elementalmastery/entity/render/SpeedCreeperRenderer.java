package eyeroh.elementalmastery.entity.render;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.entity.SpeedCreeperEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.util.ResourceLocation;

public class SpeedCreeperRenderer extends MobRenderer<SpeedCreeperEntity, CreeperModel<SpeedCreeperEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ElementalMastery.MODID, "textures/entity/speedcreeper.png");

    public SpeedCreeperRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CreeperModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(SpeedCreeperEntity entity) {
        return TEXTURE;
    }
}
