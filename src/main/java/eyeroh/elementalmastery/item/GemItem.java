package eyeroh.elementalmastery.item;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemItem extends Item{
	public GemItem(String name) {
		setRegistryName(name);
		setUnlocalizedName(ElementalMastery.MODID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
