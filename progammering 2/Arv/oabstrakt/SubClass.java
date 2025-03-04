package oabstrakt;

public class SubClass extends superclass{
	
	public SubClass(String txt) {
		super(txt); //Använder konstruktor i superclassen
	}
	
	public void print() {
		System.out.println(text + getTxt()); //Vi kan använda privata variable endast indirekt via icke privata metoder
	}
}
