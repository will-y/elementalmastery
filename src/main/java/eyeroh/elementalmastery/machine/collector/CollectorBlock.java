package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.generator.GeneratorTileEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CollectorBlock extends Block implements ITileEntityProvider {

    public int guiID = 7;

    public CollectorBlock(String name, int type) {
        super(Material.ROCK);
        setUnlocalizedName(ElementalMastery.MODID + ".collector" + name);
        setRegistryName("collector" + name);
        setHardness(3.0f);
        setResistance(5.0f);
        setSoundType(SoundType.STONE);
        guiID = guiID + type;
        this.setCreativeTab(ModMachines.tabGemMachines);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CollectorBasicTileEntity();
    }
    

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof CollectorBasicTileEntity || te instanceof TileCollector)) {
            return false;
        }
        System.out.println("open");
        player.openGui(ElementalMastery.instance, guiID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
    	TileEntity te = world.getTileEntity(pos);
    	if(te instanceof TileCollector) {
    		TileCollector tileEntity = (TileCollector) te;
    		
    		for(int i = 0; i < tileEntity.size; i++) {
    			ItemStack stack = tileEntity.getItemStackHandler().getStackInSlot(i);
    			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    		}
    		
    	}
    }
}
