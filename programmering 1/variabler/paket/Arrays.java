package paket;

public class Arrays {

	public static void main(String[] args) {
		// Arrays, listor, talfält
		int[] tal = new int[10];
		
		System.out.println(tal);  // en array behöver skriva ur element för element
		
		System.out.println(tal[0]);  //index 0 är första position i fältet
		
		System.out.println(tal[tal.length -1]);  //.lenght retunerar antal element i fältet
		
		tal[3] = 5;  //tal nr fyra i fältet får värde 5
		
		double[] decArray = new double[100];
		
		String[] textList = new String[23];
		
		// tvådimensionell array:
		
		char[][] twoDimField = new char[3][4]; //ett tvådim tecken fält eller matris
		

	}

}
