package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.collector.CollectorSlot;
import eyeroh.elementalmastery.machine.collector.TileCollectorFire;
import eyeroh.elementalmastery.machine.collector.TileCollectorHeal;
import eyeroh.elementalmastery.machine.collector.TileCollectorSpeed;
import eyeroh.elementalmastery.machine.collector.TileCollectorStrength;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerEnergyAcceptor extends Container {
	
	private TileEnergyAcceptor te;
	private int lastProgress = 0;
	
	public ContainerEnergyAcceptor(PlayerInventory playerInventory, IInventory iInventory, TileEnergyAcceptor te) {
		super(ContainerType.CRAFTING, -1);
		this.te = te;

//        addOwnSlots();
//        addPlayerSlots(playerInventory);
    }
	
	private int getID() {
		if(te instanceof TileCollectorSpeed) {
			return 1;
		} else if(te instanceof TileCollectorFire) {
			return 2;
		} else if (te instanceof TileCollectorHeal) {
			return 3;
		} else if (te instanceof TileCollectorStrength) {
			return 4;
		} else {
			return 0;
		}
	}

//    private void addPlayerSlots(PlayerInventory playerInventory) {
//        // Slots for the main inventory
//        for (int row = 0; row < 3; ++row) {
//            for (int col = 0; col < 9; ++col) {
//                int x = 8 + col * 18;
//                int y = row * 18 + 84;
//                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 9, x, y));
//            }
//        }
//
//        // Slots for the hotbar
//        for (int row = 0; row < 9; ++row) {
//            int x = 8 + row * 18;
//            int y = 142;
//            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
//        }
//    }
//
//    private void addOwnSlots() {
//        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
//        int x = 25;
//        int y = 39;
//
//        int slotIndex = 0;
//        int id = this.getID();
//        if(id != 4) {
//	        for (int i = 0; i < itemHandler.getSlots(); i++) {
//	            addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
//	            slotIndex++;
//	            x += 36;
//	        }
//        } else if (id == 4) {
//        	x = 25;
//        	y = 30;
//        	slotIndex = 0;
//        	for (int i = 0; i < 2; i++) {
//        		for (int z = 0; z < 4; z++) {
//        			addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, x, y));
//        			slotIndex++;
//        			x+=36;
//        		}
//        		y+=26;
//        	}
//        }
//
//        if(id == 3) {
//        	addSlotToContainer(new CollectorSlot(itemHandler, slotIndex, 11, 66));
//        }
//    }

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return te.canInteractWith(playerIn);
	}
	
//	@Override
//    public void detectAndSendChanges() {
//    	super.detectAndSendChanges();
//
//    	for(IContainerListener crafting : listeners) {
//    		if(lastProgress == te.getCurrentProgress()) continue;
//    		crafting.sendWindowProperty(this, 0, te.getCurrentProgress());
//    	}
//
//    	lastProgress = te.getCurrentProgress();
//    }
    
    @Override
    public void updateProgressBar(int id, int data) {
    	if(id == 0) {
    		te.setCurrentProgress(data);
    	}
    }
}
