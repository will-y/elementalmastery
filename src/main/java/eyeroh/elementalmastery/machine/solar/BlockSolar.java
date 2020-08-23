package eyeroh.elementalmastery.machine.solar;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSolar extends Block {
    public BlockSolar(String name) {
        super(Material.IRON);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.METAL);
        setUnlocalizedName(ElementalMastery.MODID + "." + name);
        setRegistryName(name);
        this.setCreativeTab(ModMachines.tabGemMachines);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
