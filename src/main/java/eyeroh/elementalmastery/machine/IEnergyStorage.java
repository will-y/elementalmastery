package eyeroh.elementalmastery.machine;

import eyeroh.elementalmastery.machine.util.Energy;
import eyeroh.elementalmastery.machine.util.EnergyType;

public interface IEnergyStorage {

    /**
     * Sends energy to the storage, any that cannot be stored is returned
     * @param type - the type of energy to send
     * @param amount - the amount of energy the storage needs to accept
     * @return - the amount of energy that cannot be stored
     */
    int sendEnergy(EnergyType type, int amount);

    /**
     * Adds an energy acceptor to the capacitor
     * @param in - the energy acceptor to add
     * @return - true if added
     */
    boolean addEnergyAcceptor(TileEnergyAcceptor in);

    /**
     * Removes an energy acceptor from the storage
     * @param in - energy acceptor to remove
     * @return - true if removed
     */
    boolean removeEnergyAcceptor(TileEnergyAcceptor in);

    /**
     * Gets all of the current energy stored
     * @return - Energy object of currently stored energy
     */
    Energy getCurrentEnergy();

    /**
     * Gets the max energy stored
     * @return - Energy object of max energy the storage can hold
     */
    Energy getMaxEnergy();

    void setMaxEnergy(Energy energy);

    /**
     * Gets the current energy of a specific type
     * @param type - the type to get
     * @return - the amount currently stored of that type
     */
    int getCurrentEnergy(EnergyType type);

    /**
     * Gets the max energy of a specific type
     * @param type - the type to get
     * @return - the max storage for that type
     */
    int getMaxEnergy(EnergyType type);

    void setMaxEnergy(EnergyType type, int amount);

    /**
     * Exports energy to all stored energy acceptors
     */
    void exportEnergy();
}
