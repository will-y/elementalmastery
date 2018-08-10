package eyeroh.elementalmastery.machine.generator;

import java.util.Random;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class GeneratorTileEntity extends TileEntity implements ITickable, IInventory{
	public static final int SIZE = 1;
	private Random rand = new Random();
	public String name;
	public int type;
	
	public BlockPos linkedCapacitor = null;
	public boolean linked = false;
	public boolean active = false;
	public int maxProgress = 200;
	public int currentProgress = 0;
	public int maxEnergy = 10000;
	public int currentEnergy = 0;
	public int energyPerSecond = 1000;
	private int counter = 0;
	private int maxCounter = 20;
	private boolean progressed = true;

    private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            GeneratorTileEntity.this.markDirty();
        }
    };
    
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

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
        linked = compound.getBoolean("linked");
        active = compound.getBoolean("active");
        maxProgress = compound.getInteger("maxProgress");
        currentProgress = compound.getInteger("currentProgress");
        currentEnergy = compound.getInteger("currentEnergy");
        counter = compound.getInteger("counter");
        linkedCapacitor = BlockPos.fromLong(compound.getLong("linkedCapacitor"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("items", itemStackHandler.serializeNBT());
        compound.setBoolean("linked", linked);
        compound.setBoolean("active", active);
        compound.setInteger("maxProgress", maxProgress);
        compound.setInteger("currentProgress", currentProgress);
        compound.setInteger("currentEnergy", currentEnergy);
        compound.setInteger("counter", counter);
        if(linked) {
        	compound.setLong("linkedCapacitor", linkedCapacitor.toLong());
        }
        
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemStackHandler);
        }
        return super.getCapability(capability, facing);
    }
    
    public String getName() {
		return "tile.elementalmastery.generatoropal.name";
	}

	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (stack.isItemEqual(new ItemStack(ModItems.gemOpal)) || stack.isItemEqual(new ItemStack(ModBlocks.blockopal))) {
			return true;
		}
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return new ItemStack(ModItems.gemOpal);
	}
	
	public void setCapacitor(BlockPos pos) {
		this.linkedCapacitor = pos;
		linked = true;
	}
	
	public boolean canExportEnergy() {
		if(linked) {
			TileEntity capacitor = world.getTileEntity(linkedCapacitor);
			if(capacitor != null && capacitor instanceof TileEntityCapacitorController) {
				if(((TileEntityCapacitorController) capacitor).canAcceptEnergy(0, this.energyPerSecond)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			
			}
		} else {
			return false;
		}
	}
	
	public boolean isCapacitorFull() {
		if(linked) {
			TileEntity te = world.getTileEntity(linkedCapacitor);
			if(te != null && te instanceof TileEntityCapacitorController) {
				TileEntityCapacitorController capacitor = (TileEntityCapacitorController) te;
				return capacitor.isFull(0);
			}
		}
		return true;
	}
	
	public void sendPower(int amount) {
		if(!world.isRemote) {
			TileEntity capacitor = world.getTileEntity(linkedCapacitor);
			((TileEntityCapacitorController) capacitor).addEnergy(0, amount);
		}
	}
	
	public void update() {
		markDirty();
		
		if(active) {
			if(canExportEnergy() || currentEnergy < (maxEnergy)) {
				currentProgress++;
				progressed = true;
			} else {
				progressed = false;
			}
			
			if(currentProgress >= maxProgress) {
				active = false;
				currentProgress = 0;
			}
		} else {
			ItemStack stack = itemStackHandler.getStackInSlot(0);
			if(stack.isItemEqual(new ItemStack(ModItems.gemOpal))) {
				maxProgress = 100;
				itemStackHandler.extractItem(0, 1, false);
				active = true;
			} else if (stack.isItemEqual(new ItemStack(ModBlocks.blockopal))) {
				maxProgress = 900;
				itemStackHandler.extractItem(0, 1, false);
				active = true;
			}
		}
		
		if(active && progressed) {
			if(canExportEnergy()) {
				sendPower((int)energyPerSecond/20);
			} else {
				currentEnergy += (int)energyPerSecond/20;
			}
		} else if(currentEnergy > 0 && linked) {
			if(canExportEnergy()) {
				if(currentEnergy <= (int)energyPerSecond/20) {
					sendPower(currentEnergy);
					currentEnergy = 0;
				} else {
					sendPower((int)energyPerSecond/20);
					currentEnergy -= (int)energyPerSecond/20;
				}
			}
		}
	}
	
	public int getCurrentProgress() {
		return this.currentProgress;
	}
	
	public int getMaxProgress() {
		return this.maxProgress;
	}
	
	public int getCurrentEnergy() {
		return this.currentEnergy;
	}
	
	public int getMaxEnergy() {
		return this.maxEnergy;
	}
	
	public ItemStackHandler getItemStackHandler() {
		return itemStackHandler;
	}
}
