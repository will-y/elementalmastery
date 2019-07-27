package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GemAxe extends ItemAxe{
	public GemAxe(String name) {
		super(ModTools.TOOLMATERIALGEM, 8.0f, -3.0f);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
