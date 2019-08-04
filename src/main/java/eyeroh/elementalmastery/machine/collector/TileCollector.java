package eyeroh.elementalmastery.machine.collector;

import java.util.ArrayList;
import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileCollector extends TileEnergyAcceptorInventory implements ITickable {
	public int size;
	public ItemStack[] collectorItems;
	
	private NonNullList<ItemStack> collectorItemStacks;
	private ItemStackHandler itemStackHandler; 
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items, int maxCounter) {
		super(storage, usage, invSize, maxCounter);
		this.collectorItems = items;
		this.size = invSize;
		collectorItemStacks = NonNullList.<ItemStack>withSize(size, ItemStack.EMPTY);
		itemStackHandler = new ItemStackHandler(size) {
	        @Override
	        protected void onContentsChanged(int slot) {
	            TileCollector.this.markDirty();
	        }
		};
	}
	
	
	public abstract int getType();
    
    public abstract int getCurrentEnergy();
    
    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
    	return false;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }
    
	
	@Override
	public void doAction() {
		this.useEnergy(this.getType(), this.usage[this.getType()]);
		int itemNum = rand.nextInt(collectorItems.length);
		addItem(collectorItems[itemNum].copy(), itemNum);
		
	}
	
	public static ItemStack[] getDefaultItemStackArray() {
		return new ItemStack[] {new ItemStack(ModItems.dustOpalSmall), new ItemStack(ModItems.dustTopazSmall), new ItemStack(ModItems.dustRubySmall), new ItemStack(ModItems.dustSapphireSmall)};
	}
	
	public abstract String getFileName();
	
	public ArrayList<String> getToolTipString() {
		String result = this.currentEnergy[this.getType()] + "/" + this.getMaxEnergy(this.getType());
		ArrayList<String> list = new ArrayList<String>();
		list.add(result);
		return list;
	}
}