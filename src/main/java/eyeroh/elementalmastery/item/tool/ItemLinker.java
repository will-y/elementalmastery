package eyeroh.elementalmastery.item.tool;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.GemItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLinker extends GemItem {
	
	public NBTTagCompound compound = new NBTTagCompound();
	
	public BlockPos blockStored;
	
	public ItemLinker() {
		super("linker");
		setMaxStackSize(1);
	}
	
	boolean test = true;
	
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, EnumHand hand) {
		if(!world.isRemote) {
			
			if(Block.isEqualTo(world.getBlockState(pos).getBlock(), ModBlocks.capacitorController)) {
				blockStored = pos;
				System.out.println("hit");
			} else {
				blockStored = BlockPos.fromLong(compound.getLong("position"));
			}
			
			
			compound.setLong("position", blockStored.toLong());
			player.getHeldItem(hand).writeToNBT(compound);
	        
		}
		return EnumActionResult.PASS;
    }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		if(worldIn.isRemote){
			System.out.println(blockStored);
		}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

	
	
}
