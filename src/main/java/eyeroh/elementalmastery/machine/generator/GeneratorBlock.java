package eyeroh.elementalmastery.machine.generator;

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

public class GeneratorBlock extends Block {
	public int GUI_ID = 1;
	public String name;
	public int type;

    public GeneratorBlock(String name, int type) {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
        this.name = name;
        this.type = type;
        GUI_ID = GUI_ID + type;
    }
    
//    @Override
//    public TileEntity createNewTileEntity(World worldIn, int meta) {
//        return new GeneratorTileEntity();
//    }
//
//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        if (world.isRemote) {
//            return true;
//        }
//        TileEntity te = world.getTileEntity(pos);
//        if (!(te instanceof GeneratorTileEntity)) {
//            return false;
//        }
//        if(!player.getHeldItemMainhand().isItemEqual(new ItemStack(ModTools.linker)))
//        	player.openGui(ElementalMastery.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
//        return true;
//    }
//
//    @Override
//    public void breakBlock(World world, BlockPos pos, IBlockState state) {
//    	TileEntity te = world.getTileEntity(pos);
//    	if(te instanceof GeneratorTileEntity) {
//    		GeneratorTileEntity tileEntity = (GeneratorTileEntity) te;
//    		ItemStack stack = tileEntity.getItemStackHandler().getStackInSlot(0);
//    		InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
//    	}
//    }
//
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
//    	if(world.getTileEntity(pos) instanceof GeneratorTileEntity) {
//    		((GeneratorTileEntity) world.getTileEntity(pos)).setUpTileEntity();
//    	}
//    }
}