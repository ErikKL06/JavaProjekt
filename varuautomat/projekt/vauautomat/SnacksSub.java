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
    public String toStringWithoutAntal() {
        return this.getSort() + ", Price: " + this.pris + "kr, Moms: " + this.moms + "%";
    }


}
