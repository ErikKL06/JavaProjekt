package intro;

public class Inst {

		//instansvariabler
		private double l;
		private double w;
		private String shape;
		
		//konstruktor
		public Inst(String shape, double l, double w) {
			this.shape = shape;
			this.l = l;
			this.w = w;
		}
		//konstruktur för kvadrat
		public Inst(String shape, double s) {
			this.shape = shape;
		}
		
		//beräkningsmetoder
		public double omkr() {
			return 2*l + 2*w;
		}
		public double area () {
			return w*l;
		}
		
		//set&get-metoder
		public void setShape(String shape) {
			this.shape = shape;
		}
		public String getShape() {
			return shape;
		}
}
