package vauautomat;

public class Main {

	public static void main(String[] args) {

		Utrymme utrymme = new Utrymme();

		DrickaSub cola = new DrickaSub("Coca Cola");
		utrymme.addVara(cola);
		DrickaSub orange = new DrickaSub("Orange");
		utrymme.addVara(orange);
		DrickaSub lime = new DrickaSub("Lime");
		utrymme.addVara(lime);

		SnacksSub chips = new SnacksSub("Chips");
		utrymme.addVara(chips);
		SnacksSub nuts = new SnacksSub("Nuts");
		utrymme.addVara(nuts);
		SnacksSub Gum = new SnacksSub("Gum");
		utrymme.addVara(Gum);

		PocketbokSub SoT = new PocketbokSub("Sea of Tranquility");
		utrymme.addVara(SoT);
		PocketbokSub SE = new PocketbokSub("Station elven");
		utrymme.addVara(SE);
		PocketbokSub TGH = new PocketbokSub("The glass hotel");
		utrymme.addVara(TGH);

		utrymme.printVaror();

		new gui(utrymme);

	}

}
