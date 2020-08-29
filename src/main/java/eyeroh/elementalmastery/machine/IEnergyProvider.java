package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.util.Energy;

public interface IEnergyProvider {

    Energy getEnergyPerTick();

    boolean setStorage(IEnergyStorage storage);

    boolean removeStorage(IEnergyStorage storage);

    void sendEnergy();
}
