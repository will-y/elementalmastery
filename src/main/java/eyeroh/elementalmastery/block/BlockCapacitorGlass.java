package eyeroh.elementalmastery.block;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCapacitorGlass extends BlockGlass{

	public BlockCapacitorGlass() {
		super(Material.GLASS, false);
		setUnlocalizedName(ElementalMastery.MODID + ".capacitorglass");
		setRegistryName("capacitorglass");
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
