package eyeroh.elementalmastery.machine.generator;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.ModMachines;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
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

public class GeneratorBlock extends Block implements ITileEntityProvider {
	public int GUI_ID = 1;
	public String name;
	public int type;

    public GeneratorBlock(String name, int type) {
        super(Material.ROCK);
        setUnlocalizedName(ElementalMastery.MODID + ".generator" + name);
        setRegistryName("generator" + name);
        setHardness(3.0f);
        setResistance(5.0f);
        setSoundType(SoundType.STONE);
        this.name = name;
        this.type = type;
        GUI_ID = GUI_ID + type;
        this.setCreativeTab(ModMachines.tabGemMachines);
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GeneratorTileEntity();
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof GeneratorTileEntity)) {
            return false;
        }
        player.openGui(ElementalMastery.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
    	TileEntity te = world.getTileEntity(pos);
    	if(te instanceof GeneratorTileEntity) {
    		GeneratorTileEntity tileEntity = (GeneratorTileEntity) te;
    		ItemStack stack = tileEntity.getItemStackHandler().getStackInSlot(0);
    		InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
    	}
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
    	if(world.getTileEntity(pos) instanceof GeneratorTileEntity) {
    		((GeneratorTileEntity) world.getTileEntity(pos)).setUpTileEntity();
    	}
    }
}