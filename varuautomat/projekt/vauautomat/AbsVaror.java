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
	public void reduceraAntal(){
		antal--;
	}
	public void ökaAntal(){
		antal++;
	}

	public String getTyp() {
		return typ;
	}
	public abstract String getSort();

	public int getPris() {
		return pris;
	}

	public int getMoms() {
		return moms;
	}

	public int getAntal() {
		return antal;
	}

	// abstrakt metod, ej färdig , måste komppleteras i subclassen
	public abstract void print();

	@Override
	public String toString() { // möjligt förändrningsbar
		return "Typ: " + typ + " Pris: " + pris + " Moms: " + moms;
	}

}
