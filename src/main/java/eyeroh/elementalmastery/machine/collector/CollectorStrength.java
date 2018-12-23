package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CollectorStrength extends CollectorBlock {

	public CollectorStrength() {
		super(0, "strength");
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCollectorStrength();
    }

}
