package eyeroh.elementalmastery.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

import java.util.List;

public class HealCreeperEntity extends CreeperEntity {

    public HealCreeperEntity(EntityType<? extends CreeperEntity> type, World worldIn) {
        super(type, worldIn);
        super.fuseTime = 30;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, 0.25F).func_233815_a_(Attributes.field_233818_a_, 20.0D);
    }

    // isImmuneToFire
    @Override
    public boolean func_230279_az_() {
        return true;
    }

    @Override
    public void explode() {
        if (!this.world.isRemote) {
            this.dead = true;

            double x = this.getPosX();
            double y= this.getPosY();
            double z = this.getPosZ();

            this.world.playSound(null, x, y, z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.HOSTILE, 1, 1);

            List<Entity> entityList  = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(x-5, y-5, z-5, x+5, y+5, z+5));

            entityList.forEach(entity -> {
            	if (entity instanceof MonsterEntity) {
                    ((LivingEntity) entity).heal(10);
                } else if (entity instanceof  LivingEntity) {
                    ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, 100, 1));
                }
            });
            this.remove();
        }

    }
}
