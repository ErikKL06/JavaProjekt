package inmatning;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		//skapar ett scannerObject
		
		Scanner input = new Scanner(System.in);  //Klassnamn egetnamn = new Klassnamn(indexnamn);		
		System.out.println("skriv ett tal");
		
		int tal = input.nextInt();    //inmatning för heltal
		
		System.out.println("Du skrev: " + tal);
		
		System.out.println("skriv ett decimaltal: ");
		
		double decTal = input.nextDouble(); 
		
		System.out.println("Du skrev " + decTal);
		
		char tecken = input.next().charAt(0); //char har ingen nextChar utan fär en omsändigare...
		

	}

}
