package vauautomat;

import java.io.Serializable;
import java.util.ArrayList;

public class Utrymme implements Serializable {

	private static final long serialVersionUID = 1L; // Ensure compatibility when saving/loading
	private ArrayList<AbsVaror> varor;

	public Utrymme() {
		varor = new ArrayList<AbsVaror>();
	}

	public void addVara(AbsVaror vara) {
		varor.add(vara);
	}

	public String getVaror() {
		return varor.toString();
	}

	public void printVaror() { // möjligt förändrningsbar
		for (AbsVaror vara : varor) {
			System.out.println(vara.toString());
		}
	}
}
