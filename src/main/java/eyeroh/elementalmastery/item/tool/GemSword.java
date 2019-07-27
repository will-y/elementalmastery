package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemSword extends ItemSword{
	public GemSword(String name) {
		super(ModTools.TOOLMATERIALGEM);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
