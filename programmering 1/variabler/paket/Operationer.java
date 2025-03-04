package paket;

import java.util.Scanner;

public class Operationer {

	public static void main(String[] args) {

		//Scannerobjekt
		Scanner input = new Scanner(System.in);
		//De fem räknesätten:
		
		System.out.println("Skriv två tal");
		
		int tal1 = input.nextInt();
		int tal2 = input.nextInt();
		
		//addition
		
		int summa = tal1 + tal2;
		
		
		//kortare
		System.out.println(tal1 + tal2);
		
		//subtraktion
		
		int diffrenes = tal1 - tal2;
		
		//muliplikation
		
		int produkt = tal1 * tal2;
		
		//division
		
		double kvot = tal1 *1.0 / tal2;  //för att få en kvot med decimaler krävs en ingående del med decimaler
		
		System.out.println("kvoten är " + kvot);
		
		//större uträkning
		
		double utr = (tal1 + tal2) *1.0 / (tal1 - tal2);  //paranteser som vanligt
		
		//modulberäkningar (resten vid division)
		
		int rest = tal1 % tal2;
		
		System.out.println("Resten vid division är:" + rest);
		
		
		//Tidsomvandling
		
		int sek = 276434;
		
		int min = sek / 60;  //min är hela antal minuter
		
		sek = sek % 60;    //sek är de sekunder som är kvar när hela minuter är borta
		
		int tim = min/60;  //hel antal timmar
		
		min = min % 60;   //min är de minuter som är kvar när hela timmar är borta
		
		System.out.println(tim + "h\t" + min +" min\t" +sek +" sek");   // \t = tabbar
		
		

	}

}
