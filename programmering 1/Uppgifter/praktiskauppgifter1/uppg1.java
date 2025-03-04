package praktiskauppgifter1;

import java.util.Scanner;

public class uppg1 {

	public static void main(String[] args) {
		//Scannerobjekt
		Scanner input = new Scanner(System.in);
		
		//inputs
		System.out.println("Skriv retangelns sidor");
		
		int längd = input.nextInt();
		int bredd = input.nextInt();  //
		 
		//uträkning
		
		int produkt = längd * bredd;
		
		//utskrift
		System.out.println("arean är: " + produkt + " a.e");

	}

}
