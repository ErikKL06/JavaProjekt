package selektion;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("1.alternativ\n2. alternativ två\n3 alternativ tre\n4 hjälp");
		int val = input.nextInt();
		
		switch(val) {
		case 1:
			System.out.println("du valde alternativ 1");
		break;                                        //måste skriva break för att inte köra alla alternativ
		case 2:
			System.out.println("du valde alternativ 2");
		break;
		case 3:
			System.out.println("du valde alternativ 3");
		break;
		case 4:
			System.out.println("du valde alternativ 4");
			break;
		default:                                     //Ifall ingen av alternativen väljs
			System.out.println("felaktivt val svar, Vv försök igen");
			
		}
		String trash = input.nextLine();
		//En switch-case där alternativen styrs av text
		System.out.println("vilken dag är det idag");
		String dag = input.nextLine();
		switch(dag) {
		case "måndag":
			System.out.println("tisdag");
		case "tisdag":
			System.out.println("onsdag");
		case "onsdag":
			System.out.println("torsdag");
		case "torsdag":
			System.out.println("fredag");
		case "fredag":
			System.out.println("lördag");
		case "lördag":
			System.out.println("söndag");
			break;
		default:
			System.out.println("skriv dagen med gemener");
		}

	}

}
