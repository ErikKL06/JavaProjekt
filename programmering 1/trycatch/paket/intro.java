package paket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class intro {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ange ett heltal");
		
		try {
			int tal = input.nextInt();
		}catch(InputMismatchException | NumberFormatException e) {
			System.out.println("Det där var inget tal");
			e.printStackTrace(); //skriver ut felet

}
}
}