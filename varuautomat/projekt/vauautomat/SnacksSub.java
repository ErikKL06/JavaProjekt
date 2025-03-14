package vauautomat;

public class SnacksSub extends AbsVaror {
    private String sort;

    // konstruktor
    public SnacksSub(String sort) {
        super("Snack", 10, 12, 10);
        this.sort = sort;
    }

    @Override
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
        return this.getSort() + ", Price: " + this.pris + ", Moms: " + this.moms; // Replace with other properties
    }

    @Override
    public String toString() { // möjlig förändring kan anända system.out.println på alla sitället för att
        // ändra tostring
        return "Sort: " + getSort() + "  Typ: " + typ + "  Pris: " + pris + "  Moms: " + moms + "%" + " Antal: " + antal
                + "st";
    }
}
