package paket;

public class Variabler1 {

	public static void main(String[] args) {
		// Primitiva dator typer
		
		//heltal:
		int heltal;                //skapar minnesallokering döpt till heltal
		
		heltal = 7;                   //tilldelar heltal värdet 7
		heltal = 23032;
		System.out.println(heltal);
		
		long stortTal = 244455666;       //för stora tal finns mer minne i long
		short litetTal = 34;            //för små tal finner mindre minne i short
		
		//decimaltal
		double decTal = 2.45;
		float decTal2 = 3.56f;          //float har något mindre minne, avsluter storlek med "f"
		
		//tecken
		char tecken = '@';             //"värdet" omsluts av ' '
		
		//boolsk variabel
		boolean val = true;          //En boolsk variabel kan endast ha värdena true eller false
		
		//text:
		String text1 = "Det här är text nummer ett!";
		
		System.out.println(text1);
		
		String text2 = "Här kommer text nummer två";
		
		//lägga ihop texterna till en:
		
		String totalText = text1 + " " + text2;  //lägger ihop flera texter till en med +
		
		System.out.println(totalText);
		
		//plackar ut tecken
		char bokstav1 = text1.charAt(0);
		
		System.out.println(bokstav1);
		
		//antal tecken
		int antalTecken = text1.length();
		
		System.out.println(antalTecken);
		
		//sista tecknet i texten
		char sistaTecken = text1.charAt(antalTecken -1);   //sista index är antal -1
		
		//dela upp mening i ord
		
		int blanksteg = text2.indexOf(' ');    //int blanksteg innehåller index för första blanksteg i texten
		
		String firstWord = text2.substring(0 , blanksteg); //plockar ut del av textsträng från 0 till blanksteg
		
		System.out.println(firstWord);
		

	}

}
