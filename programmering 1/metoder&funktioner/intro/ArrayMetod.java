package intro;

public class ArrayMetod {

	public static void main(String[] args) {
		//teckenArray
		char[] tecken = {'a', 'g', 'h', '6', 'p', 'B'};
		
		int[] kod = arrayOmv(tecken);
		
		//Annan typ av forsats (variabeltyp o namn i saml : saml) 
		for(int a : kod) {
			System.out.println(a);
		}

	}
	//metoden tar emot tecken-array och returnerar teckenas unicodevärden i en int-array
	public static int[] arrayOmv(char[] tecken) {
		int antal = tecken.length; //antal position i retur-array:en
		
		int[] kod = new int[antal]; //array som ska returneras
		
		for(int i = 0; i < antal ; i++) {
			kod[i] = (int) tecken[i];      //castar unicode värde som heltal
		}
		return kod;
	}

}
