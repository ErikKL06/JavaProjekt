package unlupp12;

import java.util.Scanner;

public class Erik2 {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		
		int belopp;               //skapar minnesalokeringar till framtida texter och tal
		int tal1;        
		int tal2;
		int val2;
		String val;
		String trash;
		
		do {
			System.out.println("Hur mycket satsar du?");
			belopp = input.nextInt();
			System.out.println("1.Jämt\n2.Udda");        //för att skriva ut alternativen
			val2 = input.nextInt();                    //alternativ
			
			tal1 = (int) (Math.random() * 6) +1;
			tal2 = (int) (Math.random() * 6) +1;     //skapar ett random tal mellan 1 och 6
			
			switch(val2) {
			case 1:               //case ett händer om man tror att det är jämt
				System.out.println("tärning 1: "+ tal1);
				System.out.println("tärning 2: "+ tal2);
				
				if((tal1 + tal2)%2 == 0) {                     //förlorar om man gissar fel alltså om man gissar udda
					belopp = 2 * belopp;
					System.out.println("Jämt\n" + "Du vann " + "du vann " + belopp + "kr");
				}
				else {
					belopp = 0;
					System.out.println("Udda\n" + "Du förlorade");
				}
			break;                                        //så att bara ett alternativ körs
			case 2:				                         //case två händer om man tror att det är udda
				System.out.println("tärning 1: "+ tal1);
				System.out.println("tärning 2: "+ tal2);
				if((tal1 + tal2)%2 == 0) {     //förlorar om man gissar fel alltså om man gissar jämt
					belopp = 0;
					System.out.println("Jämt\n" + "Du förlorade");
				}
				else {
					belopp = 2 * belopp;
					System.out.println("Udda\n" + "Du vann " + "du vann " + belopp + "kr");
				}
			break;
			default:                     //om man inte skriver in något av alternativen
				System.out.println("Felaktig input, Vv och försök igen");
			}

			System.out.println("Vill du spela igen? ");
			trash = input.nextLine();                   //andvänds för att samla upp string skräp
			val = input.nextLine().toLowerCase();         //skapar input för val och gör det till lower case.
			
		}while(!val.equals("nej"));                 //equals är en metod att gemföra en string med en annan (i detta fallet det i parantesen)
		                                            //programmet körs tills val = "nej"
		
		System.out.println("spelet är avsutat");
		


	}

}

