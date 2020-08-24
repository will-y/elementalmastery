package eyeroh.elementalmastery.item.armor;

import java.util.Arrays;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SpecialArmor extends ArmorItem {
	
	private boolean[] returnArray = new boolean[] {false, false, false, false};
	private int timer = 400;
	
	public SpecialArmor(IArmorMaterial materialIn, EquipmentSlotType equipmentSlotIn) {
		super(materialIn, equipmentSlotIn, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!world.isRemote && this.getEquipmentSlot() == EquipmentSlotType.HEAD && entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
			timer++;
			if(timer >= 395) {
				if(this.getArmorMaterial() == ArmorMaterials.SPEED) {
					if(checkArmor(player.getArmorInventoryList(), "Speed")) {
						applyPotion(player, Effects.SPEED, 800, 2);
						applyPotion(player, Effects.HASTE, 800, 1);
						applyPotion(player, Effects.WEAKNESS, 800, 0);
						timer = 0;
					}
				} else if (this.getArmorMaterial() == ArmorMaterials.FIRE) {
					if(checkArmor(player.getArmorInventoryList(), "Fire")) {
						applyPotion(player, Effects.FIRE_RESISTANCE, 800, 0);
						timer = 0;
					}
				} else if (this.getArmorMaterial() == ArmorMaterials.HEAL) {
					if(checkArmor(player.getArmorInventoryList(), "Healing")) {
						applyPotion(player, Effects.REGENERATION, 100, 0);
						applyPotion(player, Effects.ABSORPTION, 800, 0);
						applyPotion(player, Effects.MINING_FATIGUE, 800, 0);
						timer = 0;
					}
				} else if(this.getArmorMaterial() == ArmorMaterials.STRENGTH) {
					if(checkArmor(player.getArmorInventoryList(), "Strength")) {
						applyPotion(player, Effects.STRENGTH, 800, 2);
						applyPotion(player, Effects.RESISTANCE, 800, 1);
						applyPotion(player, Effects.SLOWNESS, 800, 0);
						timer = 0;
					}
				}

			}
		}
	}
	
	public boolean checkArmor(Iterable<ItemStack> itemStack, String name) {
		resetArray();
		itemStack.forEach(item -> {
			if(item.getItem().getDisplayName(item).equals(name + " Helmet")) {
				returnArray[0] = true;
			} else if(item.getItem().getDisplayName(item).equals(name + " Chestplate")) {
				returnArray[1] = true; 
			} else if (item.getItem().getDisplayName(item).equals(name + " Leggings")) {
				returnArray[2] = true;
			} else if (item.getItem().getDisplayName(item).equals(name + " Boots")) {
				returnArray[3] = true;
			}
		});

		for (boolean b : returnArray) {
			if (!b) {
				return false;
			}
		}
		
		return true;
	}
	
	private void resetArray() {
		Arrays.fill(returnArray, false);
	}
	
	private void applyPotion(PlayerEntity player, Effect effect, int duration, int level) {
		player.addPotionEffect(new EffectInstance(effect, duration, level, true, false));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
