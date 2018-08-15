package eyeroh.elementalmastery.gui;

import java.awt.Color;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.collector.CollectorTileEntity;
import eyeroh.elementalmastery.machine.generator.GeneratorContainer;
import eyeroh.elementalmastery.machine.generator.GeneratorTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GeneratorGui extends GuiContainer{
	public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    public GeneratorTileEntity tileEntity;
    public GeneratorContainer container;

    private ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatoropal.png");
    
    public static final int progressBarLength = 67;
    public static final int energyBarHeight = 73;
    public static final int energyBarY = 6;
    public static final int energyBarTextureY = 0;
    public static final int gemHeight = 16;
    public static final int gemY = 34;
    public static final int gemYTexture = 0;

    public GeneratorGui(GeneratorTileEntity tileEntity, GeneratorContainer container, ResourceLocation resourceLocation) {
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
        if(tileEntity.getCurrentProgress() > 0) {
        	float scaledProgressFactor = ((float) tileEntity.getCurrentProgress() / tileEntity.getMaxProgress());
        	int scaledProgressBar = (int) (scaledProgressFactor * progressBarLength);
        	drawTexturedModalRect(guiLeft + 81, guiTop + 35, 0, 166, scaledProgressBar, 16);
        	int scaledGemHeight = (int) ((1-scaledProgressFactor) * gemHeight);
        	int scaledGemY = (int) (gemY + (gemHeight - scaledGemHeight));
        	int scaledGemYTexture = (int) (gemYTexture + (gemHeight - scaledGemHeight));
        	drawTexturedModalRect(guiLeft + 60, guiTop + scaledGemY, 186, scaledGemYTexture, 16, scaledGemHeight);
       }
       if(tileEntity.getCurrentEnergy() > 0) {
		   float scaledEnergyFactor = ((float)tileEntity.getCurrentEnergy() / tileEntity.getMaxEnergy());
		   int scaledEnergyHeight = (int) (scaledEnergyFactor * energyBarHeight);
		   int scaledEnergyY = (int) (energyBarY + (energyBarHeight - scaledEnergyHeight));
		   int scaledEnergyTexture = (int) (energyBarTextureY + (energyBarHeight - scaledEnergyHeight));
		   drawTexturedModalRect(guiLeft + 158, guiTop + 6, 158, 6, 10, energyBarHeight);
		   drawTexturedModalRect(guiLeft + 158, guiTop + scaledEnergyY, 176, scaledEnergyTexture, 10, scaledEnergyHeight);
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
