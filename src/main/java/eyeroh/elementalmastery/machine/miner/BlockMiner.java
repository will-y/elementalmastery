package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.machine.BlockEnergyAcceptor;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		TileMiner miner = (TileMiner) worldIn.getTileEntity(pos);
		
		miner.setOn(worldIn.isBlockPowered(pos));
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		TileMiner miner = (TileMiner) worldIn.getTileEntity(pos);
		miner.calculateValues();
	}
}
