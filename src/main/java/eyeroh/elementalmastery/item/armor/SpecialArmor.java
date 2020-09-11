package eyeroh.elementalmastery.item.armor;

import java.util.Arrays;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SpecialArmor extends ArmorItem {
	
	private boolean[] returnArray = new boolean[] {false, false, false, false};
	private int timer = 400;
	private IArmorMaterial material;
	
	public SpecialArmor(IArmorMaterial materialIn, EquipmentSlotType equipmentSlotIn, Item.Properties properties) {
		super(materialIn, equipmentSlotIn, properties.group(CreativeTabs.tabGemTools));
		this.material = materialIn;
	}

	public SpecialArmor(IArmorMaterial material, EquipmentSlotType equipmentSlotType) {
		this(material, equipmentSlotType, new Item.Properties());
	}
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!world.isRemote && this.getEquipmentSlot() == EquipmentSlotType.HEAD && entityIn instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityIn;
			timer++;
			if(timer >= 395) {
				if(this.getArmorMaterial() == ArmorMaterials.SPEED) {
					if(checkArmor(player.getArmorInventoryList(), material)) {
						applyPotion(player, Effects.SPEED, 800, 2);
						applyPotion(player, Effects.JUMP_BOOST, 800, 0);
						applyPotion(player, Effects.WEAKNESS, 800, 0);
					}
				} else if (this.getArmorMaterial() == ArmorMaterials.FIRE) {
					if(checkArmor(player.getArmorInventoryList(), material)) {
						applyPotion(player, Effects.FIRE_RESISTANCE, 800, 0);
					}
				} else if (this.getArmorMaterial() == ArmorMaterials.HEAL) {
					if(checkArmor(player.getArmorInventoryList(), material)) {
						applyPotion(player, Effects.REGENERATION, 100, 0);
						applyPotion(player, Effects.ABSORPTION, 800, 0);
						applyPotion(player, Effects.MINING_FATIGUE, 800, 0);
					}
				} else if(this.getArmorMaterial() == ArmorMaterials.STRENGTH) {
					if(checkArmor(player.getArmorInventoryList(), material)) {
						applyPotion(player, Effects.STRENGTH, 800, 2);
						applyPotion(player, Effects.RESISTANCE, 800, 1);
						applyPotion(player, Effects.SLOWNESS, 800, 0);
					}
				}
				timer = 0;
			}
		}
	}
	
	public boolean checkArmor(Iterable<ItemStack> itemStack, IArmorMaterial material) {
		for (ItemStack stack : itemStack) {
			if (stack.getItem() instanceof ElytraItem) {
				continue;
			}
			if (stack.getItem() instanceof ArmorItem) {
				ArmorItem newItem = (ArmorItem) stack.getItem();
				if (!newItem.getArmorMaterial().equals(material)) {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	private void applyPotion(PlayerEntity player, Effect effect, int duration, int level) {
		player.addPotionEffect(new EffectInstance(effect, duration, level, true, false));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}
