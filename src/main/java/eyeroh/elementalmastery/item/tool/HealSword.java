package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HealSword extends ItemSword{
	
	private float healAmount = 0;
	
	public HealSword() {
		super(ModTools.TOOLMATERIALHEAL);
		this.setRegistryName("healsword");
		this.setUnlocalizedName(ElementalMastery.MODID + ".healsword");
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        
        healAmount = this.getAttackDamage()/3;
        
        attacker.heal(healAmount);
        
        if(target.getHealth() <= 0) {
        	attacker.addPotionEffect(this.getPotionEffect());
        }
        return true;
    }
	
	public PotionEffect getPotionEffect() {
		return new PotionEffect(Potion.getPotionById(10), 40, 1);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}