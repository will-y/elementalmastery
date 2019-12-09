package eyeroh.elementalmastery.gui;

import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class MinerGui extends GuiEnergyAcceptor {
	
	public static final int WIDTH = 176;
	public static final int HEIGHT = 166;

	public MinerGui(TileEnergyAcceptor tileEntity, Container container, ResourceLocation background) {
		super(tileEntity, container, WIDTH, HEIGHT, background, 128, 6, 1, 176, 0, new int[] {0, 1, 2, 3});
	}
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }
}
