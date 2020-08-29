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
}
