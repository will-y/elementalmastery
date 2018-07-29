package eyeroh.elementalmastery.proxy;

import eyeroh.elementalmastery.machine.collector.CollectorContainer;
import eyeroh.elementalmastery.machine.collector.CollectorTileEntity;
import gui.BasicCollectorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof CollectorTileEntity) {
            return new CollectorContainer(player.inventory, player.inventory, (CollectorTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof CollectorTileEntity) {
            CollectorTileEntity containerTileEntity = (CollectorTileEntity) te;
            return new BasicCollectorGui(containerTileEntity, new CollectorContainer(player.inventory, player.inventory, containerTileEntity));
        }
        return null;
    }
}