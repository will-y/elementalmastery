package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.block.UpgradeBlock;
import eyeroh.elementalmastery.machine.BlockEnergyAcceptor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMiner extends BlockEnergyAcceptor {

	public BlockMiner() {
		super("miner", 0, 0);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
		TileMiner miner = new TileMiner();
        return miner;
    }
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		TileMiner miner = (TileMiner) world.getTileEntity(pos);
		
		miner.setOn(world.isBlockPowered(pos));
		
		int[] upgrades = new int[] {0, 0, 0, 0};
		
		BlockPos temp = pos;
		
		temp = pos.add(1, 0, 0);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		temp = pos.add(-1, 0, 0);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		temp = pos.add(0, 1, 0);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		temp = pos.add(0, -1, 0);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		temp = pos.add(0, 0, 1);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		temp = pos.add(0, 0, -1);
		if(world.getBlockState(temp).getBlock() instanceof UpgradeBlock) {
			upgrades[((UpgradeBlock) (world.getBlockState(temp).getBlock())).getType()]++;
		}
		
		miner.changeUpgrades(upgrades);
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		TileMiner miner = (TileMiner) worldIn.getTileEntity(pos);
		miner.calculateValues();
	}
}
