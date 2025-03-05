package vauautomat;

public class DrickaSub extends AbsVaror{
	private String sort;
	
	//konstruktor
	public DrickaSub (String sort ,String typ, int pris, int moms){
		super("Dricka", 20, 6);
		this.sort = sort;
	}
	
	public String getSort() {
		return sort;
	}
	
	@Override
	public void print() {
		System.out.println(typ);
		
	}
	@Override
	public String toString() { 
		return "Sort: " + getSort() + "  Typ: " + typ + "  Pris: " + pris + "  Moms: " + moms;
	}
}
