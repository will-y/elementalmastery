package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.machine.BlockEnergyAcceptor;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMiner extends BlockEnergyAcceptor {

	public BlockMiner() {
		super("miner", 0, 0);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileMiner();
    }

}
