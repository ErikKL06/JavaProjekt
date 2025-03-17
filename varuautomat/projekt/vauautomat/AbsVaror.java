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


    public void reduceraAntal() {
        antal--;
    }


    public String getTyp() {
        return typ;
    }

    public abstract String getSort();

    public int getPris() {
        return pris;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setAntal(Integer antal) {
        this.antal = antal;
    }

    public int getAntal() {
        return antal;
    }

    public String toStringWithoutAntal() {

        return ", Price: " + this.pris + "kr, Moms: " + this.moms + "%";
    }


}
