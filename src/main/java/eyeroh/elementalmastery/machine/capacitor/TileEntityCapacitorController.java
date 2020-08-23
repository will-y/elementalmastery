package eyeroh.elementalmastery.machine.capacitor;

import java.util.ArrayList;
import java.util.Arrays;

import javax.management.NotificationBroadcaster;

import eyeroh.elementalmastery.block.ModBlocks;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import io.netty.channel.MaxBytesRecvByteBufAllocator;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;

public class TileEntityCapacitorController extends TileEntity implements ITickable{
	
	private int[] energyAmount;
	private int[] energyMax;
	private boolean active;
	private CapacitorDirection capacitorDirection;
	//private ArrayList<TileEnergyAcceptor> machines = new ArrayList<TileEnergyAcceptor>();
	
	public TileEntityCapacitorController() {
		energyAmount = new int[] {0, 0, 0, 0};
		energyMax = new int[] {0, 0, 0, 0};
		active = false;
	}
	
	
	public boolean checkForMultiBlock() {
		if(check3x3("x", -1)) {
			capacitorDirection = new CapacitorDirection("x", -1);
			return true;
		} else if(check3x3("x", 1)) {
			capacitorDirection = new CapacitorDirection("x", 1);
			return true;
		} else if (check3x3("z", -1)) {
			capacitorDirection = new CapacitorDirection("z", -1);
			return true;
		} else if (check3x3("z", 1)) {
			capacitorDirection = new CapacitorDirection("z", 1);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean check3x3(String axis, int direction) {
		if(!this.world.isRemote) {
			if(axis == "X" || axis == "x") {
				if(direction == -1) {
					for (int x = -1; x < 2; x++) {
						for(int y = -1; y < 2; y++) {
							for(int z = -2; z < 1; z++) {
								if(!(x==0 && y==0 && z==0)) {
									if(!(z==-1 && x==0 && y==0)) {
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorGlass))) {
											return false;
										}
									}
								}
							}
						}
					}
					return true;
				} else if (direction == 1) {
					for (int x = -1; x < 2; x++) {
						for(int y = -1; y < 2; y++) {
							for(int z = 0; z < 3; z++) {
								if(!(x==0 && y==0 && z==0)) {
									if(!(z==1 && x==0 && y==0)) {
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorGlass))) {
											return false;
										}
									}
								}
							}
						}
					}
					return true;
				}
			} else if (axis == "Z" || axis == "z") {
				if(direction == -1) {
					for (int x = -2; x < 1; x++) {
						for(int y = -1; y < 2; y++) {
							for(int z = -1; z < 2; z++) {
								if(!(x==0 && y==0 && z==0)) {
									if(!(x==-1 && z==0 && y==0)) {
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorGlass))) {
											return false;
										}
									}
								}
							}
						}
					}
					return true;
				} else if(direction == 1) {
					for (int x = 0; x < 3; x++) {
						for(int y = -1; y < 2; y++) {
							for(int z = -1; z < 2; z++) {
								if(!(x==0 && y==0 && z==0)) {
									if(!(x==1 && z==0 && y==0)) {
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModMachines.capacitorGlass))) {
											return false;
										}
									}
								}
							}
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean check5x5() {
		return false;
	}
	
	public void addMaxEnergy(World world) {
		Block block = Blocks.AIR;
		if(this.capacitorDirection.getAxis() == "x") {
			if(this.capacitorDirection.getDirection() == 1) {
				block = world.getBlockState(this.pos.add(0, 0, 1)).getBlock();
			} else if(this.capacitorDirection.getDirection() == -1) {
				block = world.getBlockState(this.pos.add(0, 0, -1)).getBlock();
			}
		} else if (this.capacitorDirection.getAxis() == "z") {
			if(this.capacitorDirection.getDirection() == 1) {
				block = world.getBlockState(this.pos.add(1, 0, 0)).getBlock();
			} else if(this.capacitorDirection.getDirection() == -1) {
				block = world.getBlockState(this.pos.add(-1, 0, 0)).getBlock();
			}
		}
		if(Block.isEqualTo(block, ModMachines.capacitorOpal)) {
			this.energyMax[0] += 100000;
		} else if(Block.isEqualTo(block, ModMachines.capacitorTopaz)) {
			this.energyMax[1] += 100000;
		} else if(Block.isEqualTo(block, ModMachines.capacitorRuby)) {
			this.energyMax[2] += 100000;
		} else if(Block.isEqualTo(block, ModMachines.capacitorSapphire)) {
			this.energyMax[3] += 100000;
		} else if(Block.isEqualTo(block,  ModMachines.capacitorMulti)) {
			this.energyMax[0] += 25000;
			this.energyMax[1] += 25000;
			this.energyMax[2] += 25000;
			this.energyMax[3] += 25000;
		}
	}
	
	
	
	public int[] getMaxEnergy() {
		return this.energyMax;
	}
	
	public int getMaxEnergy(int type){
		return energyMax[type];
	}
	
	public int getEnergy(int type) {
		return energyAmount[type];
	}
	
	public int[] getEnergy() {
		return this.energyAmount;
	}
	
	public void addEnergy(int type, int amount) {
		
		if(energyAmount[type] + amount >= energyMax[type]) {
			energyAmount[type] = energyMax[type];
		} else {
			energyAmount[type] += amount;
		}
		markDirty();
	}
	
	public void setActive() {
		active = true;
		addMaxEnergy(world);
		markDirty();
	}
	
	public void setDeActive() {
		active = false;
		markDirty();
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public int[] getCapacitorTypes() {
		markDirty();
		return new int[] {0, 0, 0, 0};
	}
	
	public boolean canAcceptEnergy(int type, int amount) {
		if(active) {
			
			if(energyAmount[type] + amount >= energyMax[type]) {
				return false;
			}
			return true;
		}
		return false;		
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
        energyAmount = compound.getIntArray("energy");
        active = compound.getBoolean("active");
        energyMax = compound.getIntArray("energy_max");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setIntArray("energy", energyAmount);
        compound.setBoolean("active", active);
        compound.setIntArray("energy_max", energyMax);
        return super.writeToNBT(compound);
    }
    
    public void showEnergyAmount(EntityPlayer player) {
    	TextComponentTranslation component = new TextComponentTranslation("message.elementalmastery.capacitor_amount", energyAmount[0] + "/" + energyMax[0] + "(O), " + energyAmount[1] + "/" + energyMax[1] + "(T), " + energyAmount[2] + "/" + energyMax[2] + "(R), " + energyAmount[3] + "/" + energyMax[3] + "(S)");
    	component.getStyle().setColor(TextFormatting.BLUE);
        player.sendStatusMessage(component, true);
    }
    
    public boolean isFull(int type) {
    	
    	if(energyAmount[type] == energyMax[type]) {
    		return true;
    	}
    	return false;
    }
    
	@Override
	public void update() {
//		if(counter >= 20) {
//			int[] usage;
//			for(TileEnergyAcceptor machine : machines) {
//				usage = machine.getUsage();
//				for(int i = 0; i < usage.length; i++) {
//					if(energyAmount[i] - usage[i] >= 0) {
//						if(machine.addEnergy(i, usage[i])) {
//							energyAmount[i]  -= usage[i];
//						}
//					}
//				}
//			}
//			counter = 0;
//		}
//		counter++;
	}
	
//	public void addMachine(TileEnergyAcceptor machine) {
//		if(!machines.contains(machine))
//			machines.add(machine);
//	}
	
//	public void removeMachine(TileEnergyAcceptor machine) {
//		machines.remove(machine);
//	}
//	
	public int takeEnergy(int amount, int type) {
		if(this.energyAmount[type] >= amount) {
			this.energyAmount[type] -= amount;
			this.markDirty();
			return amount;
		} else {
			int temp = energyAmount[type];
			energyAmount[type] = 0;
			this.markDirty();
			return temp;
		}
	}
	
	@Override
	public String toString() {
		return "Capacitor at " + this.pos.toString() + "\nWith energy: " + Arrays.toString(this.energyAmount);
	}
	
	public ArrayList<String> getToolTipString(int type) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(this.getEnergy(type) + "/" + this.getMaxEnergy(type));
		return list;
	}
}
