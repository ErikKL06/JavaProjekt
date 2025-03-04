package praktiskauppgifter3;

import java.util.Scanner;

public class uppg4 {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		double tal;
		boolean val;
		char val1;
		
		do {
			tal = input.nextDouble();
			System.out.println("Vill du avsluta? j/n" );
			val1 = input.next().charAt(0);

			
			if(val1 == 'j') {
				val = false;
			}
		}while(val = false);

		

	}

}
