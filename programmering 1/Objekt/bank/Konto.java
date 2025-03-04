package bank;

public class Konto {
	//Instansvariabler:
	private String namn;
	private int saldo;
	private int kontonr;
	
	//Statiska variabel
	private static int counter = 1;
	
	//Konstruktor:
	public Konto(String namn) {
		this.namn = namn;
		kontonr = 1000 + counter;
		counter++;
	}
	
	//insättning
	public void ins(int belopp) {
		saldo += belopp;
	}
	public boolean uttag(int belopp) {
		if(saldo >= belopp) {
			saldo -= belopp;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Get metoder
	public int getKontoNr() {
		return kontonr;
		
	}
	public int getSaldo() {
		return saldo;
		
	}
	public String getNamn() {
		return namn;
		
	}
}
