package eyeroh.elementalmastery.machine.capacitor;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCapacitorController extends Block implements ITileEntityProvider{
	
	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public BlockCapacitorController() {
		super(Material.ROCK);
		setUnlocalizedName(ElementalMastery.MODID + ".capacitorcontroller");
        setRegistryName("capacitorcontroller");
        
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileEntityCapacitorController();
	}
	
	private TileEntityCapacitorController getTE(World world, BlockPos pos) {
		return (TileEntityCapacitorController) world.getTileEntity(pos);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
        	if(getTE(world, pos).checkForMultiBlock()) {
        		if(!getTE(world, pos).getActive()) {
        			world.setBlockState(pos, state.withProperty(ACTIVE, true));
        			getTE(world, pos).checkForMultiBlock();
        			getTE(world, pos).setActive();
            		TextComponentTranslation component = new TextComponentTranslation("message.elementalmastery.capacitor_formed", "Capacitor Multiblock Formed");
    	            component.getStyle().setColor(TextFormatting.BLUE);
    	            player.sendStatusMessage(component, true);
        		} else {
        			getTE(world, pos).showEnergyAmount(player);
        		}
        	}
        }
        return true;
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2)).withProperty(ACTIVE, (meta & 8) != 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex() + (state.getValue(ACTIVE) ? 8 : 0);
    }
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING, ACTIVE);
	}
}
