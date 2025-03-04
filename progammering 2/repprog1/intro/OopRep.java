package intro;

public class OopRep {
	
	int tal = 5; //double och float är decimal
	public OopRep() {
		//variabler

		String text = "Rektangel";
		int[] array = new int[6];
		
		//metodakll:
		testInst(text);
		
	}	
	
	//metod för att testa inst objekt
	private void testInst(String text) {
		Inst[] obj = new Inst[3];
		obj[0] = new Inst(text, 2.4, 4.2);
		System.out.print(obj[0].omkr()); //testar array, objekt samt metod
		
		//testar den andra konstruktorn
		obj[1] = new Inst("kvadrat", tal);
		//räknare for-sats
		try {
			for(int i = 0; i < obj.length; i ++) {
				System.out.println(obj[i].getShape());
			}
		}catch(NullPointerException e) {}
		
		//for-each
		try {
			for(Inst a : obj) {
				System.out.println(a.getShape());
			
			}
		}catch(Exception e) {};
	}
	
	public static void main(String[] args) {
		OopRep start = new OopRep();
	}

}



