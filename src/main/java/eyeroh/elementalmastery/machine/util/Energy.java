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

    public void add(Energy in) {
        addOpal(in.opal);
        addTopaz(in.topaz);
        addRuby(in.ruby);
        addSapphire(in.sapphire);
    }

    @Override
    public String toString() {
        return String.format("{Opal = %s, Topaz = %s, Ruby = %s, Sapphire = %s}", opal, topaz, ruby, sapphire);
    }
}
