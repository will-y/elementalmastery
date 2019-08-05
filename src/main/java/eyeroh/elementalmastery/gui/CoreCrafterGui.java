package eyeroh.elementalmastery.gui;

import eyeroh.elementalmastery.machine.crafting.CoreCrafterContainer;
import eyeroh.elementalmastery.machine.crafting.TileEnergyCoreCrafter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class CoreCrafterGui extends GuiEnergyAcceptor {
	public static final int WIDTH = 172;
	public static final int HEIGHT = 182;
	public TileEnergyCoreCrafter tileEntity;
	public CoreCrafterContainer container;
	private ResourceLocation background;
	
	//Energy Fields
	private static final int GUI_ENERGY_X = 126;
	private static final int GUI_ENERGY_Y = 5;
	private static final int GUI_ENERGY_SPACE = 1;
	private static final int ENERGY_X = 176;
	private static final int ENERGY_Y = 0;
	private static final int ENERGY_WIDTH = 10;
	private static final int ENERGY_HEIGHT = 72;
	
	//Progress Fields
	private static final int PROGRESS_1_WIDTH = 41;
	private static final int PROGRESS_1_HEIGHT = 16;
	private static final int PROGRESS_1_TEXTURE_X = 215;
	private static final int PROGRESS_1_TEXTURE_Y = 240;
	private static final int PROGRESS_1_X = 127;
	private static final int PROGRESS_1_Y = 78;
	private static final float PROGRESS_1_START = 0;
	private static final float PROGRESS_1_END = 6.01504F;
	private static final int PROGRESS_2_WIDTH = 116;
	private static final int PROGRESS_2_HEIGHT = 12;
	private static final int PROGRESS_2_TEXTURE_X = 101;
	private static final int PROGRESS_2_TEXTURE_Y = 244;
	private static final int PROGRESS_2_X = 13;
	private static final int PROGRESS_2_Y = 82;
	private static final float PROGRESS_2_START = 6.01504F;
	private static final float PROGRESS_2_END = 49.62406F;
	private static final int PROGRESS_3_WIDTH = 19;
	private static final int PROGRESS_3_HEIGHT = 35;
	private static final int PROGRESS_3_TEXTURE_X = 237;
	private static final int PROGRESS_3_TEXTURE_Y = 204;
	private static final int PROGRESS_3_X = 5;
	private static final int PROGRESS_3_Y = 48;
	private static final float PROGRESS_3_START = 49.62406F;
	private static final float PROGRESS_3_END = 62.78195F;
	private static final int PROGRESS_4_WIDTH = 99;
	private static final int PROGRESS_4_HEIGHT = 62;
	private static final int PROGRESS_4_TEXTURE_X = 0;
	private static final int PROGRESS_4_TEXTURE_Y = 182;
	private static final int PROGRESS_4_X = 5;
	private static final int PROGRESS_4_Y = 15;
	private static final float PROGRESS_4_START = 62.78195F;
	private static final float PROGRESS_4_END = 100.0F;
	
	private int maxProgress;
	
	public CoreCrafterGui(TileEnergyCoreCrafter tileEntity, CoreCrafterContainer container, ResourceLocation resource) {
		super(tileEntity, container, WIDTH, HEIGHT, resource, GUI_ENERGY_X, GUI_ENERGY_Y, GUI_ENERGY_SPACE, ENERGY_X, ENERGY_Y, new int[] {0, 1, 2, 3});
		this.tileEntity = tileEntity;
		this.container = container;
		this.background = resource;
		xSize = WIDTH;
		ySize = HEIGHT;
		maxProgress = tileEntity.getMaxProgress();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        //draw progress
        int progress = tileEntity.getCurrentProgress();
        float progressPercentage = ((float)progress / maxProgress) * 100;
        float scaledProgress;
        
        if(progressPercentage >= PROGRESS_1_START) {
        	scaledProgress = progressPercentage / (PROGRESS_1_END - PROGRESS_1_START);
        	if(scaledProgress > 1) {
        		scaledProgress = 1;
        	}
        	drawTexturedModalRect(guiLeft + PROGRESS_1_X, guiTop + PROGRESS_1_Y, PROGRESS_1_TEXTURE_X, PROGRESS_1_TEXTURE_Y, PROGRESS_1_WIDTH, (int) (PROGRESS_1_HEIGHT * scaledProgress));
        }
        if(progressPercentage >= PROGRESS_2_START) {
        	scaledProgress = (progressPercentage - PROGRESS_2_START) / (PROGRESS_2_END - PROGRESS_2_START);
        	if(scaledProgress > 1) {
        		scaledProgress = 1;
        	}
        	drawTexturedModalRect(guiLeft + (int)(PROGRESS_2_X + PROGRESS_2_WIDTH * (1 - scaledProgress)), guiTop + PROGRESS_2_Y, (int)(PROGRESS_2_TEXTURE_X + PROGRESS_2_WIDTH * (1 - scaledProgress)), PROGRESS_2_TEXTURE_Y, (int)(PROGRESS_2_WIDTH * scaledProgress), PROGRESS_2_HEIGHT);
        }
        if(progressPercentage >= PROGRESS_3_START) {
        	scaledProgress = (progressPercentage - PROGRESS_3_START) / (PROGRESS_3_END - PROGRESS_3_START);
        	if(scaledProgress > 1) {
        		scaledProgress = 1;
        	}
        	drawTexturedModalRect(guiLeft + PROGRESS_3_X, guiTop + (int)(PROGRESS_3_Y + PROGRESS_3_HEIGHT * (1 - scaledProgress)), PROGRESS_3_TEXTURE_X, (int)(PROGRESS_3_TEXTURE_Y + PROGRESS_3_HEIGHT * (1 - scaledProgress)), PROGRESS_3_WIDTH, (int)(PROGRESS_3_HEIGHT * scaledProgress));
        }
        if(progressPercentage >= PROGRESS_4_START) {
        	scaledProgress = (progressPercentage - PROGRESS_4_START) / (PROGRESS_4_END - PROGRESS_4_START);
        	if(scaledProgress > 1) {
        		scaledProgress = 1;
        	}
        	drawTexturedModalRect(guiLeft + PROGRESS_4_X, guiTop + PROGRESS_4_Y, PROGRESS_4_TEXTURE_X, PROGRESS_4_TEXTURE_Y, (int)(scaledProgress * PROGRESS_4_WIDTH), PROGRESS_4_HEIGHT);
        }
	}

}
