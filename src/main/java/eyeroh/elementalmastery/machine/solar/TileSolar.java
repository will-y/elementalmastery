package eyeroh.elementalmastery.machine.solar;

import eyeroh.elementalmastery.machine.TileEnergyProvider;

public class TileSolar extends TileEnergyProvider {

    String name;

    public TileSolar(int type, String name) {
        super(type, 200);
        this.name = name;
    }

    public TileSolar() {
        super(-1, 200);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void tick() {
        if (world.isDaytime() && linked) {
            sendPower(energyPerSecond / 20);
        }
    }

//    @Override
//    public void readFromNBT(NBTTagCompound compound) {
//        super.readFromNBT(compound);
//        this.name = compound.getString("name");
//    }
//
//    @Override
//    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
//        super.writeToNBT(compound);
//        compound.setString("name", name);
//        return compound;
//    }
}
