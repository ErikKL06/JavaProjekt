package uppgifterMetoder;

import java.util.Scanner;

public class pu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv förnamn");
		String forn = (input.nextLine());
		
		System.out.println("Skriv efternamn");
		String eftern = (input.nextLine());
		
		System.out.println("Skriv telefonnummer");
		String tel = (input.nextLine());
		
		
		System.out.println(tot(forn, eftern, tel));
	}
	public static String tot(String text1, String text2, String text3) {
		return text1 + text2 + text3;
	}

}
