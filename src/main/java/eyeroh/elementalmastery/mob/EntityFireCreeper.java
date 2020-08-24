package eyeroh.elementalmastery.mob;

import java.util.List;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFireCreeper extends EntityGemCreeper{
	
	public static final ResourceLocation LOOT = new ResourceLocation(ElementalMastery.MODID, "entities/firecreeper");

	public EntityFireCreeper(World worldIn) {
		super(worldIn, "firecreeper", 3, 30, EntityFireCreeper.class);
	}
	
	@Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return LOOT;
    }
	
//	@Override
//	protected void applyEntityAttributes() {
//        super.applyEntityAttributes();
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
//    }
//
//	@Override
//	public void explode() {
//        if (!this.world.isRemote) {
//            boolean flag = this.world.getGameRules().getBoolean("mobGriefing");
//            this.dead = true;
//            this.setDead();
//
//            double x = this.posX;
//            double y= this.posY;
//            double z = this.posZ;
//
//            List<Entity> entityList  = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(x-5, y-5, z-5, x+5, y+5, z+5));
//
//            entityList.forEach(entity -> {
//            	if(!entity.isImmuneToFire()) {
//            		entity.setFire(5);
//            	}
//            });
//
//            this.world.newExplosion((Entity)null, x, y, z, 1.5f, flag, flag);
//
//        }
//  }
}
