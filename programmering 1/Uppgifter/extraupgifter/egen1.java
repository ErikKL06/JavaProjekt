package extraupgifter;

import java.util.Scanner;

public class egen1 {

	public static void main(String[] args) {
		//Scannerobjekt
		Scanner input = new Scanner(System.in);
		
		//Text stycke
		
		System.out.println("Skriv två tal ");
		
		//input
		double tal1 = input.nextDouble();
		double tal2 = input.nextDouble();
		
		
		if((tal1 + tal2) % 2 <= 0) {                //om resten av (tal1 + tal2)/2 är lika med 0
			System.out.println(" talet är jämt");
		}
		
		
		else {                                     //annars
			System.out.println(" det är udda");
		}

	}

}