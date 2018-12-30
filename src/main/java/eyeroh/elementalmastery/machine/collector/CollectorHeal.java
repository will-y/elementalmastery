package eyeroh.elementalmastery.machine.collector;

import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CollectorHeal extends CollectorBlock {

	public CollectorHeal() {
		super("heal", 3);
	}
	
	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCollectorHeal();
    }

}
