package intro;

public class MetoderMain {

	public static void main(String[] args) {
		//metodtest
		int square = kvadrat(9);
		
		System.out.println(square);
		
		print("hej hej");
		
		System.out.println(tecken("hej", 2));
		
		//test av extern metod:
		char bokstav = tecken("Vadårå?", 3);
		if(ExternaMetoder.charTest(bokstav)) {
			print("Versal");
		}
		else {
			print("Gemen");
		}

	}
	//statisk funktion går att köra direkt
	//public/protected/private static retutyp namn(indata, indata)
	public static int kvadrat(int tal) {
		int square = tal * tal;
		return square;
	}
	
	//metod som returnerar ett tecken
	public static char tecken(String text, int index) {
		char retur = text.charAt(index);
		
		return retur;
	}
	//metod utan return
	//utrskift av text
	public static void print(String utskr) {
		System.out.println(utskr);
	}

}
