package eyeroh.elementalmastery.machine.miner;

import eyeroh.elementalmastery.block.UpgradeBlock;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Random;

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
	private int blocksMined = 0;
	private boolean done = false;
	private boolean on = false;
	// stores the upgrade counts
	private int[] upgradeCount = new int[] {0, 0, 0, 0};
	ArrayList<BlockPos> targetInventoryPos;
	ItemStack buffer;
	Random rand = new Random();
	
	public TileMiner() {
		super(new int[] {20000, 20000, 20000, 20000}, new int[] {50, 50, 50, 50}, 0, baseProgress);
	}

	@Override
	public void doAction() {
		breakNextBlock();
	}

	@Override
	public boolean isItemValid(int slot, ItemStack stack) {
		return false;
	}

	@Override
	public boolean getActive() {
		return !done && on && super.getActive() && targetInventoryPos != null && (targetInventoryPos.size() != 0);
	}

	public void clearInventories() {
		targetInventoryPos = new ArrayList<>();
	}
	
	@Override
	public void update() {
		retrieveEnergy();
		if(this.getActive()) {
			this.useAllEnergy();
			if(!world.isRemote) {
				if(this.getCurrentProgress() >= this.getMaxProgress()) {
					if (buffer == null) {
						doAction();
					} else {
						int index = rand.nextInt(targetInventoryPos.size());
						TileEntity tile = world.getTileEntity(targetInventoryPos.get(index));
						IInventory targetInventory = null;
						
						if (tile instanceof IInventory) {
							targetInventory = (IInventory) tile;
						}
						if (this.insertItem(buffer, targetInventory)) {
							buffer = null;
						}
					}
					this.setCurrentProgress(0);
					markDirty();
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
        if (compound.hasKey("container_amount")) {
        	int containers = compound.getInteger("container_amount");
			targetInventoryPos = new ArrayList<>();
        	if (containers != 0) {
				for (int i = 0; i < containers; i++) {
					if (compound.hasKey("container" + i)) {
						targetInventoryPos.add(BlockPos.fromLong(compound.getLong("container" + i)));
					}
				}
			}
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
        if (targetInventoryPos != null) {
        	compound.setInteger("container_amount", targetInventoryPos.size());
        	for (int i = 0; i < targetInventoryPos.size(); i++) {
        		compound.setLong("container" + i, targetInventoryPos.get(i).toLong());
			}
        }
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
	
	private void breakNextBlock() {
		try {
			BlockPos pos;
			IBlockState state;
			float hardness;

			do {
				pos = new BlockPos(currentX, currentY, currentZ);
				state = world.getBlockState(pos);
				hardness = state.getBlockHardness(world, pos);

				NonNullList<ItemStack> drops = NonNullList.create();
				state.getBlock().getDrops(drops, world, pos, state, 0);
				if (this.getWorld().destroyBlock(pos, false)) {
					blocksMined++;
					int index = rand.nextInt(targetInventoryPos.size());
					TileEntity tile = world.getTileEntity(targetInventoryPos.get(index));
					IInventory targetInventory = null;

					if (tile instanceof IInventory) {
						targetInventory = (IInventory) tile;
					}

					for (ItemStack stack : drops) {
						if (upgradeCount[1] > 0) {
							ItemStack smelted = new ItemStack(FurnaceRecipes.instance().getSmeltingResult(stack).getItem());
							if (!smelted.isEmpty()) {
								this.insertItem(smelted, targetInventory);
							} else {
								this.insertItem(stack, targetInventory);
							}
						} else {
							this.insertItem(stack, targetInventory);
						}
					}
					if (upgradeCount[2] > 0) {
						this.getWorld().setBlockState(pos, Blocks.DIRT.getDefaultState());
					}
				} else {
					this.incrementValues();
					continue;
				}
				this.incrementValues();
			} while (hardness == -1.0f || state.getBlock() instanceof UpgradeBlock || state.getBlock().isAir(state, world, pos));
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

	public void addTargetInventoryPos(BlockPos inventoryPos) {
		if (this.targetInventoryPos == null) {
			targetInventoryPos = new ArrayList<>();
		}

		targetInventoryPos.add(inventoryPos);
	}
	
	private boolean insertItem(ItemStack item, IInventory inventory) {
		if (inventory == null) {
			buffer = item;
			return false;
		}
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
	
	public int getTotalBlocks() {
		return (maxX - minX) * (maxZ - minZ) * (maxY - minY);
	}
	
	public int getBlocksMined() {
		return blocksMined;
	}
	
	@Override
	public String getName() {
		return "Miner";
	}
	
	@SideOnly(Side.CLIENT)
	public int[] getUpgrades() {
		return this.upgradeCount;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		this.readFromNBT(packet.getNbtCompound());
	}
}
