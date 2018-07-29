package eyeroh.elementalmastery.mob;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpeedCreeper extends EntityGemCreeper{
	
	public static final ResourceLocation LOOT = new ResourceLocation(ElementalMastery.MODID, "entities/speedcreeper");

	public EntitySpeedCreeper(World worldIn) {
		super(worldIn, "strengthcreeper", 1, 15, EntitySpeedCreeper.class);
	}
	
	@Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return LOOT;
    }
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }
}
