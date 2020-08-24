package eyeroh.elementalmastery.machine.capacitor;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ToolType;

public class BlockCapacitorController extends Block{
	
//	public static final PropertyBool ACTIVE = PropertyBool.create("active");
//	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final int GUI_ID = 2;
	
	public BlockCapacitorController() {
		super(Block.Properties.create(Material.ROCK)
				.hardnessAndResistance(3.0f, 5.0f)
				.sound(SoundType.STONE)
				.harvestLevel(3)
				.harvestTool(ToolType.PICKAXE));
        //setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

//	@Override
//	public TileEntity createNewTileEntity(World worldIn, int meta) {
//
//		return new TileEntityCapacitorController();
//	}
	
	private TileEntityCapacitorController getTE(World world, BlockPos pos) {
		return (TileEntityCapacitorController) world.getTileEntity(pos);
	}
	
//	@Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
//        if (!world.isRemote) {
//        	if(getTE(world, pos).checkForMultiBlock()) {
//        		if(!getTE(world, pos).getActive()) {
//        			world.setBlockState(pos, state.withProperty(ACTIVE, true));
//        			getTE(world, pos).checkForMultiBlock();
//        			getTE(world, pos).setActive();
//            		TextComponentTranslation component = new TextComponentTranslation("message.elementalmastery.capacitor_formed", "Capacitor Multiblock Formed");
//    	            component.getStyle().setColor(TextFormatting.BLUE);
//    	            player.sendStatusMessage(component, true);
//        		} else {
//        			getTE(world, pos).showEnergyAmount(player);
//        		}
//        	}
//        }
//
//        TileEntity te = world.getTileEntity(pos);
//        if (!(te instanceof TileEntityCapacitorController)) {
//            return false;
//        }
//
//        TileEntityCapacitorController tileEntityCapacitorController = (TileEntityCapacitorController) te;
//
//        if(tileEntityCapacitorController.getActive() && !player.getHeldItemMainhand().isItemEqual(new ItemStack(ModTools.linker)))
//        	player.openGui(ElementalMastery.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
//        return true;
//    }
//
//	@Override
//    public IBlockState getStateFromMeta(int meta) {
//        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2)).withProperty(ACTIVE, (meta & 8) != 0);
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return state.getValue(FACING).getIndex() + (state.getValue(ACTIVE) ? 8 : 0);
//    }
//
//	@Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
//		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
//    }
//
//	@Override
//	protected BlockStateContainer createBlockState() {
//		return new BlockStateContainer(this, FACING, ACTIVE);
//	}
}
