package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import eyeroh.elementalmastery.machine.collector.TileCollector;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEnergyAcceptor extends Block implements ITileEntityProvider{
	
	private int machineID = 0;
	public int GUI_ID = 0;
	
	public BlockEnergyAcceptor(String name, int machineID, int GUI_ID) {
		super(Material.IRON);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		setUnlocalizedName(ElementalMastery.MODID + "." + name);
		setRegistryName(name);
		this.machineID = machineID;
		this.GUI_ID = GUI_ID;
		this.setCreativeTab(ModMachines.tabGemMachines);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        switch (machineID) {
        case 0:
        	return null;
        default:
        	return new CollectorBasicTileEntity();
        }
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileEnergyAcceptor)) {
            return false;
        }
        if(!player.getHeldItemMainhand().isItemEqual(new ItemStack(ModTools.linker))) {
        	player.openGui(ElementalMastery.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
}
