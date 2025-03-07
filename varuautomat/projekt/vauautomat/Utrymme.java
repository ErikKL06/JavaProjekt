package vauautomat;

import java.util.ArrayList;

public class Utrymme {
	
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
	public void printVaror() {  //möjligt förändrningsbar
		for (AbsVaror vara : varor) {
			System.out.println(vara.toString());
		}
	}
}
