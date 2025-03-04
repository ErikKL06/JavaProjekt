package paket;

public class betyg {

	public static void main(String[] args) {
		//Sammanställning
		//Betygen kommer i en array, 0-5
		
		int[] betyg = {1,2,5,4,4,5,2,3,4,0,0,3,4,9,4,3,1,3};
		int fel = 0;
		//frekvens array
		int[] frekvens = new int[6];
		for(int i = 0; i < betyg.length; i++) {
			try {
				frekvens[betyg[i]]++;
			}catch(ArrayIndexOutOfBoundsException e) {
				fel++;
			}
		}
		for(int i = 0; i < frekvens.length; i++) {
			System.out.print("Betyg " + i + " förekommer " +frekvens[i] + " antal gånger med " +fel +" fel.\n");
		}
		
		

	}

}
