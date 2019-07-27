package eyeroh.elementalmastery;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModItems.dustOpal, new ItemStack(ModItems.gemOpal, 1), 1.5f);
		GameRegistry.addSmelting(ModItems.dustTopaz, new ItemStack(ModItems.gemTopaz, 1), 1.5f);
		GameRegistry.addSmelting(ModItems.dustRuby, new ItemStack(ModItems.gemRuby, 1), 1.5f);
		GameRegistry.addSmelting(ModItems.dustSapphire, new ItemStack(ModItems.gemSapphire, 1), 1.5f);
		GameRegistry.addSmelting(ModItems.dustMulti, new ItemStack(ModItems.gemMulti, 1), 1.5F);
	}

}
