package eyeroh.elementalmastery.gui;

import java.awt.Color;

import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import eyeroh.elementalmastery.machine.collector.TileCollector;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class CollectorGui extends GuiContainer{
	public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    public TileCollector tileEntity;
    public CollectorContainer container;

    private ResourceLocation background;
    
    public static final int progressBarLength = 67;
    public static final int energyBarHeight = 73;
    public static final int energyBarY = 6;
    public static final int energyBarTextureY = 0;
    public static final int gemHeight = 16;
    public static final int gemY = 34;
    public static final int gemYTexture = 0;
    
    public CollectorGui(TileCollector tileEntity, CollectorContainer container, ResourceLocation resourceLocation) {
        super(container);
        this.tileEntity = tileEntity;
        this.container = container;
        xSize = WIDTH;
        ySize = HEIGHT;
        this.background = resourceLocation;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
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
