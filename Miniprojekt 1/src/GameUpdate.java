/**
 * GameUpdate
 * Klassen uppdaterar spelfigurernas läge
 * De olika metoderna anropas då en specifik tangent trycks ner.
 * 
 * Skriv koden för att få interaktivitet i spelet
 * 
 * @author Henrik Bygren
 * @since  2016-05-10
 * @see    GameUpdate
 *
 */
public class GameUpdate { // Koordinater för spelfigurerna
	
	static int greenX = 900, greenY = 200;
	static int greyX = 10, greyY = 200;
	/**
	 * Anropas då vänster piltangent trycks ner
	 */
	public void leftKey(){
		greenX -= 10;
	}
	
	/**
	 * Anropas då höger piltangent trycks ner
	 */
	public void rightKey(){
		greenX += 10;
	}
	
	/**
	 * Anropas då upp piltangent trycks ner
	 */
	public void upKey(){
		greenY -= 10;
	}
	
	/**
	 * Anropas då ner piltangent trycks ner
	 */
	public void downKey(){
		greenY += 10;
	}
	
	/**
	 * Anropas då A tangenten trycks ner
	 */
	public void aKey(){
		greyX -= 10;
	}
	
	/**
	 * Anropas då D tangenten trycks ner
	 */
	public void dKey(){
		greyX += 10;
	}
	
	/**
	 * Anropas då W tangenten trycks ner
	 */
	public void wKey(){
		greyY -= 10;
	}
	
	/**
	 * Anropas då S tangenten trycks ner
	 */
	public void sKey(){
		greyY += 10;
	}
	
	public static void game(){
		if (greyX + 120 >= 1024 - 120){
			greyX = 904;
		}		
		if (greyY + 34 >= 720- 34){
			greyY = 720 - 34;
		}
		if (greyX <= 0){
			greyX = 0;
		}
		if (greyY <= 0){
			greyY = 0;
		}
		if (greenX + 120 >= 1024){
			greenX = 784;
		}
		if (greenY + 34 >= 720 - 34){
			greenY = 720 - 34;
		}
		if (greenX <= 0){
			greenX = 0;
		}
		if (greenY <= 0){
			greenY = 0;
		}
		
		if (Math.abs(greenX - greyX) <= 120 && Math.abs(greenY - greyY) <= 34) {
			greenX = 1024;
			greyX = 0;
		}
	}
}
