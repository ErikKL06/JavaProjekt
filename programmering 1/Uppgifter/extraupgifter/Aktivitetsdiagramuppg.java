package extraupgifter;

import java.util.Scanner;

public class Aktivitetsdiagramuppg {

	public static void main(String[] args) {
		//Scanner
		
     Scanner input = new Scanner(System.in);
     
      int tal =(int)(Math.random()* 10);   //skapar ett slumpmässigt tal
      int talg;
	  System.out.println("Gissa ett tal mellan 0 - 9");
      
      do {
    	  talg = input.nextInt();
    	  if(talg > tal) {
    		  System.out.println("Gissa lägre");
    	  }
    	  else if(talg < tal) {
    		  System.out.println("gissa högre");
    	  }
    	  else {
    		  System.out.println("Grattis!");
    	  }
      }while (tal != talg);   //Avslutar loopen när talen är lika med varandra
      

	}

}
