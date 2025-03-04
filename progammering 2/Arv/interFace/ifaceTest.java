package interFace;
	//för att använda ett interfacd/gränssnitt använder jag implements namnet
public class ifaceTest implements iface {

	@Override
	public void setText(String text) {
		//

	}

	public static void main(String[] args) {
		//skapar en instans av klassen
		
		
		iface ift = new ifaceTest();
		
		System.out.print(ift.getInfo() + " " +ift.word);  //med instansen av klassen kan jag använda defaults metoder samt variabler

	}

}
