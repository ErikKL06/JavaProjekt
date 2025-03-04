package intro;

public class EgetObjekt {
	//instansvariabler
	private String namn;
	private int klass;
	private int age;
	private boolean allergi;
	
	//konstruktor
	public EgetObjekt(String namn, boolean allergi) {
		this.namn = namn;
		klass = 1;
		age = 7;
		this.allergi = allergi;
	}
	
	//Set&Get Metoder
	public int getKlass() {
		return klass;
	}
	public String getNamn() {
		return namn;
	}
	public void newYear() {
		klass++;
		age++;
	}
}
