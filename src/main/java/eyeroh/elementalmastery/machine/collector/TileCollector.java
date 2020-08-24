package eyeroh.elementalmastery.machine.collector;

import java.util.Random;

import eyeroh.elementalmastery.item.ModItems;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public abstract class TileCollector extends TileEnergyAcceptorInventory implements ITickable {
	public int size;
	public ItemStack[] collectorItems; 
	
	Random rand = new Random();
	
	public TileCollector(int[] storage, int[] usage, int invSize, ItemStack[] items, int maxCounter) {
		super(storage, usage, invSize, maxCounter);
		this.collectorItems = items;
		this.size = invSize;
	}
	
	
	public abstract int getEnergyType();
    
    public abstract int getCurrentEnergy();
    
    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
    	return false;
    }
    
//    @Override
//    public void readFromNBT(CompoundNBT compound) {
//        super.readFromNBT(compound);
//    }
	
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return super.write(compound);
    }
    
	
	@Override
	public void doAction() {
		int itemNum = rand.nextInt(collectorItems.length);
		addItem(collectorItems[itemNum].copy(), itemNum);
		
	}
	
	public static ItemStack[] getDefaultItemStackArray() {
		return new ItemStack[] {new ItemStack(ModItems.DUST_OPAL_SMALL.get()), new ItemStack(ModItems.DUST_TOPAZ_SMALL.get()), new ItemStack(ModItems.DUST_RUBY_SMALL.get()), new ItemStack(ModItems.DUST_SAPPHIRE_SMALL.get())};
	}
	
	public abstract String getFileName();
}