package eyeroh.elementalmastery.machine.util;

public class Energy {
    private int opal;
    private int topaz;
    private int ruby;
    private int sapphire;

    public Energy (int opal, int topaz, int ruby, int sapphire) {
        this.opal = opal;
        this.topaz = topaz;
        this.ruby = ruby;
        this.sapphire = sapphire;
    }

    public Energy() {
        this.opal = 0;
        this.topaz = 0;
        this.ruby = 0;
        this.sapphire = 0;
    }

    public int getOpal() {
        return opal;
    }

    public int getTopaz() {
        return topaz;
    }

    public int getRuby() {
        return ruby;
    }

    public int getSapphire() {
        return sapphire;
    }

    public int get(EnergyType type) {
        switch (type) {
            case OPAL:
                return getOpal();
            case TOPAZ:
                return getTopaz();
            case RUBY:
                return getRuby();
            case SAPPHIRE:
                return getSapphire();
            default:
                return 0;
        }
    }

    public void setOpal(int opal) {
        this.opal = opal;
    }

    public void setTopaz(int topaz) {
        this.topaz = topaz;
    }

    public void setRuby(int ruby) {
        this.ruby = ruby;
    }

    public void setSapphire(int sapphire) {
        this.sapphire = sapphire;
    }

    public void set(EnergyType type, int amount) {
        switch (type) {
            case OPAL:
                setOpal(amount);
                break;
            case TOPAZ:
                setTopaz(amount);
                break;
            case RUBY:
                setRuby(amount);
                break;
            case SAPPHIRE:
                setSapphire(amount);
                break;
        }
    }

    public void addOpal(int opal) {
        this.opal += opal;
    }

    public void addTopaz(int topaz) {
        this.topaz += topaz;
    }

    public void addRuby(int ruby) {
        this.ruby += ruby;
    }

    public void addSapphire(int sapphire) {
        this.sapphire += sapphire;
    }

    public void addEnergy(EnergyType type, int amount) {
        switch (type) {
            case OPAL:
                addOpal(amount);
                break;
            case TOPAZ:
                addTopaz(amount);
                break;
            case RUBY:
                addRuby(amount);
                break;
            case SAPPHIRE:
                addSapphire(amount);
                break;
        }
    }

    public void add(Energy in) {
        addOpal(in.opal);
        addTopaz(in.topaz);
        addRuby(in.ruby);
        addSapphire(in.sapphire);
    }

    public void subOpal(int opal) {
        this.opal -= opal;
    }

    public void subTopaz(int topaz) {
        this.topaz -= topaz;
    }

    public void subRuby(int ruby) {
        this.ruby -= ruby;
    }

    public void subSapphire(int sapphire) {
        this.sapphire -= sapphire;
    }

    public void subEnergy(EnergyType type, int amount) {
        switch (type) {
            case OPAL:
                subOpal(amount);
                break;
            case TOPAZ:
                subTopaz(amount);
                break;
            case RUBY:
                subRuby(amount);
                break;
            case SAPPHIRE:
                subSapphire(amount);
                break;
        }
    }

    public void subtract(Energy in) {
        subOpal(in.opal);
        subTopaz(in.topaz);
        subRuby(in.ruby);
        subSapphire(in.sapphire);
    }

    @Override
    public String toString() {
        return String.format("{Opal = %s, Topaz = %s, Ruby = %s, Sapphire = %s}", opal, topaz, ruby, sapphire);
    }

    public int[] toIntArray() {
        return new int[] {opal, topaz, ruby, sapphire};
    }

    public static Energy fromIntArray(int[] energyArray) {
        if (energyArray.length != 4) {
            return new Energy();
        } else {
            return new Energy(energyArray[0], energyArray[1], energyArray[2], energyArray[3]);
        }
    }
}
