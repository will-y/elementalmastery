package eyeroh.elementalmastery.block;

import org.omg.PortableServer.POA;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.item.tool.ModTools;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import eyeroh.elementalmastery.machine.miner.TileMiner;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UpgradeBlock extends Block {
	// opal 0
	// topaz 1
	// ruby 2
	// sapphire 3
	private int type;
	
	public UpgradeBlock(String name, int type) {
		super(Material.IRON);
		this.type = type;
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		setUnlocalizedName(ElementalMastery.MODID + "." + name);
		setRegistryName(name);
		this.setCreativeTab(ModMachines.tabGemMachines);
	}
	
	public int getType() {
		return this.type;
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        
        BlockPos minerPos = lookForMiner(pos, world);
        
        if (minerPos == null) {
        	return true;
        } else {
        	TileEntity te = world.getTileEntity(minerPos);
        	if (te instanceof TileMiner) {
        		player.openGui(ElementalMastery.instance, 0, world, minerPos.getX(), minerPos.getY(), minerPos.getZ());
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
	
	private BlockPos lookForMiner(BlockPos pos, World world) {
		BlockPos temp = pos;
		temp = pos.add(1, 0, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(-1, 0, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 1, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, -1, 0);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 0, 1);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		temp = pos.add(0, 0, -1);
		
		if(world.getTileEntity(temp) instanceof TileMiner) {
			return temp;
		}
		
		return null;
	}
	
}
