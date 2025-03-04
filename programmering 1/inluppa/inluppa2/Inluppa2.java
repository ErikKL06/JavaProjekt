package inluppa2;

import java.util.Scanner;

public class Inluppa2 {

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
		for(int i = 0; i < heltal; i++) {       //for-sats som fyller number-array med randomtal 
			number[i] = (char)(int)((Math.random() *(122 - 97)) + 97);   //castar math.random till int och sen int-en till char
			                                             //mellan tal (max - min) -min
		}
		return number;
	}
	public static int antal(char[] number) {
		int count = 0;                                //används som en räknare
		for(int i = 0; i < number.length; i++) {   
			if(number[i] == 'a') {              //kollar om platsen i innnehåller samma ASCII kod som lilla a
				count++;
			}
		}
		return count;
		
	}

}
