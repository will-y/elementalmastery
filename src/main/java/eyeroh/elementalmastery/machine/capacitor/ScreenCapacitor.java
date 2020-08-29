package eyeroh.elementalmastery.machine.capacitor;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import eyeroh.elementalmastery.ElementalMastery;
import eyeroh.elementalmastery.machine.util.EnergyType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ScreenCapacitor extends Screen {

    TileEntityCapacitorController tileEntity;
    public static final int WIDTH = 176;
    public static final int HEIGHT = 166;
    public static final int energyBarHeight= 73;
    public static final int energyBarY = 43;
    public static final int energyBarTextureY = 0;

    private ResourceLocation GUI = new ResourceLocation(ElementalMastery.MODID, "textures/gui/capacitor.png");

    public ScreenCapacitor(TileEntityCapacitorController tile) {
        super(ITextComponent.func_244388_a("Capacitor"));
        this.tileEntity = tile;
    }

    @Override
    public void func_230430_a_(MatrixStack matrix, int mouseX, int mouseY, float p_230430_4_) {
        this.field_230706_i_.getTextureManager().bindTexture(GUI);
    	int guiLeft = (this.field_230708_k_ - WIDTH)/2;
    	int guiTop = (this.field_230709_l_ - HEIGHT)/2;
        func_238474_b_(matrix, guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);
        int i = 0;
        for(EnergyType type : EnergyType.values()) {
        	if(tileEntity.getCurrentEnergy(type) > 0) {
        		float scaledEnergyFactor = ((float)tileEntity.getCurrentEnergy(type) / tileEntity.getMaxEnergy(type));
        		int scaledEnergyHeight = (int) (scaledEnergyFactor * energyBarHeight);
        		int scaledEnergyY = (int) (energyBarY + (energyBarHeight - scaledEnergyHeight));
        		int scaledEnergyTexture = (int) (energyBarTextureY + (energyBarHeight - scaledEnergyHeight));
                func_238474_b_(matrix,guiLeft + 21 + i*38, guiTop + energyBarY, 21, 43, 20, energyBarHeight);
                func_238474_b_(matrix,guiLeft + 21 + i*38, guiTop + scaledEnergyY, 176 + i*20, scaledEnergyTexture, 20, scaledEnergyHeight);
        	}
        	i++;
        }
        drawEnergyTooltips(matrix, mouseX, mouseY, guiTop, guiLeft);
    }

    private void drawEnergyTooltips(MatrixStack matrix, int x, int y, int top, int left) {
    	if(y > top + energyBarY && y < top + energyBarY + energyBarHeight) {
    	    int i = 0;
    		for(EnergyType type : EnergyType.values()) {
    			if(x > left + 21 + i * 38 && x < left + 21 + i * 38 + 20) {
    				this.renderToolTip(matrix, Lists.transform(this.tileEntity.getToolTipString(type), ITextComponent::func_241878_f), x, y, this.field_230712_o_);
    			}
    			i++;
    		}
    	}
    }

    @Override
    // isPauseScreen
    public boolean func_231177_au__() {
        return false;
    }
}
