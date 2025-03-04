package praktiskauppgifter1;

import java.util.Scanner;

public class uppg2 {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//input för temp
		
		System.out.println("skriv en tempratur i farenhiet");
		
		double tempf = input.nextDouble();
		
		//converterng
		
		double tempc = (tempf - 32) * 0.56;
		
		//utskirft
		
		System.out.println("tempraturen i celsius är: " +tempc);

	}

}
