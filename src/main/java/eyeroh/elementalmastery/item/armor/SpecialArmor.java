package eyeroh.elementalmastery.item.armor;

import java.util.ArrayList;
import java.util.List;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpecialArmor extends ItemArmor{
	
	private boolean[] returnArray = new boolean[] {false, false, false, false};
	private int timer = 400;
	
	public SpecialArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if(!world.isRemote && this.armorType == EntityEquipmentSlot.HEAD) {
			timer++;
			if(timer >= 395) {
				if(this.getArmorMaterial() == ModArmor.ARMORMATERIALSPEED) {
					if(checkArmor(player.getArmorInventoryList(), "Speed")) {
						applyPotion(player, 1, 800, 2);
						applyPotion(player, 3, 800, 1);
						applyPotion(player, 18, 800, 0);
						timer = 0;
					}
				} else if (this.getArmorMaterial() == ModArmor.ARMORMATERIALFIRE) {
					if(checkArmor(player.getArmorInventoryList(), "Fire")) {
						applyPotion(player, 12, 800, 0);
						timer = 0;
					}
				} else if (this.getArmorMaterial() == ModArmor.ARMORMATERIALHEAL) {
					if(checkArmor(player.getArmorInventoryList(), "Healing")) {
						applyPotion(player, 10, 100, 0);
						applyPotion(player, 22, 800, 0);
						applyPotion(player, 4, 800, 0);
						timer = 0;
					}
				} else if(this.getArmorMaterial() == ModArmor.ARMORMATERIALSTRENGTH) {
					if(checkArmor(player.getArmorInventoryList(), "Strength")) {
						applyPotion(player, 5, 800, 2);
						applyPotion(player, 11, 800, 1);
						applyPotion(player, 2, 800, 0);
						timer = 0;
					}
				}
				
			}
		}
	}
	
	public boolean checkArmor(Iterable<ItemStack> itemStack, String name) {
		resetArray();
		itemStack.forEach(item -> {
			
			if(item.getItem().getItemStackDisplayName(item).equals(name + " Helmet")) {
				returnArray[0] = true;
			} else if(item.getItem().getItemStackDisplayName(item).equals(name + " Chestplate")) {
				returnArray[1] = true; 
			} else if (item.getItem().getItemStackDisplayName(item).equals(name + " Leggings")) {
				returnArray[2] = true;
			} else if (item.getItem().getItemStackDisplayName(item).equals(name + " Boots")) {
				returnArray[3] = true;
			}
		});
		
		for (int j = 0; j < returnArray.length; j++) {
			if(returnArray[j] == false) {
				return false;
			}
		}
		
		return true;
	}
	
	private void resetArray() {
		for(int i = 0; i > returnArray.length; i++) {
			returnArray[i] = false;
		}
	}
	
	private void applyPotion(EntityPlayer player, int potion, int duration, int level) {
		player.addPotionEffect(new PotionEffect(Potion.getPotionById(potion), duration, level, true, false));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
