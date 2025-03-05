package vauautomat;

public class DrickaSub extends AbsVaror{
	private String sort;
	
	//konstruktor
	public DrickaSub (String sort ,String typ, int pris, int moms){
		super("Dricka", 20, 6);
		this.sort = sort;
	}
	
	@Override
	public void print() {
		System.out.println(typ);
		
	}
}
