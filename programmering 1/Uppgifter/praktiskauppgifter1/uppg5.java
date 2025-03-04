package praktiskauppgifter1;

import java.util.Scanner;

public class uppg5 {

	public static void main(String[] args) {
		//Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("Skriv ett belopp i kr");
		
		int belopp = input.nextInt();
		
		//Beräkningar
		
		int tvåhundralappar = belopp/200;
		
		belopp = belopp % 200;   //resten av 200
		
		int hundralappar = belopp/100;
		
		belopp = belopp % 100;   //resten av 100
		
		int femtiolappar = belopp/50;
	
		belopp = belopp % 50;   //resten av 50
		
		int tjugolappar = belopp/20;
				
		belopp = belopp % 20;	//resten av 20	
				
		int femkronor = belopp/5;
				
		belopp = belopp % 5;   //resten av 5
				
		int enkronor = belopp/1;
		
		
		
		System.out.println(tvåhundralappar +"tvåhunddra " + hundralappar + "hundra " +  femtiolappar + "femtiolappar "  + tjugolappar +"tjugolappar "+ femkronor +"femkronor "+ enkronor);

	}

}
