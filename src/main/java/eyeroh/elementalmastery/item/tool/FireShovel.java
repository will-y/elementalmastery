package eyeroh.elementalmastery.item.tool;

import java.util.Random;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireShovel extends ItemSpade{
	public FireShovel() {
		super(ModTools.TOOLMATERIALFIRE);
		this.setRegistryName("fireshovel");
		this.setUnlocalizedName(ElementalMastery.MODID + ".fireshovel");
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving);
            
            if(this.getStrVsBlock(stack, state) == this.efficiencyOnProperMaterial) {
            	ItemStack itemStack = new ItemStack(state.getBlock().getItemDropped(state, new Random(), 0));
          
                ItemStack smelted = new ItemStack(FurnaceRecipes.instance().getSmeltingResult(itemStack).getItem());
                
                if(!smelted.isEmpty()) {
                	world.setBlockToAir(pos);
                	EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), smelted);
                	world.spawnEntity(entityItem);
                	return true;
                } else {
                	world.setBlockToAir(pos);
                	EntityItem unsmelted = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                	world.spawnEntity(unsmelted);
                	return true;
                }
            }
        }
        return true;
    }
	
	
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
