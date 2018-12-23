package eyeroh.elementalmastery.gui;

import java.awt.Color;
import java.util.Random;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.collector.CollectorBasicTileEntity;
import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiEnergyAcceptor extends GuiContainer {
	public static final int WIDTH = 177;
    public static final int HEIGHT = 167;
    public static final int progressBarLength = 158;
    public CollectorBasicTileEntity tileEntity = new CollectorBasicTileEntity();
    
    private int progressBarCounter = 0;
    private int progressBarMaxCounter = 5;
    private int progressBarTexture = 0;
    private int progressBarTextures = 4;
    Random rand = new Random();

    private static final ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/collectorbasic.png");

    public GuiEnergyAcceptor(CollectorBasicTileEntity tileEntity, CollectorContainer container) {
        super(container);
        this.tileEntity = tileEntity;
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        if(tileEntity.getCurrentProgress() > 0) {
        	float scaledProgressFactor = ((float) tileEntity.getCurrentProgress() / tileEntity.getMaxProgress());
        	int scaledProgressBar = (int) (scaledProgressFactor * progressBarLength);
        	if(progressBarCounter == progressBarMaxCounter) {
        		if(progressBarTexture == progressBarTextures-1) {
        			progressBarTexture = 0;
        		} else {
        			progressBarTexture++;
        		}
        		progressBarCounter = 0;
        	}
        	drawTexturedModalRect(guiLeft + 10, guiTop + 16, 0, 170 + progressBarTexture * 5, scaledProgressBar, 4);
        	progressBarCounter++;
        }
    }
    
    @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		fontRenderer.drawString(tileEntity.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	super.drawScreen(mouseX, mouseY, partialTicks);
    	renderHoveredToolTip(mouseX, mouseY);
    }
}
