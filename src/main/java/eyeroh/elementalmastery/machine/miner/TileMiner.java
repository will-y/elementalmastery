package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;

public class TileMiner extends TileEnergyAcceptorInventory {
	
	private static final int baseProgress = 13;
	
	private int currentX;
	private int currentZ;
	private int currentY;
	private int minX;
	private int minZ;
	private int minY;
	private int maxX;
	private int maxZ;
	private int maxY;
	private boolean done = false;
	private boolean on = false;
	// stores the upgrade counts
	private int[] upgradeCount = new int[] {0, 0, 0, 0};
	IInventory targetInventory;
	ItemStack buffer;
	
	public TileMiner() {
		super(new int[] {20000, 20000, 20000, 20000}, new int[] {5, 5, 5, 5}, 10, baseProgress);
	}

	@Override
	public void doAction() {
		breakNextBlock();
		incrementValues();
	}
	
	@Override
	public boolean getActive() {
		return !done && on && super.getActive() && (targetInventory != null);
	}
	
	@Override
	public void update() {
		retrieveEnergy();
		if(this.getActive()) {
			this.useAllEnergy();
			if(!world.isRemote) {
				if(this.getCurrentProgress() >= this.getMaxProgress()) {
					if(buffer == null) {
						doAction();
						this.setCurrentProgress(0);
						markDirty();
					} else {
						if(this.insertItem(buffer, targetInventory)) {
							buffer = null;
						}
						this.setCurrentProgress(0);
						markDirty();
					}
				}
				this.setCurrentProgress(this.getCurrentProgress() + 1);
			}
		}
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        currentX = compound.getInteger("curX");
        currentY = compound.getInteger("curY");
        currentZ = compound.getInteger("curZ");
        minX = compound.getInteger("minX");
        minY = compound.getInteger("minY");
        minZ = compound.getInteger("minZ");
        maxX = compound.getInteger("maxX");
        maxY = compound.getInteger("maxY");
        maxZ = compound.getInteger("maxZ");
        on = compound.getBoolean("on");
        if (compound.hasKey("upgrades")) {
        	upgradeCount = compound.getIntArray("upgrades");
        } else {
        	upgradeCount = new int[] {0, 0, 0, 0};
        }
        
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("curX", currentX);
        compound.setInteger("curY", currentY);
        compound.setInteger("curZ", currentZ);
        compound.setInteger("minX", minX);
        compound.setInteger("minY", minY);
        compound.setInteger("minZ", minZ);
        compound.setInteger("maxX", maxX);
        compound.setInteger("maxY", maxY);
        compound.setInteger("maxZ", maxZ);
        compound.setBoolean("on", on);
        compound.setIntArray("upgrades", upgradeCount);
        return super.writeToNBT(compound);
    }
	
	protected void calculateValues() {
		Chunk currentChunk = this.getWorld().getChunkFromBlockCoords(this.pos);
		ChunkPos pos = currentChunk.getPos();
		ChunkPos topRight = this.getWorld().getChunkFromChunkCoords(pos.x + upgradeCount[3], pos.z + upgradeCount[3]).getPos();
		ChunkPos bottomLeft = this.getWorld().getChunkFromChunkCoords(pos.x - upgradeCount[3], pos.z - upgradeCount[3]).getPos();
		
		
		minX = bottomLeft.getXStart();
		minZ = bottomLeft.getZStart();
		maxX = topRight.getXEnd();
		maxZ = topRight.getZEnd();
		
		
		maxY = this.pos.getY() - 1;
		minY = 0;
	}
	
	protected void setCurrents() {
		currentX = minX;
		currentY = maxY;
		currentZ = minZ;
	}
	
	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return false;
	}
	
	private void breakNextBlock() {
		try {
			BlockPos pos = new BlockPos(currentX, currentY, currentZ);
			IBlockState state = world.getBlockState(pos);
			float hardness = state.getBlockHardness(world, pos);
			
			if(hardness == -1.0F) {
				this.incrementValues();
				this.breakNextBlock();
			} else {
				NonNullList<ItemStack> drops = NonNullList.create();
				state.getBlock().getDrops(drops, world, pos, state, 0);
				if(!this.getWorld().destroyBlock(pos, false)) {
					this.incrementValues();
					this.breakNextBlock();
				} else {
					for(ItemStack stack : drops) {
						this.insertItem(stack, targetInventory);
					}
					if(upgradeCount[2] > 0) { 
						this.getWorld().setBlockState(pos, Blocks.DIRT.getDefaultState());
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	
	private void incrementValues() {
		if (currentX == maxX) {
			currentX = minX;
			if (currentZ == maxZ) {
				currentZ = minZ;
				if (currentY - 1 == minY) {
					this.done = true;
				} else {
					currentY--;
				}
			} else {
				currentZ++;
			}
		} else {
			currentX++;
		}
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public boolean getOn() {
		return on;
	}
	
	public void changeUpgrades(int[] newUpgrades) {
		upgradeCount = newUpgrades;
		this.setMaxProgress(baseProgress - upgradeCount[0] * 2);
	}
	
	public void setTargetInventory(IInventory inventory) {
		this.targetInventory = inventory;
	}
	
	//TODO: fix deleting items if stack is full
	private boolean insertItem(ItemStack item, IInventory inventory) {
		int size = inventory.getSizeInventory();
		int stackSize = inventory.getInventoryStackLimit();
		int insertSize = item.getCount();
		//System.out.println("Item: " + item.toString() + "size: " + size + "stackSize: " + stackSize + "insertSize: " + insertSize);
		for (int i = 0; i < size; i++) {
			if(inventory.isItemValidForSlot(i, item)) {
				ItemStack chestStack = inventory.getStackInSlot(i);
				int chestSize = chestStack.getCount();
				if((ItemStack.areItemsEqual(item, chestStack) || chestStack.isEmpty()) && chestSize < stackSize) {
					if(chestSize + insertSize <= stackSize) {
						item.setCount(chestSize + insertSize);
						inventory.setInventorySlotContents(i, item);
						inventory.markDirty();
						return true;
					} else {
						item.setCount(stackSize);
						inventory.setInventorySlotContents(i, item);
						inventory.markDirty();
						item.setCount(insertSize + chestSize - stackSize);
						return insertItem(item, inventory);
					}
				}
			}
		}
		// deactivate here?
		// some way to buffer an item?
		buffer = item;
		return false;
	}
}
