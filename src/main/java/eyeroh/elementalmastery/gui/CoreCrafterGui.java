package eyeroh.elementalmastery.gui;

import eyeroh.elementalmastery.machine.crafting.CoreCrafterContainer;
import eyeroh.elementalmastery.machine.crafting.TileEnergyCoreCrafter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class CoreCrafterGui extends GuiContainer {
	public static final int WIDTH = 172;
	public static final int HEIGHT = 182;
	public TileEnergyCoreCrafter tileEntity;
	public CoreCrafterContainer container;
	private ResourceLocation background;
	
	private static final int GUI_ENERGY_X = 126;
	private static final int GUI_ENERGY_Y = 5;
	private static final int GUI_ENERGY_SPACE = 1;
	private static final int ENERGY_X = 176;
	private static final int ENERGY_Y = 0;
	private static final int ENERGY_WIDTH = 10;
	private static final int ENERGY_HEIGHT = 72;
	
	public CoreCrafterGui(TileEnergyCoreCrafter tileEntity, CoreCrafterContainer container, ResourceLocation resource) {
		super(container);
		this.tileEntity = tileEntity;
		this.container = container;
		this.background = resource;
		xSize = WIDTH;
		ySize = HEIGHT;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        
        //draw energy
        for(int i = 0; i < 4; i++) {
        	float scaledEnergyFactor = ((float)tileEntity.getCurrentEnergy(i) / tileEntity.getMaxEnergy(i));
        	int scaledEnergyHeight = (int) (scaledEnergyFactor * ENERGY_HEIGHT);
        	int scaledEnergyY = (int) (GUI_ENERGY_Y + (ENERGY_HEIGHT - scaledEnergyHeight));
        	int scaledEnergyTexture = (int) (ENERGY_Y + (ENERGY_HEIGHT - scaledEnergyHeight));
        	drawTexturedModalRect(guiLeft + GUI_ENERGY_X + i * (ENERGY_WIDTH + GUI_ENERGY_SPACE), guiTop + scaledEnergyY, ENERGY_X + ENERGY_WIDTH * i, scaledEnergyTexture, ENERGY_WIDTH, scaledEnergyHeight);
        }
	}

}
