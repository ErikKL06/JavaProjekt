package oabstrakt;

public class StartArv {

	public static void main(String[] args) {
		//Skapar instanser av klasserna
		superclass sc = new superclass("Super");
		
		SubClass subC = new SubClass("Sub");
		
		superclass subC2 = new SubClass2("Sub2");
		
		//SuerCLassArray
		superclass[] array = new superclass[3];
		
		array[0] = sc;
		array[1] = subC;
		array[2] = subC2;
		
		for(int i = 0; i < array.length; i++) {
			array[i].print();
		}
		
		

	}

}
