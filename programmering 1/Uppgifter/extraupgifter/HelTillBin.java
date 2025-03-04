package extraupgifter;

import java.util.Scanner;

public class HelTillBin {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("Skriv ett tal");
		
		int heltal = input.nextInt();
		int bintal[] = new int[10];
		
		for (int i = 0; i < bintal.length; i++) {
			bintal[i] = heltal % 2;
			heltal = heltal / 2;
		}
		System.out.println("talet är:");
		
		for (int i = bintal.length - 1; i >= 0; i--) {
			System.out.println(bintal[i]);
		}
		

		
		
		
		

	}

}
