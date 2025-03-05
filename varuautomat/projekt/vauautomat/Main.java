package vauautomat;

public class Main {

	public static void main(String[] args) {
		
		Utrymme utrymme = new Utrymme();
		
		DrickaSub cola = new DrickaSub("Coca Cola", "Dricka", 20, 6);
		
		utrymme.addVara(cola);
		
		utrymme.printVaror();

	}

}
