package praktiskauppgifter1;

import java.util.Scanner;

public class uppg4 {

	public static void main(String[] args) {
		//scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("skriv ditt namn och efternamn");
		
		//input
		
		char namn = input.next().charAt(0);
		char efternamn = input.next().charAt(0);
		
		System.out.print("dina initialer är " + namn + efternamn);
		
		
			
		

	}

}
