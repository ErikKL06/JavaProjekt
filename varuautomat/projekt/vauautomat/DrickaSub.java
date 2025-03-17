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
}
