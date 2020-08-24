package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockEnergyAcceptor extends Block {
	
	private int machineID = 0;
	public int GUI_ID = 0;
	
	public BlockEnergyAcceptor(int machineID, int GUI_ID) {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
		this.machineID = machineID;
		this.GUI_ID = GUI_ID;
	}
	
//	@Override
//    public TileEntity createNewTileEntity(World worldIn, int meta) {
//        switch (machineID) {
//        case 0:
//        	return null;
//        default:
//        	return new CollectorBasicTileEntity();
//        }
//    }
//
//	@Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        if (world.isRemote) {
//            return true;
//        }
//        TileEntity te = world.getTileEntity(pos);
//        if (!(te instanceof TileEnergyAcceptor)) {
//            return false;
//        }
//        if(!player.getHeldItemMainhand().isItemEqual(new ItemStack(ModTools.linker))) {
//        	player.openGui(ElementalMastery.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
//        }
//        return true;
//    }
}
