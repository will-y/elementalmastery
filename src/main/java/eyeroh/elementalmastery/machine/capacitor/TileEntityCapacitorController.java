package eyeroh.elementalmastery.machine.capacitor;

import eyeroh.elementalmastery.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class TileEntityCapacitorController extends TileEntity {
	
	int[] energyAmount = new int[] {0, 0, 0, 0};
	int[] energyMax = new int[] {0, 0, 0, 0};
	boolean active = false;
	CapacitorDirection capacitorDirection;
	
	
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
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorGlass))) {
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
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorGlass))) {
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
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorGlass))) {
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
										if(!(Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorWall) || Block.isEqualTo(this.getWorld().getBlockState(this.pos.add(x, y, z)).getBlock(), ModBlocks.capacitorGlass))) {
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
		if(Block.isEqualTo(block, ModBlocks.capacitorOpal)) {
			this.energyMax[0] += 100000;
		} else if(Block.isEqualTo(block, ModBlocks.capacitorTopaz)) {
			this.energyMax[1] += 100000;
		} else if(Block.isEqualTo(block, ModBlocks.capacitorRuby)) {
			this.energyMax[2] += 100000;
		} else if(Block.isEqualTo(block, ModBlocks.capacitorSapphire)) {
			this.energyMax[3] += 100000;
		} else if(Block.isEqualTo(block,  ModBlocks.capacitorMulti)) {
			this.energyMax[0] += 25000;
			this.energyMax[1] += 25000;
			this.energyMax[2] += 25000;
			this.energyMax[3] += 25000;
		}
	}
	
	
	
	public int[] getMaxEnergy() {
		return this.energyMax;
	}
	
	public int getEnergy(String type) {
		if(type == "opal" && energyAmount[0] < energyMax[0]) {
			return energyAmount[0];
		} else if (type == "topaz" && energyAmount[1] < energyMax[1]) {
			return energyAmount[1];
		} else if (type == "ruby" && energyAmount[2] < energyMax[2]) {
			return energyAmount[2];
		} else if (type == "sapphire" && energyAmount[3] < energyMax[3]) {
			return energyAmount[3];
		} else {
			return 0;
		}
	}
	
	public int[] getEnergy() {
		return this.energyAmount;
	}
	
	public void addEnergy(String type, int amount) {
		if(type == "opal") {
			if(energyAmount[0] + amount >= energyMax[0]) {
				energyAmount[0] = energyMax[0];
			} else {
				energyAmount[0] += amount;
			}
		} else if (type == "topaz") {
			if(energyAmount[1] + amount >= energyMax[1]) {
				energyAmount[1] = energyMax[1];
			} else {
				energyAmount[1] += amount;
			}
		} else if (type == "ruby") {
			if(energyAmount[2] + amount >= energyMax[2]) {
				energyAmount[2] = energyMax[2];
			} else {
				energyAmount[2] += amount;
			}
		} else if (type == "sapphire") {
			if(energyAmount[3] + amount >= energyMax[3]) {
				energyAmount[3] = energyMax[3];
			} else {
				energyAmount[3] += amount;
			}
		}
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
	
	public boolean canAcceptPower(String type, int amount) {
		if(active) {
			if(type == "opal") {
				if(energyAmount[0] + amount > energyMax[0]) {
					return false;
				}
				return true;
			} else if(type == "topaz") {
				if(energyAmount[1] + amount > energyMax[1]) {
					return false;
				}
				return true;
			} else if(type == "ruby") {
				if(energyAmount[2] + amount > energyMax[2]) {
					return false;
				}
				return true;
			} else if (type == "sapphire") {
				if(energyAmount[3] + amount > energyMax[3]) {
					return false;
				}
				return true;
			} else {
				return false;
			}
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
        super.writeToNBT(compound);
        compound.setIntArray("energy", energyAmount);
        compound.setBoolean("active", active);
        compound.setIntArray("energy_max", energyMax);
        return compound;
    }
    
    public void showEnergyAmount(EntityPlayer player) {
    	TextComponentTranslation component = new TextComponentTranslation("message.elementalmastery.capacitor_amount", energyAmount[0] + "/" + energyMax[0] + "(O), " + energyAmount[1] + "/" + energyMax[1] + "(T), " + energyAmount[2] + "/" + energyMax[2] + "(R), " + energyAmount[3] + "/" + energyMax[3] + "(S)");
        player.sendStatusMessage(component, false);
    }
    
    public boolean isFull(int type) {
    	switch (type) {
    	case 0:
    		if(energyAmount[0] == energyMax[0]) {
    			return true;
    		}
    		break;
    	case 1:
    		if(energyAmount[1] == energyMax[1])
    			return true;
    		break;
    	case 2:
    		if(energyAmount[2] == energyMax[2])
    			return true;
    		break;
    	case 3:
    		if(energyAmount[3] == energyMax[3])
    			return true;
    		break;
    		default:
    			return false;
    	}
    	return false;
    }
}
