package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CollectorStrength extends CollectorBlock {

	public CollectorStrength() {
		super("strength", 2);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCollectorStrength();
    }

}
