package uppgifterMetoder;

import java.util.Scanner;

public class pu1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int tal = inv(input.nextInt());
		System.out.println(tal);

	}
	public static int inv(int tal) {
		tal = -tal;
		
		return tal;
	}

}
