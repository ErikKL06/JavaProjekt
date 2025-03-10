package vauautomat;

import java.util.ArrayList;

public class Utrymme {
	public ArrayList<AbsVaror> varor;

	public Utrymme() {
		varor = new ArrayList<AbsVaror>();
	}

	public void addVara(AbsVaror vara) {
		varor.add(vara);
	}
	public void createDefaultData() {
		DrickaSub cola = new DrickaSub("Coca Cola");
		addVara(cola);
		DrickaSub orange = new DrickaSub("Orange");
		addVara(orange);
		DrickaSub lime = new DrickaSub("Lime");
		addVara(lime);

		SnacksSub chips = new SnacksSub("Chips");
		addVara(chips);
		SnacksSub nuts = new SnacksSub("Nuts");
		addVara(nuts);
		SnacksSub Gum = new SnacksSub("Gum");
		addVara(Gum);

		PocketbokSub SoT = new PocketbokSub("Sea of Tranquility");
		addVara(SoT);
		PocketbokSub SE = new PocketbokSub("Station elven");
		addVara(SE);
		PocketbokSub TGH = new PocketbokSub("The glass hotel");
		addVara(TGH);
		System.out.println("skapat");
	}

	public void printVaror() { // möjligt förändrningsbar
		for (AbsVaror vara : varor) {
			System.out.println(vara.toString());
		}
	}

}
