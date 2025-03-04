package extraupgifter;

import java.util.Scanner;

public class miniräknarmeny {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("skriv ett tal");
		int tal = input.nextInt();
		int tal2;
		
		System.out.println("Välj räknesätt");
		System.out.println("1.+\n2.-\n3.*\n4./");
		int val = input.nextInt();
		
		switch(val) {
		case 1:
			System.out.println("Skriv ett andra tal");
			tal2 = input.nextInt();
			System.out.println(tal2 + tal);
			break;
		case 2:
			System.out.println("Skriv ett andra tal");
			tal2 = input.nextInt();
			System.out.println(tal2 - tal);
			break;
		case 3:
			System.out.println("Skriv ett andra tal");
			tal2 = input.nextInt();
			System.out.println(tal2 * tal);
			break;
		case 4:
			System.out.println("Skriv ett andra tal");
			tal2 = input.nextInt();
			System.out.println(tal2 / tal);
			
		}

	}

}
