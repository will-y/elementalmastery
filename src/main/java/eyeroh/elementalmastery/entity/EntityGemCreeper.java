package eyeroh.elementalmastery.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityGemCreeper extends MobEntity {
	private static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityGemCreeper.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.<Boolean>createKey(EntityGemCreeper.class, DataSerializers.BOOLEAN);
    
   
    /**
     * Time when this creeper was last in an active state (Messed up code here, probably causes creeper animation to go
     * weird)
     */
    private int lastActiveTime;
    /** The amount of time since the creeper was close enough to the player to ignite */
    private int timeSinceIgnited;
    //default 30
    private int fuseTime;
    // default 3
    private int explosionRadius;
    private int droppedSkulls;

    public EntityGemCreeper(World worldIn, String name, int explosion, int fuse, Class creeperClass) {
        super(EntityType.CREEPER, worldIn);
        this.explosionRadius = explosion;
        this.fuseTime = fuse;
       // this.setSize(0.6F, 1.7F);
    }

    protected void initEntityAI()
    {
//        this.tasks.addTask(1, new EntityAISwimming(this));
//        this.tasks.addTask(2, new EntitiyAIGemCreeperSwell(this));
//        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
//        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
//        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
//        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
//        this.tasks.addTask(6, new EntityAILookIdle(this));
//        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
//        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
    
//    @Override
//    protected boolean isValidLightLevel() {
//        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
//
//        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
//        {
//            return false;
//        }
//        else
//        {
//            int i = this.world.getLightFromNeighbors(blockpos);
//
//            if (this.world.isThundering())
//            {
//                int j = this.world.getSkylightSubtracted();
//                this.world.setSkylightSubtracted(10);
//                i = this.world.getLightFromNeighbors(blockpos);
//                this.world.setSkylightSubtracted(j);
//            }
//
//            return i <= this.rand.nextInt(8);
//        }
//    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
//    protected void applyEntityAttributes()
//    {
//        super.applyEntityAttributes();
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
//    }

    /**
     * The maximum height from where the entity is alowed to jump (used in pathfinder)
     */
//    public int getMaxFallHeight()
//    {
//        return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
//    }

//    public void fall(float distance, float damageMultiplier)
//    {
//        super.fall(distance, damageMultiplier);
//        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);
//
//        if (this.timeSinceIgnited > this.fuseTime - 5)
//        {
//            this.timeSinceIgnited = this.fuseTime - 5;
//        }
//    }
//
//    protected void entityInit()
//    {
//        super.entityInit();
//        this.dataManager.register(STATE, Integer.valueOf(-1));
//        this.dataManager.register(IGNITED, Boolean.valueOf(false));
//    }

    /*public static void registerFixesCreeper(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityStrengthCreeper.class);
    }*/

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
//    public void writeEntityToNBT(NBTTagCompound compound)
//    {
//        super.writeEntityToNBT(compound);
//
//        compound.setShort("Fuse", (short)this.fuseTime);
//        compound.setByte("ExplosionRadius", (byte)this.explosionRadius);
//        compound.setBoolean("ignited", this.hasIgnited());
//    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
//    public void readEntityFromNBT(NBTTagCompound compound)
//    {
//        super.readEntityFromNBT(compound);
//
//        if (compound.hasKey("Fuse", 99))
//        {
//            this.fuseTime = compound.getShort("Fuse");
//        }
//
//        if (compound.hasKey("ExplosionRadius", 99))
//        {
//            this.explosionRadius = compound.getByte("ExplosionRadius");
//        }
//
//        if (compound.getBoolean("ignited"))
//        {
//            this.ignite();
//        }
//    }

    /**
     * Called to update the entity's position/logic.
     */
//    public void onUpdate()
//    {
//        if (this.isEntityAlive())
//        {
//            this.lastActiveTime = this.timeSinceIgnited;
//
//            if (this.hasIgnited())
//            {
//                this.setCreeperState(1);
//            }
//
//            int i = this.getCreeperState();
//
//            if (i > 0 && this.timeSinceIgnited == 0)
//            {
//                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
//            }
//
//            this.timeSinceIgnited += i;
//
//            if (this.timeSinceIgnited < 0)
//            {
//                this.timeSinceIgnited = 0;
//            }
//
//            if (this.timeSinceIgnited >= this.fuseTime)
//            {
//                this.timeSinceIgnited = this.fuseTime;
//                this.explode();
//            }
//        }
//
//        super.onUpdate();
//    }
//
//    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
//    {
//        return SoundEvents.ENTITY_CREEPER_HURT;
//    }
//
//    protected SoundEvent getDeathSound()
//    {
//        return SoundEvents.ENTITY_CREEPER_DEATH;
//    }
//
//    /**
//     * Called when the mob's health reaches 0.
//     */
//    public void onDeath(DamageSource cause)
//    {
//        super.onDeath(cause);
//
//        if (this.world.getGameRules().getBoolean("doMobLoot"))
//        {
//            if (cause.getTrueSource() instanceof EntitySkeleton)
//            {
//                int i = Item.getIdFromItem(Items.RECORD_13);
//                int j = Item.getIdFromItem(Items.RECORD_WAIT);
//                int k = i + this.rand.nextInt(j - i + 1);
//                this.dropItem(Item.getItemById(k), 1);
//            }
//        }
//    }
//
//    public boolean attackEntityAsMob(Entity entityIn)
//    {
//        return true;
//    }
//
//    /**
//     * Params: (Float)Render tick. Returns the intensity of the creeper's flash when it is ignited.
//     */
//    @SideOnly(Side.CLIENT)
//    public float getCreeperFlashIntensity(float p_70831_1_)
//    {
//        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
//    }

    /**
     * Returns the current state of creeper, -1 is idle, 1 is 'in fuse'
     */
    public int getCreeperState()
    {
        return ((Integer)this.dataManager.get(STATE)).intValue();
    }

    /**
     * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
     */
    public void setCreeperState(int state)
    {
        this.dataManager.set(STATE, Integer.valueOf(state));
    }

//    protected boolean processInteract(EntityPlayer player, EnumHand hand)
//    {
//        ItemStack itemstack = player.getHeldItem(hand);
//
//        if (itemstack.getItem() == Items.FLINT_AND_STEEL)
//        {
//            this.world.playSound(player, this.posX, this.posY, this.posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
//            player.swingArm(hand);
//
//            if (!this.world.isRemote)
//            {
//                this.ignite();
//                itemstack.damageItem(1, player);
//                return true;
//            }
//        }
//
//        return super.processInteract(player, hand);
//    }

    /**
     * Creates an explosion as determined by this creeper's power and explosion radius.
     */
//    public void explode()
//    {
//        if (!this.world.isRemote)
//        {
//            boolean flag = this.world.getGameRules().getBoolean("mobGriefing");
//            this.dead = true;
//            this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, flag);
//            this.setDead();
//            this.spawnLingeringCloud();
//        }
//    }

//    private void spawnLingeringCloud()
//    {
//        Collection<PotionEffect> collection = this.getActivePotionEffects();
//
//        if (!collection.isEmpty())
//        {
//            EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
//            entityareaeffectcloud.setRadius(2.5F);
//            entityareaeffectcloud.setRadiusOnUse(-0.5F);
//            entityareaeffectcloud.setWaitTime(10);
//            entityareaeffectcloud.setDuration(entityareaeffectcloud.getDuration() / 2);
//            entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
//
//            for (PotionEffect potioneffect : collection)
//            {
//                entityareaeffectcloud.addEffect(new PotionEffect(potioneffect));
//            }
//
//            this.world.spawnEntity(entityareaeffectcloud);
//        }
//    }

    public boolean hasIgnited()
    {
        return ((Boolean)this.dataManager.get(IGNITED)).booleanValue();
    }

    public void ignite()
    {
        this.dataManager.set(IGNITED, Boolean.valueOf(true));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
//    public boolean isAIEnabled()
//    {
//        return this.droppedSkulls < 1 && this.world.getGameRules().getBoolean("doMobLoot");
//    }

    public void incrementDroppedSkulls()
    {
        ++this.droppedSkulls;
    }
}
