package eyeroh.elementalmastery.gui;

import java.awt.Color;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class CapacitorGui extends GuiScreen{
	public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    public TileEntityCapacitorController tileEntity = new TileEntityCapacitorController();

    private static final ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/capacitor.png");

    public CapacitorGui(TileEntityCapacitorController tileEntity) {
        this.tileEntity = tileEntity;
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	super.drawScreen(mouseX, mouseY, partialTicks);
    	mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect((this.width - WIDTH)/2, (this.height - HEIGHT)/2, 0, 0, WIDTH, HEIGHT);
    }
    
    
}