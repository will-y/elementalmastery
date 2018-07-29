package eyeroh.elementalmastery.item;

import net.minecraft.item.ItemStack;

public class GemShinyItem extends GemItem{

	public GemShinyItem(String name) {
		super(name);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }

}
