package extraupgifter;

import java.util.Scanner;

public class HelTillHexa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int tal = input.nextInt();
		char[] hexa = new char[10];
		
		for (int i = 0; i <= hexa.length; i++) {
			hexa[i] = (char) (tal % 6);
			tal = tal / 2;
		}
		

	}

}
