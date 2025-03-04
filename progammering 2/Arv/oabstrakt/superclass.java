package oabstrakt;

public class superclass {
	//En superclass är en annan klass som klasser ärver
	protected int tal = 1;
	protected String text;
	private int a;
	private String txt = "secret";
	
	public superclass(String text) {
		this.text = text;
	}
	
	public int sum() {
		return tal + a;
	}
	
	public int getA() {
		return a;
	}
	
	public String getTxt() {
		return txt;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public void print() {
		System.out.println(text);
	}
}
