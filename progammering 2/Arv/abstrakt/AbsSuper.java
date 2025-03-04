package abstrakt;

public abstract class AbsSuper {
	//Klasser är ej för objekt utan för arv
	
	protected int tal;
	protected String text;
	
	//konstruktor
	public AbsSuper(int tal, String text) {
		this.tal = tal;
		this.text = text;
	}
	
	//abstrakt metod, ej färdig , måste komppleteras i subclassen
	public abstract void print();
	
}
