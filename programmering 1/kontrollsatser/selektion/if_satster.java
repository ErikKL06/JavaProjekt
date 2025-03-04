package selektion;

import java.util.Scanner;

public class if_satster {

	public static void main(String[] args) {
		//if satser styr av logiska uttryck så kallade "vilkor" ett villkor kan antingen vara sant eller falskt
		
		//variabler
		int helTal = 2;
		double tal = 2.5;
		char tecken = 'b';
		boolean val = true;
		
		//skriver ut en logisk utsaga
		System.out.println(helTal == 3);
		
		//if-satser som styrs av likhet
		if(helTal == 2) {
			System.out.println("heltal har värdet två");
			
		}
		else {       //om if-blocket ej körs så körs else-blocket
			System.out.println("Heltal har inte värdet två");
		}
		
		//decimaltal i ett intervall: -2 < x < 3  flera vilkor med "och" && eller "eller" || (altGr <)
		
		if(tal > -2 && tal < 3) {
			System.out.println("Decimaltalet ligger mellan -2 och 3");
		}
		else if(tal >= 3 && tal < 5) {
			System.out.println("talet ligger mellan tre och fem");
		}
		else {
			System.out.println("talet är större än fem (eller mindre än -2");
		}
		
		//tecknet ska inte vara ett k
		if(tecken != 'k') {                            // ! betyder icke
			System.out.println("tecknet är inte ett k");
		}
		
		
		//styra med boolskvariabel
		
		if(val) {
			//kodblocket körs om ej val blivit false
		}
		
		if(true) {
			//kodblocket körs alltid
		}
		
		//styra if-satser med metoder/funktioner
		
		String anv = "06kler@skola.engelholm.se";
		String lösn = "password";
		
		//inloggning:
		
		System.out.println("Ange andvändarnamn");
		//scannerobjekt
		Scanner input = new Scanner(System.in);
		String mail = input.nextLine();
		
		System.out.println("ange lösenord");
		String lösenord= input.nextLine();
		
		if(anv.equalsIgnoreCase(mail) && lösn.equals(lösenord)) {
			System.out.println("Välkomen " + mail);
		}
		else {
			System.out.println("Finns ej");
		}

	}
}
