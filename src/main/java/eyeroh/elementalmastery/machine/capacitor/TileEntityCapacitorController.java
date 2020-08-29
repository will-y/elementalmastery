package eyeroh.elementalmastery.machine.capacitor;

import java.util.ArrayList;
import java.util.Arrays;

import eyeroh.elementalmastery.machine.IEnergyAcceptor;
import eyeroh.elementalmastery.machine.IEnergyStorage;
import eyeroh.elementalmastery.machine.ModMachines;
import eyeroh.elementalmastery.machine.TileEnergyAcceptor;
import eyeroh.elementalmastery.machine.util.Energy;
import eyeroh.elementalmastery.machine.util.EnergyType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TileEntityCapacitorController extends TileEntity implements ITickable, IEnergyStorage {
	
	private Energy currentEnergy;
	private Energy maxEnergy;
	private CapacitorDirection capacitorDirection;
	private ArrayList<IEnergyAcceptor> machines = new ArrayList<>();
	int size;
	
	public TileEntityCapacitorController() {
		super(ModMachines.CAPACITOR_CONTROLLER_TILE.get());
	}
	
	public ArrayList<ITextComponent> getToolTipString(EnergyType type) {
		ArrayList<ITextComponent> list = new ArrayList<>();

		list.add(ITextComponent.func_244388_a(this.getCurrentEnergy(type) + "/" + this.getMaxEnergy(type)));
		return list;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int sendEnergy(EnergyType type, int amount) {
		return 0;
	}

	@Override
	public boolean addEnergyAcceptor(TileEnergyAcceptor in) {
		return false;
	}

	@Override
	public boolean removeEnergyAcceptor(TileEnergyAcceptor in) {
		return false;
	}

	@Override
	public Energy getCurrentEnergy() {
		return null;
	}

	@Override
	public Energy getMaxEnergy() {
		return null;
	}

	@Override
	public int getCurrentEnergy(EnergyType type) {
		return 0;
	}

	@Override
	public int getMaxEnergy(EnergyType type) {
		return 0;
	}

	@Override
	public void exportEnergy() {

	}

	@Override
	public void tick() {

	}

	/**
	 * Checks for a valid multiblock
	 * @param state - blockstate of the capcitor controller
	 * @param capacitorPosition - position of the capcitor controller
	 * @return the size of the capacitor, -1 if it failed
	 */
	public int checkAllMultiBlocks(BlockState state, BlockPos capacitorPosition, int maxSize) {
		for (int i = 1; i <= maxSize; i++) {
			if (checkMultiBlock(state, capacitorPosition, i) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Checks for a valid multiblock
	 * @param state - blockstate of the capcitor controller
	 * @param capacitorPosition - position of the capcitor controller
	 * @return error code, 0 if no error:
	 * 		-1: invalid capacitor block (in the center)
	 * 		-2: invalid capacitor wall
	 */
	public int checkMultiBlock(BlockState state, BlockPos capacitorPosition, int size) {
		BlockPos center = getCenterBlock(state, capacitorPosition, size);
		if (isCapacitor(getWorld().getBlockState(center).getBlock())) {
			for (int i = -size; i <= size; i++) {
				for (int j = -size; j <= size; j++) {
					for (int k = -size; k <= size; k++) {
						if (Math.abs(i) == size || Math.abs(j) == size || Math.abs(k) == size) {
							//System.out.println("WALL: " + i + ", " + j + ", " + k);
							// !wall and !center
							if (!isWall(getWorld().getBlockState(center.add(i, j, k)).getBlock()) && !(center.add(i, j, k).getX() == capacitorPosition.getX() && center.add(i, j, k).getY() == capacitorPosition.getY() && center.add(i, j, k).getZ() == capacitorPosition.getZ())) {
								return -2;
							}
						} else {
							//System.out.println("CAPACITOR: " + i + ", " + j + ", " + k);
							if (!isCapacitor(getWorld().getBlockState(center.add(i, j, k)).getBlock())) {
								return -1;
							}
						}
					}
				}
			}
		} else {
			System.out.println("Bad center");
			return -1;
		}
		return 0;
	}

	/**
	 * Gets the center block for the capacitor
	 * @param state - blockstate of the capacitor controller
	 * @param capacitorPosition - position of that capacitor controller
	 * @param size - size of the capacitor (1 = 3x3, 2 = 5x5, ...)
	 * @return - the position of the center block of the capacitor
	 */
	public BlockPos getCenterBlock(BlockState state, BlockPos capacitorPosition, int size) {
		if (size < 1) {
			throw new IllegalArgumentException("Size must be at least 1");
		}

		Direction direction = state.get(BlockCapacitorController.PROPERTY_FACING).getOpposite();

		return capacitorPosition.offset(direction, size);
	}

	private boolean isCapacitor(Block block) {
		return block.equals(ModMachines.CAPACITOR_MULTI.get()) || block.equals(ModMachines.CAPACITOR_OPAL.get()) || block.equals(ModMachines.CAPACITOR_TOPAZ.get()) || block.equals(ModMachines.CAPACITOR_RUBY.get()) || block.equals(ModMachines.CAPACITOR_SAPPHIRE.get());
	}

	private boolean isWall(Block block) {
		return block.equals(ModMachines.CAPACITOR_WALL.get()) || block.equals(ModMachines.CAPACITOR_GLASS.get());
	}
}
