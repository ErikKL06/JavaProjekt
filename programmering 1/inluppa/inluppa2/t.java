package inluppa2;

import java.util.Scanner;

public class t {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("skriv ett tal");
		int tal = input.nextInt();
		char[] array = rarray(tal);  //skapar en random array med hjälp av metoden
		
		System.out.println(array);
		
		System.out.println(antal(array));

	}
	public static char[] rarray(int heltal) {       
		char[] number= new char[heltal];
		for(int i = 0; i < heltal; i = i+2) {       //for-sats som fyller number-array med randomtal 
			number[i] = (char)(int)((Math.random() *(122 - 97)) + 97);   //castar math.random till int och sen int-en till char
			number[i+1] =(char)(int)((Math.random() *(90 - 65)) + 65); 
			                                             //mellan tal (max - min) -min
		}
		return number;
	}
	public static double antal(char[] number) {
		int count = 0;                                //används som en räknare
		for(int i = 0; i < number.length; i++) {   
			if(number[i] == 'a' || number[i] == 'A') {              //kollar om platsen i innnehåller samma ASCII kod som lilla a
				count++;
			}
		}
		double andel = (double)count/(double)number.length;
		
		return andel;
		
	}

}


