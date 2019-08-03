package eyeroh.elementalmastery.machine.collector;

import javax.annotation.Nullable;

import eyeroh.elementalmastery.machine.GemContainer;
import eyeroh.elementalmastery.machine.TileEnergyAcceptorInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class CollectorContainer extends GemContainer {
    

    public CollectorContainer(InventoryPlayer playerInventory, IInventory iInventory, TileEnergyAcceptorInventory te) {
        super(playerInventory, iInventory, te, 8, 84);
    }
    
    public void addOwnSlots() {
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 26;
        int y = 39;

        int slotIndex = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 36;
        }
    }
}
