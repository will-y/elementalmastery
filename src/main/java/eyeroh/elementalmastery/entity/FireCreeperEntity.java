package eyeroh.elementalmastery.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.List;

public class FireCreeperEntity extends CreeperEntity {

    public FireCreeperEntity(EntityType<? extends CreeperEntity> type, World worldIn) {
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

            List<Entity> entityList  = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(x-5, y-5, z-5, x+5, y+5, z+5));

            entityList.forEach(entity -> {
            	if(!entity.func_230279_az_()) {
            		entity.setFire(5);
            	}
            });

            this.world.createExplosion(null, x, y, z, 5, true, Explosion.Mode.NONE);
            this.remove();
        }

    }
}
