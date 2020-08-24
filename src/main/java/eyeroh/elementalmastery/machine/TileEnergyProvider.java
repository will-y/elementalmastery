package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.capacitor.TileEntityCapacitorController;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class TileEnergyProvider extends TileEntity implements ITickable {
    public BlockPos linkedCapacitor = null;
    public boolean linked = false;
    public int type;
    public int energyPerSecond;

    public TileEnergyProvider(int type, int energyPerSecond) {
        super(TileEntityType.CHEST);
        this.type = type;
        this.energyPerSecond = energyPerSecond;
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return write(new CompoundNBT());
    }

//    @Override
//    public SPacketUpdateTileEntity getUpdatePacket() {
//        NBTTagCompound nbtTag = new NBTTagCompound();
//        this.writeToNBT(nbtTag);
//        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
//    }
//
//    @Override
//    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
//        this.readFromNBT(packet.getNbtCompound());
//    }
//
//    @Override
//    public void readFromNBT(NBTTagCompound compound) {
//        super.readFromNBT(compound);
//        linked = compound.getBoolean("linked");
//        linkedCapacitor = BlockPos.fromLong(compound.getLong("linkedCapacitor"));
//        type = compound.getInteger("type");
//    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putBoolean("linked", linked);
        if(linked) {
            compound.putLong("linkedCapacitor", linkedCapacitor.toLong());
        }
        compound.putInt("type", type);

        return compound;
    }

    public boolean hasCustomName() {
        return false;
    }

//    @Override
//    public ITextComponent getDisplayName() {
//        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
//    }

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
