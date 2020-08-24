package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.block.UpgradeBlock;
import eyeroh.elementalmastery.machine.BlockEnergyAcceptor;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public class BlockMiner extends BlockEnergyAcceptor {
	
	private static Vector3i[] positions = new Vector3i[] {new Vector3i(1, 0, 0), new Vector3i(-1, 0, 0), new Vector3i(0, 1, 0), new Vector3i(0, -1, 0), new Vector3i(0, 0, 1), new Vector3i(0, 0, -1)};
	
	public BlockMiner() {
		super(0, 0);
	}
	
//	@Override
//    public TileEntity createNewTileEntity(World worldIn, int meta) {
//		return new TileMiner();
//    }
//
//	@Override
//	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
//		TileMiner miner = (TileMiner) world.getTileEntity(pos);
//
//		miner.setOn(world.isBlockPowered(pos));
//
//		int[] upgrades = new int[] {0, 0, 0, 0};
//
//		BlockPos temp;
//		miner.clearInventories();
//		for (Vec3i vec : positions) {
//			temp = pos.add(vec);
//			Block block = world.getBlockState(temp).getBlock();
//			TileEntity entity = world.getTileEntity(temp);
//			if(block instanceof UpgradeBlock) {
//				upgrades[((UpgradeBlock) block).getType()]++;
//			} else if(entity instanceof IInventory) {
//				miner.addTargetInventoryPos(temp);
//			}
//		}
//		miner.changeUpgrades(upgrades);
//		miner.calculateValues();
//		world.notifyBlockUpdate(pos, state, state, 2);
//    }
//
//	@Override
//	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
//		TileMiner miner = (TileMiner) worldIn.getTileEntity(pos);
//		miner.calculateValues();
//		miner.setCurrents();
//	}
}
