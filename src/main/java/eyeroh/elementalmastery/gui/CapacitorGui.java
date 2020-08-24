package eyeroh.elementalmastery.gui;

import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.util.ResourceLocation;

public class CapacitorGui {
	public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    public TileEntityCapacitorController tileEntity = new TileEntityCapacitorController();
    public static final int energyBarHeight= 73;
    public static final int energyBarY = 43;
    public static final int energyBarTextureY = 0;
    

    private static final ResourceLocation background = new ResourceLocation(ElementalMastery.MODID, "textures/gui/capacitor.png");

    public CapacitorGui(TileEntityCapacitorController tileEntity) {
        this.tileEntity = tileEntity;
    }
    
//    @Override
//    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//    	super.drawScreen(mouseX, mouseY, partialTicks);
//    	mc.getTextureManager().bindTexture(background);
//    	int guiLeft = (this.width - WIDTH)/2;
//    	int guiTop = (this.height - HEIGHT)/2;
//        drawTexturedModalRect(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);
//
//        for(int i = 0; i < 4; i++) {
//        	if(tileEntity.getEnergy(i) > 0) {
//        		float scaledEnergyFactor = ((float)tileEntity.getEnergy(i) / tileEntity.getMaxEnergy(i));
//        		int scaledEnergyHeight = (int) (scaledEnergyFactor * energyBarHeight);
//        		int scaledEnergyY = (int) (energyBarY + (energyBarHeight - scaledEnergyHeight));
//        		int scaledEnergyTexture = (int) (energyBarTextureY + (energyBarHeight - scaledEnergyHeight));
//        		drawTexturedModalRect(guiLeft + 21 + i*38, guiTop + energyBarY, 21, 43, 20, energyBarHeight);
//        		drawTexturedModalRect(guiLeft + 21 + i*38, guiTop + scaledEnergyY, 176 + i*20, scaledEnergyTexture, 20, scaledEnergyHeight);
//        	}
//        }
//        drawEnergyTooltips(mouseX, mouseY, guiTop, guiLeft);
//    }
//
//    public boolean doesGuiPauseGame() {
//        return false;
//    }
//
//    private void drawEnergyTooltips(int x, int y, int top, int left) {
//    	if(y > top + energyBarY && y < top + energyBarY + energyBarHeight) {
//    		for(int i = 0; i < 4; i++) {
//    			if(x > left + 21 + i * 38 && x < left + 21 + i * 38 + 20) {
//    				this.drawHoveringText(this.tileEntity.getToolTipString(i), x, y, this.fontRenderer);
//    			}
//    		}
//    	}
//    }
}