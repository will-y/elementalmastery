package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

public class TileMiner extends TileEnergyAcceptorInventory {

	private int currentX;
	private int currentZ;
	private int currentY;
	private int minX;
	private int minZ;
	private int minY;
	private int maxX;
	private int maxZ;
	private int maxY;
	
	public TileMiner() {
		super(new int[] {20000, 20000, 20000, 20000}, new int[] {0, 0, 0, 0}, 10, 60);
		
	}

	@Override
	public void doAction() {
		
	}
	
	@Override
	public void onLoad() {
		calculateValues();
		super.onLoad();
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        
        return super.writeToNBT(compound);
    }
	
	private void calculateValues() {
		Chunk currentChunk = this.getWorld().getChunkFromBlockCoords(this.pos);
		ChunkPos pos = currentChunk.getPos();
		minX = pos.getXStart();
		maxX = pos.getXEnd();
		minZ = pos.getZStart();
		maxZ = pos.getZEnd();
		maxY = this.pos.getY();
		minY = 0;
	}
	
	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return false;
	}
}
