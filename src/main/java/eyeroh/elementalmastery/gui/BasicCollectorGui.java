package eyeroh.elementalmastery.gui;

import java.awt.Color;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import eyeroh.elementalmastery.machine.collector.CollectorTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class BasicCollectorGui extends GuiContainer{
	public static final int WIDTH = 180;
    public static final int HEIGHT = 152;
    public CollectorTileEntity tileEntity = new CollectorTileEntity();

    private static final ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/basicgui.png");

    public BasicCollectorGui(CollectorTileEntity tileEntity, CollectorContainer container) {
        super(container);
        this.tileEntity = tileEntity;
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
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