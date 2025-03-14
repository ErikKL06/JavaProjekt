package vauautomat;

public class PocketbokSub extends AbsVaror {

    private String sort;

    // konstruktor
    public PocketbokSub(String sort) {
        super("Pocketbok", 50, 6, 5);
        this.sort = sort;
    }

    @Override
    public String getSort() {
        return sort;
    }


    @Override
    public String toStringWithoutAntal() {
        // Customize the string representation by excluding the `antal` property
        return this.getSort() + ", Price: " + this.pris + "kr, Moms: " + this.moms + "%"; // Replace with other properties
    }


}
