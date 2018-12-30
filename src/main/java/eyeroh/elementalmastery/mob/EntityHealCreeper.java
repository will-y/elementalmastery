package eyeroh.elementalmastery.mob;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityHealCreeper extends EntityGemCreeper{
	
	public static final ResourceLocation LOOT = new ResourceLocation(ElementalMastery.MODID, "entities/healcreeper");

	public EntityHealCreeper(World worldIn) {
		super(worldIn, "healcreeper", 3, 30, EntityHealCreeper.class);
	}
	
	@Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return LOOT;
    }
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }
	
	@Override
	public void explode() {
		if (!this.world.isRemote) {
			double x = this.posX;
	        double y= this.posY;
	        double z = this.posZ;
            boolean flag = this.world.getGameRules().getBoolean("mobGriefing");
            Random rand = new Random();
            this.dead = true;
            this.setDead();
            
           /*for (int i = 0; i < 1000; i++) {
        	   double d1 =  x + rand.nextInt(4) - 2;
        	   double d2 =  y + rand.nextInt(4) - 2;
        	   double d3 =  z + rand.nextInt(4) - 2;
        	   this.world.spawnParticle(EnumParticleTypes.NOTE, x+1, y, z, rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
           }*/
           
            this.world.playSound((EntityPlayer)null, x, y, z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
            List<Entity> entityList  = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(x-5, y-5, z-5, x+5, y+5, z+5));
            
            entityList.forEach(entity -> {
            	if(entity.isCreatureType(EnumCreatureType.MONSTER, false)) {
            		((EntityLivingBase) entity).heal(10);
            	} else if(entity.isCreatureType(EnumCreatureType.CREATURE, false)) {
            		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.getPotionById(19), 55, 1));
            	} else if(entity instanceof EntityPlayer) {
            		((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.getPotionById(19), 55, 1));
            	}
            });
            
        }
	}
}
