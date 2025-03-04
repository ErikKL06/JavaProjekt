package praktiskauppgifter3;

public class uppg1 {

	public static void main(String[] args) {
		
		// A) while-satsen
		
		int tal;
		tal = 0;
		
		while(tal <= 5) {
			System.out.println(tal);
			tal++;
		}
		
		System.out.println();
		tal = 0;
		
		// B) do-while-satsen
		do {
			System.out.println(tal);
			tal++;
		}while(tal <= 5);
		
		
		System.out.println();
		
		// C) for-satsen
		for(int i = 0; i < 6; i++) {
		  System.out.println(i);	
		}

	}

}
