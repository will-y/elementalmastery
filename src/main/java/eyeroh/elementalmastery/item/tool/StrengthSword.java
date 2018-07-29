package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
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

public class StrengthSword extends ItemSword{
	
	public StrengthSword() {
		super(ModTools.TOOLMATERIALSTRENGTH);
		this.setRegistryName("strengthsword");
		this.setUnlocalizedName(ElementalMastery.MODID + ".strengthsword");
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);

        if(target.getHealth() <= 0) {
        	attacker.addPotionEffect(getStrongPotionEffect());
        	attacker.addPotionEffect(getStrongPotionEffect2());
        } else {
        	attacker.addPotionEffect(getPotionEffect());
        }
        return true;
    }
	
	private PotionEffect getPotionEffect() {
		return new PotionEffect(Potion.getPotionById(5), 45, 1);
	}
	
	private PotionEffect getStrongPotionEffect() {
		return new PotionEffect(Potion.getPotionById(5), 500, 2);
	}
	
	private PotionEffect getStrongPotionEffect2() {
		return new PotionEffect(Potion.getPotionById(11), 500, 2);
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