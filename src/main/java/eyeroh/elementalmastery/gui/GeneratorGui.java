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
    public GeneratorTileEntity tileEntity = new GeneratorTileEntity();

    private static final ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/generatoropal.png");

    public GeneratorGui(GeneratorTileEntity tileEntity, GeneratorContainer container) {
        super(container);
        this.tileEntity = tileEntity;
        xSize = WIDTH;
        ySize = HEIGHT;
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
}
