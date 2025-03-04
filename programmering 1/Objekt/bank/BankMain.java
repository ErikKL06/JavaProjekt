package bank;

import java.util.ArrayList;

public class BankMain {

	public static void main(String[] args) {
		//Samling
		ArrayList<Konto> kontoLista = new ArrayList<>();
		//andra typer av samlingar: HashMap,
		
		//lägga till objekt i listan
		kontoLista.add(new Konto("Erik Klener"));
		//ändrar i objekt:
		kontoLista.get(0).ins(2000000000);
		
		kontoLista.add(new Konto("Göra Lind"));
		
		System.out.println(kontoLista.get(0).getSaldo() + kontoLista.get(1).getKontoNr());
		
		//söker efter bankkonto:
		for(int i = 0; i < kontoLista.size(); i++) {
			if(kontoLista.get(i).getNamn().equals("Gösta Lind")) {
				System.out.println(kontoLista.get(i).getSaldo());
			}
		}
		

	}

}
