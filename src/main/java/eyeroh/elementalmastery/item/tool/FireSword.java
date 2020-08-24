package eyeroh.elementalmastery.item.tool;

import java.util.Random;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class FireSword extends SwordItem {
	
	public FireSword() {
		super(ToolMaterials.FIRE, 8, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});

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
}