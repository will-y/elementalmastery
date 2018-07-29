package eyeroh.elementalmastery.item.tool;

import java.util.Random;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class FireAxe extends ItemAxe{
	public FireAxe() {
		super(ModTools.TOOLMATERIALFIRE, 8.0f, -3.0f);
		this.setRegistryName("fireaxe");
		this.setUnlocalizedName(ElementalMastery.MODID + ".fireaxe");
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving);
            
            if(this.getStrVsBlock(stack, state) == this.efficiencyOnProperMaterial) {
            	if(OreDictionary.getOres("logWood").toString().contains((new ItemStack(state.getBlock(), 1, OreDictionary.WILDCARD_VALUE)).toString()) ) {
            		ItemStack itemStack2 = new ItemStack(Items.COAL, 1, 1);
                	world.setBlockToAir(pos);
                	EntityItem unsmelted = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                	world.spawnEntity(unsmelted);
                	return true;
            	}
            }
        }
        return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);

        Random rand = new Random();
        if(rand.nextInt(10) > 6) {
        	target.setFire(10);
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
