package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class CollectorBasicTileEntity extends TileEntity implements ITickable, ISidedInventory {
	public static final int SIZE = 4;
	public final int[] slotArray = {0, 1, 2, 3};
	private Random rand = new Random();
	int timeBetweenCollect = 600;
	int counter = 0;
	
	private NonNullList<ItemStack> collectorItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);

    private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            CollectorBasicTileEntity.this.markDirty();
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
        counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("items", itemStackHandler.serializeNBT());
        compound.setInteger("counter", counter);
        return super.writeToNBT(compound);
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
		return "tile.elementalmastery.collectorbasic.name";
	}

	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
    
    @Override
    public void update() {
    	if(!world.isRemote) {
    		if(counter >= timeBetweenCollect) {
        		int random = rand.nextInt(4);
            	switch(random) {
            	case 0:
            		addItem(new ItemStack(ModItems.dustOpalSmall), 0);
            		break;
            	case 1:
            		addItem(new ItemStack(ModItems.dustTopazSmall), 1);
            		break;
            	case 2:
            		addItem(new ItemStack(ModItems.dustRubySmall), 2);
            		break;
            	case 3:
            		addItem(new ItemStack(ModItems.dustSapphireSmall), 3);
            		break;
            	}
            	counter = 0;
        	} else {
        		counter++;
        	}
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public int getCurrentProgress() {
    	return counter;
    }
    
    public void setCurrentProgress(int data) {
    	this.counter = data;
    }
    
    public int getMaxProgress() {
    	return this.timeBetweenCollect;
    }
    
    public void addItem(ItemStack itemStack, int slotID) {
    	itemStackHandler.insertItem(slotID, itemStack, false);
    }

	@Override
	public int getSizeInventory() {
		System.out.println("getSizeInventory");
		return this.SIZE;
	}

	public boolean isEmpty()
    {
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
		//System.out.println("getStackInSlot");
		return this.collectorItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		//System.out.println("decrease");
		return ItemStackHelper.getAndSplit(this.collectorItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.collectorItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		//System.out.println("setInventoryContents");
	}

	@Override
	public int getInventoryStackLimit() {
		//System.out.println("getInventoryStackLimit");
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		//System.out.println("isUsableByPlayer");
		return true;
	}

	public void openInventory(EntityPlayer player) {
	}

	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		//System.out.println("isItemValidForSlot");
		return false;
	}

	@Override
	public int getField(int id) {
		//System.out.println("getField");
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		//System.out.println("setField");
		
	}

	@Override
	public int getFieldCount() {
		//System.out.println("getFieldCount");
		return 0;
	}

	@Override
	public void clear() {
		//System.out.println("clear");
		this.collectorItemStacks.clear();
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
	
	public ItemStackHandler getItemStackHandler() {
		return itemStackHandler;
	}
}
