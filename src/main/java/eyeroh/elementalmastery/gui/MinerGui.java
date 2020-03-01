package eyeroh.elementalmastery.gui;

import java.util.Random;

import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class MinerGui extends GuiEnergyAcceptor {
	
	public static final int WIDTH = 176;
	public static final int HEIGHT = 166;
	
	// values for moving pickaxe
	public static final int PICK_X = 55;
	public static final int PICK_Y = 35;
	public static final int PICK_SIZE = 13;
	public static final int PICK_TEXTURE_X = 176;
	public static final int PICK_TEXTURE_Y_1 = 73;
	public static final int PICK_TEXTURE_Y_2 = 86;
	public static final int PICK_RETURN_DELAY = 10;
	
	// values for the breaking block
	public static final int BLOCK_X = 55;
	public static final int BLOCK_Y = 65;
	public static final int BLOCK_SIZE = 16;
	public static final int BLOCK_TEXTURE_X = 216;
	public static final int BLOCK_TEXTURE_Y = 0;
	Random rand = new Random();
	int block = 0;
	
	private boolean pickState = false;
	private int counter = 0;
	
	public MinerGui(TileEnergyAcceptor tileEntity, Container container, ResourceLocation background) {
		super(tileEntity, container, WIDTH, HEIGHT, background, 128, 6, 1, 176, 0, new int[] {0, 1, 2, 3});
	}
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		int pickTextureY = 0;
		int pickY = 0;
		if(pickState) {
			pickTextureY = PICK_TEXTURE_Y_2;
			pickY = PICK_Y + PICK_SIZE;
			if(counter == PICK_RETURN_DELAY) {
				pickState = false;
				counter = 0;
				block = rand.nextInt(6);
			} else {
				counter++;
			}
		} else {
			pickTextureY = PICK_TEXTURE_Y_1;
			pickY = PICK_Y;
			drawTexturedModalRect(guiLeft + BLOCK_X, guiTop + BLOCK_Y, BLOCK_TEXTURE_X, BLOCK_TEXTURE_Y + (block * BLOCK_SIZE), BLOCK_SIZE, BLOCK_SIZE);
		}
		
		drawTexturedModalRect(guiLeft + PICK_X, guiTop + pickY, PICK_TEXTURE_X, pickTextureY, PICK_SIZE, PICK_SIZE);
		
		int current = tileEntity.getCurrentProgress();
		int max = tileEntity.getMaxProgress();
		
		if(current == max) {
			pickState = true;
		}
		
    }
}
