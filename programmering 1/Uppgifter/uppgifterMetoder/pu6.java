package uppgifterMetoder;

import java.util.Scanner;

public class pu6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("skriv ett tecken");
		
		 char teck = input.next().charAt(0);
		
		System.out.println(test(teck));
		
	}
	public static boolean test(char tecken) {
		boolean tes;
		if(tecken >= '0' && tecken <= '9') {
			tes = true;
		}
		else {
			tes = false;
		}
		return tes;
	}

}
