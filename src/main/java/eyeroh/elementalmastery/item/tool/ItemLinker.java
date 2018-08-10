package eyeroh.elementalmastery.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.GemItem;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.generator.GeneratorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLinker extends GemItem {
	
	public BlockPos blockStored = new BlockPos(0, 0, 0);
	
	public ItemLinker() {
		super("linker");
		setMaxStackSize(1);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, EnumHand hand) {
		//if(!world.isRemote) {
			NBTTagCompound nbt = player.getHeldItem(hand).getTagCompound();
			if(nbt != null) {
				String toolTip = "No Block Linked";
				if(Block.isEqualTo(world.getBlockState(pos).getBlock(), ModBlocks.capacitorController)) {
					blockStored = pos;
					toolTip = "Linked to Capacitor @ " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ();
				} else {
					blockStored = BlockPos.fromLong(nbt.getLong("position"));
				}
				
				if(Block.isEqualTo(world.getBlockState(pos).getBlock(), ModMachines.generatorSpeed) && blockStored.toLong() != 0) {
					TileEntity te = world.getTileEntity(pos);
					if(te instanceof GeneratorTileEntity) {
						((GeneratorTileEntity) te).setCapacitor(blockStored);
					}
				}
				
				System.out.println(nbt);
				nbt.setLong("position", blockStored.toLong());
				nbt.setString("tooltip", toolTip);
				player.getHeldItem(hand).setTagCompound(nbt);
			} else {
				NBTTagCompound compound = new NBTTagCompound();
				player.getHeldItem(hand).setTagCompound(compound);
				this.onItemUseFirst(player, world, pos, facing, hitX, hitY, hitZ, hand);
			}
		//}
		return EnumActionResult.PASS;
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
		if(!world.isRemote){
			if(player.getHeldItem(hand).getTagCompound() == null) {
				NBTTagCompound compound = new NBTTagCompound();
				System.out.println("Item Created from first click --- ");
				player.getHeldItem(hand).setTagCompound(compound);
			} else if (player.isSneaking()) {
				clearSelection(player.getHeldItem(hand), world);
			} else {
				System.out.println(BlockPos.fromLong(player.getHeldItem(hand).getTagCompound().getLong("position")));
			}
		}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		NBTTagCompound nbt = stack.getTagCompound();
		if(nbt != null && nbt.getString("tooltip") != "") {
			tooltip.add(nbt.getString("tooltip"));
		}
		
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		NBTTagCompound compound = new NBTTagCompound();
		System.out.println("Item Created from create --- ");
		stack.setTagCompound(compound);
    }
	
	
	public void clearSelection(ItemStack stack, World world) {
		NBTTagCompound nbt = stack.getTagCompound();
		if(!world.isRemote) {
			if(nbt != null) {
				nbt.setLong("position", 0);
				nbt.setString("tooltip", "No Block Selected");
				stack.setTagCompound(nbt);
				System.out.println("cleared");
			}
		}
	}
}