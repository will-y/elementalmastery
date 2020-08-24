package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ToolType;

public class CollectorBlock extends Block {

    public int guiID = 7;

    public CollectorBlock(int type) {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
        guiID = guiID + type;
    }
    
//    @Override
//    public TileEntity createNewTileEntity(World worldIn, int meta) {
//        return new CollectorBasicTileEntity();
//    }
//
//
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        if (world.isRemote) {
//            return true;
//        }
//        TileEntity te = world.getTileEntity(pos);
//        if (!(te instanceof CollectorBasicTileEntity || te instanceof TileCollector)) {
//            return false;
//        }
//        if(!player.getHeldItemMainhand().isItemEqual(new ItemStack(ModTools.linker))) {
//        	player.openGui(ElementalMastery.instance, guiID, world, pos.getX(), pos.getY(), pos.getZ());
//        }
//        return true;
//    }
//
//    @Override
//    public void breakBlock(World world, BlockPos pos, IBlockState state) {
//    	TileEntity te = world.getTileEntity(pos);
//    	if(te instanceof TileCollector) {
//    		TileCollector tileEntity = (TileCollector) te;
//
//    		for(int i = 0; i < tileEntity.size; i++) {
//    			ItemStack stack = tileEntity.getItemStackHandler().getStackInSlot(i);
//    			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
//    		}
//
//    	}
//    }
}
