package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireShovel extends ShovelItem {
	public FireShovel() {
		super(ToolMaterials.FIRE, 8.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving, t -> {});
            
            if(this.canHarvestBlock(state)) {
            	// TODO: Figure out smelting
//            	ItemStack itemStack = new ItemStack(state.getBlock().getItemDropped(state, new Random(), 0));
//
//                ItemStack smelted = new ItemStack(FurnaceRecipes.instance().getSmeltingResult(itemStack).getItem());
//
//                if(!smelted.isEmpty()) {
//                	world.setBlockToAir(pos);
//                	EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), smelted);
//                	world.spawnEntity(entityItem);
//                	return true;
//                } else {
//                	world.setBlockToAir(pos);
//                	EntityItem unsmelted = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), itemStack);
//                	world.spawnEntity(unsmelted);
//                	return true;
//                }
            }
        }
        return true;
    }

	@Override
	public boolean hasEffect(ItemStack itemstack) {
        return true;
    }
}
