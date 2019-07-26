package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileCollector extends TileEnergyAcceptor implements ITickable, IInventory{
	public int size;
	public int timeBetweenCollect;
	public ItemStack[] collectorItems;
	
	private NonNullList<ItemStack> collectorItemStacks;
	private ItemStackHandler itemStackHandler; 
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items, int maxCounter) {
		super(storage, usage, invSize);
		this.collectorItems = items;
		this.timeBetweenCollect = maxCounter;
		this.size = invSize;
		System.out.println("Number of slots at constructor" + size);
		NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
		itemStackHandler = new ItemStackHandler(size) {
	        @Override
	        protected void onContentsChanged(int slot) {
	            TileCollector.this.markDirty();
	        }
		};
	}
    
	@SideOnly(Side.CLIENT)
    public int getCurrentProgress() {
    	return this.counter;
    }
	
	public void setCurrentProgress(int data) {
		this.counter = data;
	}
	
	public int getMaxProgress() {
		return this.timeBetweenCollect;
	}
    
    public abstract int getCurrentEnergy();

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
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
        if(compound.hasKey("capacitor")) {
        	linkedCapacitor.deserializeNBT((NBTTagCompound) compound.getTag("capacitor"));
        	System.out.println("reading in collector");
        }
        
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("items", itemStackHandler.serializeNBT());
        compound.setTag("capacitor", this.linkedCapacitor.serializeNBT());
        return super.writeToNBT(compound);
    }
    
	
	@Override
	public void actionPerTick() {
		this.retrieveEnergy();
		if(this.getActive()) {
			this.useEnergy(this.getType(), this.usage[this.getType()]);
			if(!world.isRemote) {
				if(counter >= timeBetweenCollect) {
					
					int itemNum = rand.nextInt(collectorItems.length);
					addItem(collectorItems[itemNum].copy(), itemNum);
					this.markDirty();
					counter = 0;
				}
				counter++;
				this.markDirty();
			}
		}
		
	}
	
	@Override
	public boolean getActive() {
		for(int i = 0; i < 4; i++) {
			if(this.getUsage()[i] != 0) {
				if(this.getUsage()[i] > this.getCurrentEnergy()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void addItem(ItemStack item, int slot) {
		getItemStackHandler().insertItem(slot, item, false);
	}
	
	public static ItemStack[] getDefaultItemStackArray() {
		return new ItemStack[] {new ItemStack(ModItems.dustOpalSmall), new ItemStack(ModItems.dustTopazSmall), new ItemStack(ModItems.dustRubySmall), new ItemStack(ModItems.dustSapphireSmall)};
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}
	
	@Override
	public boolean isEmpty() {
        for (ItemStack itemstack : this.collectorItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.collectorItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.collectorItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.collectorItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
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
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
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
		collectorItemStacks.clear();
		
	}
	
	public String getFileName() {
		return "";
	}
	
	public ItemStackHandler getItemStackHandler() {
		return itemStackHandler;
	}
}