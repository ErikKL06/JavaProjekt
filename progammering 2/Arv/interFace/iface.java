package interFace;

public interface iface {
	//Variabler kan endast vara static final för ett interface
	public static final String word = "ok";
	//metoder som behöver kompletteras/skrivas i klassen som ärver
	public void setText(String text);
	
	
	//metoder som är "färdiga" heter här default metoder
	
	public default String getInfo() {
		//här kan jag ha variabler som används inne denna metod
		
		int tal =2;
		
		String text = Integer.toString(tal) + word;
		return text;
	}
}
