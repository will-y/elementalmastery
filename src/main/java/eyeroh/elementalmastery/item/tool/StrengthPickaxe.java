package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StrengthPickaxe extends ItemPickaxe{
	public StrengthPickaxe(String name) {
		super(ModTools.TOOLMATERIALSTRENGTH);
		this.setRegistryName(name);
		this.setUnlocalizedName(ElementalMastery.MODID + "." + name);
		this.setCreativeTab(ModItems.tabGemTools);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving);
            
            RayTraceResult rayTrace = this.rayTrace(world, (EntityPlayer) entityLiving, false);
            
            EnumFacing facing = rayTrace.sideHit;
            
            BlockPos[] posArray;
            posArray = new BlockPos[8];
            
            if(facing == EnumFacing.SOUTH || facing == EnumFacing.NORTH) {
            	posArray[0] = pos.add(1, 0, 0);
            	posArray[1] = pos.add(1, 1, 0);
            	posArray[2] = pos.add(1, -1, 0);
            	posArray[3] = pos.add(0, 1, 0);
            	posArray[4] = pos.add(0, -1, 0);
            	posArray[5] = pos.add(-1, 0, 0);
            	posArray[6] = pos.add(-1, 1, 0);
            	posArray[7] = pos.add(-1, -1, 0);
            } else  if(facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
            	posArray[0] = pos.add(0, 1, 1);
            	posArray[1] = pos.add(0, 1, 0);
            	posArray[2] = pos.add(0, 1, -1);
            	posArray[3] = pos.add(0, 0, -1);
            	posArray[4] = pos.add(0, 0, 1);
            	posArray[5] = pos.add(0, -1, 1);
            	posArray[6] = pos.add(0, -1, 0);
            	posArray[7] = pos.add(0, -1, -1);
            } else if(facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
            	posArray[0] = pos.add(1, 0, 1);
            	posArray[1] = pos.add(1, 0, 0);
            	posArray[2] = pos.add(1, 0, -1);
            	posArray[3] = pos.add(0, 0, 1);
            	posArray[4] = pos.add(0, 0, -1);
            	posArray[5] = pos.add(-1, 0, 1);
            	posArray[6] = pos.add(-1, 0, 0);
            	posArray[7] = pos.add(-1, 0, -1);
            }
            
            for(int i = 0; i < 8; i++) {
            	Material material = world.getBlockState(posArray[i]).getMaterial();
            	
            	if(material == Material.ANVIL || material == Material.ROCK || material == Material.IRON) {
            		if(stack.getMaxDamage() - stack.getItemDamage() > 0) {
            			stack.damageItem(1, entityLiving);
            			world.destroyBlock(posArray[i], true);
            		}
            		  
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
