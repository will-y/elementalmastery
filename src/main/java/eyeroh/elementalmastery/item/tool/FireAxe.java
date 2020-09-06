package eyeroh.elementalmastery.item.tool;

import java.util.List;
import java.util.Random;

import eyeroh.elementalmastery.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class FireAxe extends AxeItem {
	public FireAxe() {
		super(ToolMaterials.FIRE, 8.0f, 3.0f, new Item.Properties().group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && (double)state.getBlockHardness(world, pos) != 0.0D) {
            stack.damageItem(1, entityLiving, t -> {});
			if (state.getHarvestTool() == ToolType.AXE || state.getHarvestTool() == null) {
				List<ItemStack> drops = state.getDrops(new LootContext.Builder((ServerWorld) world).withParameter(LootParameters.TOOL, stack).withParameter(LootParameters.field_237457_g_, entityLiving.func_241205_ce_()));
				for (ItemStack itemStack : drops) {
					Inventory inv = new Inventory(itemStack);
					if (world.getRecipeManager().getRecipe(IRecipeType.SMELTING, inv, world).isPresent()) {
						ItemStack smelted = world.getRecipeManager().getRecipe(IRecipeType.SMELTING, inv, world).get().getRecipeOutput();
						world.destroyBlock(pos, false);
						Block.spawnAsEntity(world, pos, smelted);
					}
				}
			}
        }
        return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, t -> {});

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

    @Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}
}
