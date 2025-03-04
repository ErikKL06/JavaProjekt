package uppg1;

import java.util.Scanner;

public class ErikK {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		
		int belopp;               //skapar minnesalokeringar till framtida texter och tal
		int tal1;        
		int tal2;               
		String val;
		String trash;
		
		do {
			System.out.println("Hur mycket satsar du?");
			belopp = input.nextInt();                
			
			tal1 = (int) (Math.random() * 6) +1;   //skapar ett random tal mellan 1 och 6
			tal2 = (int) (Math.random() * 6) +1;
			
			System.out.println("tärning 1: "+ tal1);
			System.out.println("tärning 2: "+ tal2);
			
			if (tal1 == 1 && tal2 == 6 || tal1 == 6 && tal2 == 1){        //ifall tal1=1 och tal2=6
				belopp = 3 * belopp;
				System.out.println("Dubbelvinst, " + belopp + " kr");
			}
			else if (tal1 + tal2 ==7) {
				belopp = 2 * belopp;
				System.out.println("Vinst, " + belopp + " kr");
			}
			else if (tal1 == tal2) {
				System.out.println("Par, " + belopp + " kr");
			}
			else {
				belopp = 0;       //ändrar beloppet till noll
				System.out.println("Förlust");
			}
			
			System.out.println("Vill du spela igen? ");
			trash = input.nextLine();                   //andvänds för att samla upp string skräp
			val = input.nextLine().toLowerCase();         //skapar input för val och gör det till lower case.
			
		}while(!val.equals("nej"));                 //equals är en metod att gemföra en string med en annan (i detta fallet det i parantesen)
		                                            //programmet körs tills val = "nej"
		
		System.out.println("spelet är avsutat");
		


	}

}
