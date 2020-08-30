package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.util.Energy;
import eyeroh.elementalmastery.machine.util.EnergyType;
import net.minecraft.util.math.BlockPos;

import java.io.Serializable;

public interface IEnergyAcceptor extends Serializable {

    Energy getEnergyPerTick();

    int sendEnergy(EnergyType type, int amount);

    Energy sendAllEnergy(Energy energy);

    Energy getEnergyStorage();

    int getEnergyStorage(EnergyType type);

    BlockPos getPos();
}
