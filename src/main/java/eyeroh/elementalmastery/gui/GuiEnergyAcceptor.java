package eyeroh.elementalmastery.gui;

import java.awt.Color;

import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiEnergyAcceptor extends GuiContainer {
	
	public int width;
	public int height;
	private ResourceLocation background;
	
	//Energy Fields
	private int energyX;
	private int energyY;
	private int energySpace;
	private int energyTextureX;
	private int energyTextureY;
	private int[] energyTypes;
	
	private static final int ENERGY_WIDTH = 10;
	private static final int ENERGY_HEIGHT = 72;
    
	TileEnergyAcceptor tileEntity;
    
    public GuiEnergyAcceptor(TileEnergyAcceptor tileEntity, Container container, int width, int height, ResourceLocation background, int energyX, int energyY, int energySpace, int energyTextureX, int energyTextureY, int[] energyTypes) {
        super(container);
        this.width = width;
        this.height = height;
        this.background = background;
        this.energyX = energyX;
        this.energyY = energyY;
        this.energySpace = energySpace;
        this.energyTextureX = energyTextureX;
        this.energyTextureY = energyTextureY;
        this.tileEntity = tileEntity;
        this.energyTypes = energyTypes;
        xSize = width;
		ySize = height;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	//draw background
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        
        //draw energy
        for(int i = 0; i < energyTypes.length; i++) {
        	float scaledEnergyFactor = ((float)tileEntity.getCurrentEnergy(energyTypes[i]) / tileEntity.getMaxEnergy(energyTypes[i]));
        	int scaledEnergyHeight = (int) (scaledEnergyFactor * ENERGY_HEIGHT);
        	int scaledEnergyY = (int) (energyY + (ENERGY_HEIGHT - scaledEnergyHeight));
        	int scaledEnergyTexture = (int) (energyTextureY + (ENERGY_HEIGHT - scaledEnergyHeight));
        	drawTexturedModalRect(guiLeft + energyX + i * (ENERGY_WIDTH + energySpace), guiTop + scaledEnergyY, energyTextureX + ENERGY_WIDTH * i, scaledEnergyTexture, ENERGY_WIDTH, scaledEnergyHeight);
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
    	drawEnergyTooltips(mouseX, mouseY);
    }
    
    private void drawEnergyTooltips(int x, int y) {
    	for(int i = 0; i < energyTypes.length; i++) {
    		if(x > guiLeft + energyX + ENERGY_WIDTH * i && x < guiLeft + energyX + ENERGY_WIDTH * (i + 1) && y > guiTop + energyY && y < guiTop + energyY + ENERGY_HEIGHT) {
    			this.drawHoveringText(this.tileEntity.getToolTipString(energyTypes[i]), x, y, this.fontRenderer);
    		}
    	}
    }
}
