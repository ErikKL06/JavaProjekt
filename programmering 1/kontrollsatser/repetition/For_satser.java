package repetition;

public class For_satser {

	public static void main(String[] args) {
		//For-satser lämpar sig för ett visst antal repititioner
		
		//for( start; slut; steg)
		
		for(int i = 0; i < 10; i++) {    //startar på 0 slutar på 9 och ökar ett steg var vända
			System.out.println(i);			
		}
		
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)Math.pow(2, i);  //fyller array med binära tal
		}
		
		//skriver ut arrays:
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// söka ett värde i array
		
		int index = -1;   //när söker vi index ger vi startvärde -1 för att se om värde ek funnits
		int value = 4;    //vi söker efter väre 4 arrayn
		
		for(int i = array.length -1; i >= 0; i--) { //bläddrar från sistal till förstsa index
			if(array[i] == value) {
				index = i;
				break;    //avbryter for satsen
			}
			
		}
		System.out.println("index for " +value +" is: " +index);
		
		
		//Chessboard
		//en forsats för rader, en för kolummer
		String[][] chess = new String[8][8];
		for(int k = 0; k < 8; k++) {
		for(int i = 0; i < 8; i++) {
			if(i % 2== 0) {
				chess[i][k]  = "[S]";
			}
			else {
				chess[i][k] = "[V]"; 
	
			}
		  }
		}
	 
		
		for(int k = 0; k < 8; k++) {
			for( int i = 0; i< 8; i++) {
				System.out.print(chess[i][k]);
			}
			System.out.println();
		}
		

	}

}

