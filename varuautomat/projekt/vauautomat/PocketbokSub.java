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
}
