package eyeroh.elementalmastery.item.tool;

import java.util.Random;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class StrengthAxe extends ItemAxe{
	public StrengthAxe(String name) {
		super(ModTools.TOOLMATERIALSTRENGTH, 8.0f, -3.0f);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }
	
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving);
            
            checkForWood(pos, world, entityLiving, stack);
            
        }

        return true;
    }
	
	private void checkForWood(BlockPos pos, World world, EntityLivingBase entityLiving, ItemStack stack) {
		for (int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				for(int k = -1; k < 2; k++) {
					if(OreDictionary.getOres("logWood").toString().contains((new ItemStack(world.getBlockState(pos.add(i, j, k)).getBlock(), 1, OreDictionary.WILDCARD_VALUE)).toString()) ) {
						if(stack.getMaxDamage() - stack.getItemDamage() > 0) {
							world.destroyBlock(pos.add(i, j, k), true);
							stack.damageItem(1, entityLiving);
							checkForWood(pos.add(i, j, k), world, entityLiving, stack);
						}
						
					}
				}
			}
		}
	}
}
