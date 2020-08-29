package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpeedSword extends SwordItem {
	
	public SpeedSword() {
		super(ToolMaterials.SPEED, 8, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});

        if(target.getHealth() <= 0) {
        	attacker.addPotionEffect(this.getStrongPotionEffect());
        } else {
        	attacker.addPotionEffect(this.getPotionEffect());
        }
        return true;
    }
	
	public EffectInstance getPotionEffect() {
		return new EffectInstance(Effects.SPEED, 100, 1);
	}
	
	public EffectInstance getStrongPotionEffect() {
		return new EffectInstance(Effects.SPEED, 500, 3);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}