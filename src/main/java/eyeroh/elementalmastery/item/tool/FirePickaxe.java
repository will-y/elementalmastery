package eyeroh.elementalmastery.item.tool;

import java.util.List;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootTable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class FirePickaxe extends PickaxeItem {
	public FirePickaxe() {
		super(ToolMaterials.FIRE, 4, 2.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {		
            stack.damageItem(1, entityLiving, t -> {});
            
            if(this.canHarvestBlock(state)) {
				LootTable table = ServerLifecycleHooks.getCurrentServer().getLootTableManager().getLootTableFromLocation(state.getBlock().getLootTable());
				List<ItemStack> drops = table.generate(new LootContext.Builder(ServerLifecycleHooks.getCurrentServer().func_241755_D_()).build(table.getParameterSet()));

				//TODO: Figure out how to get smelting recipes
//                ItemStack smelted = new ItemStack(FurnaceRecipes.instance().getSmeltingResult(itemStack).getItem());

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

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
}
