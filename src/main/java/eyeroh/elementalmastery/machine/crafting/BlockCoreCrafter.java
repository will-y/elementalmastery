package eyeroh.elementalmastery.machine.crafting;

import eyeroh.elementalmastery.machine.BlockEnergyAcceptor;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCoreCrafter extends BlockEnergyAcceptor {

	public BlockCoreCrafter() {
		super(new int[] {10000, 10000, 10000, 10000}, new int[] {100, 100, 100, 100}, "corecrafter", 0, 0);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEnergyCoreCrafter();
    }

}