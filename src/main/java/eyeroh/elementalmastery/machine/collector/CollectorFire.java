package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CollectorFire extends CollectorBlock {

	public CollectorFire() {
		super("fire", 2);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCollectorFire();
    }

}
