package vauautomat;

public class DrickaSub extends AbsVaror {
    private String sort;

    // konstruktor
    public DrickaSub(String sort) {
        super("Dricka", 20, 12, 10);
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    @Override
    public void print() {
        System.out.println(typ + getPris());

    }

    @Override
    public String toStringWithoutAntal() {
        // Customize the string representation by excluding the `antal` property
        return "Sort: " + this.getSort() + ", Price: " + this.pris + ", Moms: " + this.moms; // Replace with other properties
    }

    @Override
    public String toString() { // möjlig förändring kan anända system.out.println på alla sitället för att
        // ändra tostring
        return "Sort: " + getSort() + "  Typ: " + typ + "  Pris: " + pris + "  Moms: " + moms + " %" + " Antal: "
                + antal + "st";
    }
}
