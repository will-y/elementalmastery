package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public abstract class TileEnergyProvider extends TileEntity implements ITickable {
    public BlockPos linkedCapacitor = null;
    public boolean linked = false;
    public int type;
    public int energyPerSecond;

    public TileEnergyProvider(int type, int energyPerSecond) {
        this.type = type;
        this.energyPerSecond = energyPerSecond;
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        linked = compound.getBoolean("linked");
        linkedCapacitor = BlockPos.fromLong(compound.getLong("linkedCapacitor"));
        type = compound.getInteger("type");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("linked", linked);
        if(linked) {
            compound.setLong("linkedCapacitor", linkedCapacitor.toLong());
        }
        compound.setInteger("type", type);

        return compound;
    }

    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    public boolean canExportEnergy() {
        if(linked) {
            TileEntity capacitor = world.getTileEntity(linkedCapacitor);
            if(capacitor instanceof TileEntityCapacitorController) {
                if(((TileEntityCapacitorController) capacitor).canAcceptEnergy(type, this.energyPerSecond/20)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;

            }
        } else {
            return false;
        }
    }

    public void setCapacitor(BlockPos pos) {
        this.linkedCapacitor = pos;
        linked = true;
        markDirty();
    }

    public boolean isCapacitorFull() {
        if(linked) {
            TileEntity te = world.getTileEntity(linkedCapacitor);
            if(te instanceof TileEntityCapacitorController) {
                TileEntityCapacitorController capacitor = (TileEntityCapacitorController) te;
                return capacitor.isFull(type);
            }
        }
        return true;
    }

    public void sendPower(int amount) {
        if(!world.isRemote) {
            TileEntity capacitor = world.getTileEntity(linkedCapacitor);
            ((TileEntityCapacitorController) capacitor).addEnergy(type, amount);
        }
    }

    public abstract String getName();
}
