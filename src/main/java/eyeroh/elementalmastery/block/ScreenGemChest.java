package eyeroh.elementalmastery.block;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import eyeroh.elementalmastery.ElementalMastery;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ScreenGemChest extends ContainerScreen<ContainerGemChest> {

    private ResourceLocation GUI = new ResourceLocation(ElementalMastery.MODID, "textures/gui/gui_chestopal.png");

    public ScreenGemChest(ContainerGemChest container, PlayerInventory inventory, ITextComponent name) {
        super(container, inventory, name);
        this.xSize = 175;
        this.ySize = 221;
    }

    @Override
    // render
    public void func_230430_a_(MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        // renderBackground
        this.func_230446_a_(matrix);
        super.func_230430_a_(matrix, mouseX, mouseY, partialTicks);
        this.func_230459_a_(matrix, mouseX, mouseY);
        // this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    //drawGuiContainerForegroundLayer
    protected void func_230451_b_ (MatrixStack matrix, int mouseX, int mouseY) {
        // font
        this.field_230712_o_.func_238421_b_(matrix, "Opal Barrel", this.field_230712_o_.getStringWidth("Opal Barrel") / 2, 6.0F, 4210752);
    }

    @Override
    //drawGuiContainerBackgroundLayer
    protected void func_230450_a_ (MatrixStack matrix, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bindTexture(GUI);
        // field_230708_k_  = width
        // field_230709_l_  = height
        int relX = (this.field_230708_k_ - this.xSize) / 2;
        int relY = (this.field_230709_l_ - this.ySize) / 2;
        // blit
        this.func_238474_b_(matrix, relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
