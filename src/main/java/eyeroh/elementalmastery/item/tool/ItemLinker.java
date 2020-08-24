package eyeroh.elementalmastery.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.CreativeTabs;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import eyeroh.elementalmastery.machine.TileEnergyProvider;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

public class ItemLinker extends Item {
	
	public BlockPos blockStored = new BlockPos(0, 0, 0);
	
	public ItemLinker() {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(CreativeTabs.tabGemTools));
	}
	
	@Override
	public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
		PlayerEntity player = context.getPlayer();
		Hand hand = context.getHand();
		BlockPos pos = context.getPos();
		World world = context.getWorld();
		//if(!world.isRemote) {
		CompoundNBT nbt = player.getHeldItem(hand).getTag();
			if(nbt != null) {
				String toolTip = "No Block Linked";
				if(world.getBlockState(pos).getBlock().equals(ModMachines.CAPACITOR_CONTROLLER.get())) {
					blockStored = pos;
					toolTip = "Linked to Capacitor @ " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ();
					TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.capacitor_selected", toolTip);
    	            component.getStyle().func_240723_c_(TextFormatting.BLUE);
    	            player.sendStatusMessage(component, true);
				} else {
					blockStored = BlockPos.fromLong(nbt.getLong("position"));
				}
				if(blockStored.toLong() != 0) {
					TileEntity te = world.getTileEntity(pos);
					if(te instanceof TileEnergyProvider) {
						((TileEnergyProvider) te).setCapacitor(blockStored);
						TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.generator_linked", "Generator and Capacitor Linked");
	    	            component.getStyle().func_240723_c_(TextFormatting.BLUE);
	    	            player.sendStatusMessage(component, true);
					} else if(te instanceof TileEnergyAcceptor) {
						TileEntity te2 = world.getTileEntity(blockStored);
						if(te2 instanceof TileEntityCapacitorController) {
							TileEntityCapacitorController controller = (TileEntityCapacitorController) te2;
							((TileEnergyAcceptor)te).addCapacitor(controller);
							TranslationTextComponent component = new TranslationTextComponent("message.elementalmastery.machine_linked", "Machine and Capacitor Linked");
		    	            component.getStyle().func_240723_c_(TextFormatting.BLUE);
		    	            player.sendStatusMessage(component, true);
						}
					}
				}
				nbt.putLong("position", blockStored.toLong());
				nbt.putString("tooltip", toolTip);
				player.getHeldItem(hand).setTag(nbt);
			} else {
				CompoundNBT compound = new CompoundNBT();
				player.getHeldItem(hand).setTag(compound);
				this.onItemUseFirst(stack, context);
			}
		//}
		return ActionResultType.PASS;
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		if(!world.isRemote){
			if(player.getHeldItem(hand).getTag() == null) {
				CompoundNBT compound = new CompoundNBT();
				player.getHeldItem(hand).setTag(compound);
			} else if (player.isSneaking()) {
				clearSelection(player.getHeldItem(hand), world);
			} else {
				System.out.println(BlockPos.fromLong(player.getHeldItem(hand).getTag().getLong("position")));
			}
		}
        return new ActionResult<>(ActionResultType.PASS, player.getHeldItem(hand));
    }

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		CompoundNBT nbt = stack.getTag();
		if(nbt != null && !nbt.getString("tooltip").equals("")) {
			tooltip.add(new StringTextComponent(nbt.getString("tooltip")));
		}
		
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		CompoundNBT compound = new CompoundNBT();
		stack.setTag(compound);
    }
	
	
	public void clearSelection(ItemStack stack, World world) {
		CompoundNBT nbt = stack.getTag();
		if(!world.isRemote) {
			if(nbt != null) {
				nbt.putLong("position", 0);
				nbt.putString("tooltip", "No Block Selected");
				stack.setTag(nbt);
			}
		}
	}
}
