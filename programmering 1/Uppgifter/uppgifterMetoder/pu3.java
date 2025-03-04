package uppgifterMetoder;

import java.util.Scanner;

public class pu3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int tal = input.nextInt();
		int ptal = input.nextInt();
		
		System.out.println(power(tal, ptal));

	}
	public static int power(int tal1, int ptal) {
		int n = tal1;
		
		for (int i = ptal; i > 1; i--) {
			n = n * tal1;
		}
		return n;
	}

}
