package inluppa3;

public class Telefonkata {
	String namn;
	String email;
	
		public Telefonkata(String txtNamn, String txtEmail) {
			this.namn = txtNamn;
			this.email = txtEmail;
		}
		
		public String getName() {
			return namn;
		}
		public String getEmail() {
			return email;
		}

}

