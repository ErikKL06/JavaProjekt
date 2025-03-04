package intro;

import javax.swing.JFrame;

public class ObjektsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame window = new JFrame();
		//Klassnan egetnamn = new Konstruktor
		window.setVisible(true); //osynlig annars
		
		//Testar EgetObjekt;
		EgetObjekt e1 = new EgetObjekt("Gösta", true);
		
		EgetObjekt e2 = new EgetObjekt("Lisa Nordh", false);
		
		e1.newYear();
		
		System.out.println(e1.getKlass() + " " + e2.getKlass());
		

	}

}
