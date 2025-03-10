package vauautomat;

import java.io.Serializable;

public class DrickaSub extends AbsVaror implements Serializable {
	private static final long serialVersionUID = 1L; // Ensure compatibility when saving/loading
	private String sort;

	// konstruktor
	public DrickaSub(String sort) {
		super("Dricka", 20, 12, 10);
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
	public String toString() { // möjlig förändring kan anända system.out.println på alla sitället för att
								// ändra tostring
		return "Sort: " + getSort() + "  Typ: " + typ + "  Pris: " + pris + "  Moms: " + moms + " %" + " Antal: "
				+ antal + "st";
	}
}
