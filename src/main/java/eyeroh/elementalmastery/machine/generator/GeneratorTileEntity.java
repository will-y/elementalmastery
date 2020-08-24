package eyeroh.elementalmastery.machine.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.TileEnergyProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class GeneratorTileEntity extends TileEnergyProvider implements ITickable, IInventory{
	public static final int SIZE = 1;
	private Random rand = new Random();
	public String name;

	public boolean active = false;
	public int maxProgress = 200;
	public int currentProgress = 0;
	public int maxEnergy = 10000;
	public int currentEnergy = 0;
	private boolean progressed = true;

	public GeneratorTileEntity() {
		super(-1, 1000);
	}

    private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            GeneratorTileEntity.this.markDirty();
        }
    };
    
    public void setUpTileEntity() {
    	Block block = world.getBlockState(this.pos).getBlock();
    	
    	if(Block.isEqualTo(block, ModMachines.generatorOpal)) {
    		type = 0;
    	} else if (Block.isEqualTo(block, ModMachines.generatorTopaz)) {
    		type = 1;
    	} else if (Block.isEqualTo(block, ModMachines.generatorRuby)) {
    		type = 2;
    	} else if (Block.isEqualTo(block, ModMachines.generatorSapphire)) {
    		type = 3;
    	}
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
        active = compound.getBoolean("active");
        maxProgress = compound.getInteger("maxProgress");
        currentProgress = compound.getInteger("currentProgress");
        currentEnergy = compound.getInteger("currentEnergy");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("items", itemStackHandler.serializeNBT());
        compound.setBoolean("active", active);
        compound.setInteger("maxProgress", maxProgress);
        compound.setInteger("currentProgress", currentProgress);
        compound.setInteger("currentEnergy", currentEnergy);
        
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
    	switch(type) {
    	case 0:
    		return "tile.elementalmastery.generatoropal.name";
    	case 1:
    		return "tile.elementalmastery.generatortopaz.name";
    	case 2:
    		return "tile.elementalmastery.generatorruby.name";
    	case 3:
    		return "tile.elementalmastery.generatorsapphire.name";
    		default:
    			return "tile.elementalmastery.generatoropal.name";
    	}
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
		switch(type) {
		case 0:
			if (stack.isItemEqual(new ItemStack(ModItems.gemOpal)) || stack.isItemEqual(new ItemStack(ModBlocks.blockopal))) {
				return true;
			}
			break;
		case 1:
			if (stack.isItemEqual(new ItemStack(ModItems.gemTopaz)) || stack.isItemEqual(new ItemStack(ModBlocks.blocktopaz))) {
				return true;
			}
			break;
		case 2:
			if (stack.isItemEqual(new ItemStack(ModItems.gemRuby)) || stack.isItemEqual(new ItemStack(ModBlocks.blockruby))) {
				return true;
			}
			break;
		case 3:
			if (stack.isItemEqual(new ItemStack(ModItems.gemSapphire)) || stack.isItemEqual(new ItemStack(ModBlocks.blocksapphire))) {
				return true;
			}
			break;
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
	
	public void update() {
		markDirty();
		if(active) {
			if(canExportEnergy() || currentEnergy <= maxEnergy) {
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
			if(stack.isItemEqual(new ItemStack(ModItems.gemOpal)) || stack.isItemEqual(new ItemStack(ModItems.gemTopaz)) || stack.isItemEqual(new ItemStack(ModItems.gemRuby)) || stack.isItemEqual(new ItemStack(ModItems.gemSapphire))) {
				maxProgress = 100;
				itemStackHandler.extractItem(0, 1, false);
				active = true;
			} else if (stack.isItemEqual(new ItemStack(ModBlocks.blockopal)) || stack.isItemEqual(new ItemStack(ModBlocks.blocktopaz)) || stack.isItemEqual(new ItemStack(ModBlocks.blockruby)) || stack.isItemEqual(new ItemStack(ModBlocks.blocksapphire))) {
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
	
	@SideOnly(Side.CLIENT)
	public int getCurrentProgress() {
		return this.currentProgress;
	}
	
	public void setCurrentProgress(int data) {
		this.currentProgress = data;
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
	
	public int getType() {
		return this.type;
	}

	public List<String> getToolTipString() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(this.currentEnergy + "/" + this.maxEnergy);
		return result;
	}
}
