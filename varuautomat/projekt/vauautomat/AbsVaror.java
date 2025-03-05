package vauautomat;

public abstract class AbsVaror {
	//Klasser är ej för objekt utan för arv
	
	protected String typ;
	protected int pris;
	protected int moms;

	
	//konstruktor
	public AbsVaror(String typ, int pris, int moms) {
		this.typ = typ;
		this.pris = pris;
		this.moms = moms;
	}
	public String getTyp() {
		return typ;
	}
	public int getPris() {
		return pris;
	}
	public int getMoms() {
		return moms;
	}
	
	//abstrakt metod, ej färdig , måste komppleteras i subclassen
	public abstract void print();
	
	@Override
	public String toString() { //möjligt förändrningsbar
		return "Typ: " + typ + " Pris: " + pris + " Moms: " + moms;
	}

	
}
