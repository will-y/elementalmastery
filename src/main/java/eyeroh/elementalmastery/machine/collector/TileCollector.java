package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileCollector extends TileEnergyAcceptor implements ITickable, ISidedInventory{
	
	public int timeBetweenCollect;
	public ItemStack[] collectorItems;
	
	private NonNullList<ItemStack> collectorItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items, int maxCounter) {
		super(storage, usage, invSize);
		this.collectorItems = items;
		this.timeBetweenCollect = maxCounter;
	}
	
	private ItemStackHandler itemStackHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            TileCollector.this.markDirty();
        }
    };
    
    public int getCurrentEnergy() {
    	return 0;
    }
    
    public int getCurrentProgress() {
    	return 0;
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
    
	
	@Override
	public void actionPerTick() {
		if(counter >= timeBetweenCollect) {
			int itemNum = rand.nextInt(collectorItems.length);
			addItem(collectorItems[itemNum], itemNum);
			counter = 0;
			System.out.println("added item");
		}
		System.out.println("doing action");
		counter++;
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

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] {0, 1, 2, 3};
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}
	
	public String getFileName() {
		return "";
	}
	
	public ItemStackHandler getItemStackHandler() {
		return itemStackHandler;
	}
}