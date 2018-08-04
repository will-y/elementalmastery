package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
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

public class CollectorBlock extends Block implements ITileEntityProvider{

    public static final int GUI_ID = 1;

    public CollectorBlock() {
        super(Material.ROCK);
        setUnlocalizedName(ElementalMastery.MODID + ".collectorbasic");
        setRegistryName("collectorbasic");
        setHardness(3.0f);
        setResistance(5.0f);
        setSoundType(SoundType.STONE);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CollectorTileEntity();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        // Only execute on the server
        if (world.isRemote) {
            return true;
        }
        CollectorTileEntity test = (CollectorTileEntity) world.getTileEntity(pos);
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof CollectorTileEntity)) {
            return false;
        }
        player.openGui(ElementalMastery.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
    	TileEntity te = world.getTileEntity(pos);
    	if(te instanceof CollectorTileEntity) {
    		CollectorTileEntity tileEntity = (CollectorTileEntity) te;
    		
    		for(int i = 0; i < tileEntity.SIZE; i++) {
    			ItemStack stack = tileEntity.getItemStackHandler().getStackInSlot(i);
    			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    		}
    		
    	}
    }
}
