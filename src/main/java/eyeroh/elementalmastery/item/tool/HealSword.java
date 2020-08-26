package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class HealSword extends SwordItem {
	
	private float healAmount = 0;
	
	public HealSword() {
		super(ToolMaterials.HEAL, 7, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});
        
        healAmount = this.getAttackDamage()/3;
        
        attacker.heal(healAmount);
        
        if(target.getHealth() <= 0) {
        	attacker.addPotionEffect(this.getPotionEffect());
        }
        return true;
    }
	
	public EffectInstance getPotionEffect() {
		return new EffectInstance(Effects.REGENERATION, 40, 1);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

}