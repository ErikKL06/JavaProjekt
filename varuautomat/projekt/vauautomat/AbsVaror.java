package vauautomat;

import java.io.Serializable;

public abstract class AbsVaror implements Serializable {
    // Klasser är ej för objekt utan för arv

    protected String typ;
    protected int pris;
    protected int moms;
    protected int antal;

    // konstruktor
    public AbsVaror(String typ, int pris, int moms, int antal) {
        this.typ = typ;
        this.pris = pris;
        this.moms = moms;
        this.antal = antal;
    }

    public abstract String getSort();
}
