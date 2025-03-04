package abstrakt;

public class AbsSub extends AbsSuper{

	public AbsSub(int tal, String text) {
		super(tal, text);
		// TODO Auto-generated constructor stub
	}

	//Kompletterar den abstrakta metoden print
	@Override
	public void print() {
		System.out.println(text);
		
	}

}
