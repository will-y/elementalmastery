package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

public class StrengthPickaxe extends PickaxeItem {
	public StrengthPickaxe() {
		super(ToolMaterials.STRENGTH, 4, 2.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && stack.canHarvestBlock(state)) {
            stack.damageItem(1, entityLiving, t -> {});
            
            BlockRayTraceResult rayTrace = rayTrace(world, (PlayerEntity) entityLiving, RayTraceContext.FluidMode.NONE);
            
            Direction facing = rayTrace.getFace();
            
            BlockPos[] posArray;
            posArray = new BlockPos[8];
            
            if (facing == Direction.SOUTH || facing == Direction.NORTH) {
            	posArray[0] = pos.add(1, 0, 0);
            	posArray[1] = pos.add(1, 1, 0);
            	posArray[2] = pos.add(1, -1, 0);
            	posArray[3] = pos.add(0, 1, 0);
            	posArray[4] = pos.add(0, -1, 0);
            	posArray[5] = pos.add(-1, 0, 0);
            	posArray[6] = pos.add(-1, 1, 0);
            	posArray[7] = pos.add(-1, -1, 0);
            } else if(facing == Direction.EAST || facing == Direction.WEST) {
            	posArray[0] = pos.add(0, 1, 1);
            	posArray[1] = pos.add(0, 1, 0);
            	posArray[2] = pos.add(0, 1, -1);
            	posArray[3] = pos.add(0, 0, -1);
            	posArray[4] = pos.add(0, 0, 1);
            	posArray[5] = pos.add(0, -1, 1);
            	posArray[6] = pos.add(0, -1, 0);
            	posArray[7] = pos.add(0, -1, -1);
            } else if(facing == Direction.UP || facing == Direction.DOWN) {
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
            	if(stack.canHarvestBlock(world.getBlockState(posArray[i])) && world.getBlockState(posArray[i]).getBlockHardness(world, posArray[i]) != -1.0f) {
            		System.out.println(world.getBlockState(posArray[i]));
            		if(stack.getMaxDamage() - stack.getDamage() > 0) {
            			stack.damageItem(1, entityLiving, t -> {});
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

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}
