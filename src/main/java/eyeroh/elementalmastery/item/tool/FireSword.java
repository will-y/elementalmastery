package eyeroh.elementalmastery.item.tool;

import java.util.Random;

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

public class FireSword extends ItemSword{
	
	public FireSword() {
		super(ModTools.TOOLMATERIALFIRE);
		this.setRegistryName("firesword");
		this.setUnlocalizedName(ElementalMastery.MODID + ".firesword");
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);

        Random rand = new Random();
        if(rand.nextInt(10) > 3) {
        	target.setFire(10);
        }
        return true;
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