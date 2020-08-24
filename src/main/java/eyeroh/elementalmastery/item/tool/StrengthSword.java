package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class StrengthSword extends SwordItem {
	
	public StrengthSword() {
		super(ToolMaterials.STRENGTH, (int) ToolMaterials.STRENGTH.getAttackDamage(), 2.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});

        if(target.getHealth() <= 0) {
        	attacker.addPotionEffect(getStrongPotionEffect());
        	attacker.addPotionEffect(getStrongPotionEffect2());
        } else {
        	attacker.addPotionEffect(getPotionEffect());
        }
        return true;
    }

	public EffectInstance getPotionEffect() {
		return new EffectInstance(Effects.STRENGTH, 100, 1);
	}

	public EffectInstance getStrongPotionEffect() {
		return new EffectInstance(Effects.STRENGTH, 500, 3);
	}

	public EffectInstance getStrongPotionEffect2() {
		return new EffectInstance(Effects.RESISTANCE, 500, 3);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

}