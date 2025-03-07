package vauautomat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileManagement {
	//instansvariabler
	File file;
	varorSpar[] collection; //Skapar en array för objekt av klassen varorSpar
	
	public static void main(String[] args) {
		//Skapar en instans av klassen
		FileManagement start = new FileManagement();
	}
	//konstruktor
	public FileManagement() {
		createFile("textfil.txt");
		writeToFile("Det här är en klassificerad fil");
		saveObjects();
	}
	//metod för att skapa en fil
	private void createFile(String object) {
		try {
			file = new File(object);
			System.out.println("filen skapad: " + file.getAbsolutePath());
		}catch( Exception e) {
			e.printStackTrace();
			System.out.println("gick ej skapa fil");
		}
		
		
	}
	//metod för att skriva text till fil
	private void writeToFile(String data) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Writer w = new BufferedWriter(osw);
			w.write(data);
			w.close();
			
		}catch(Exception e) {}
		
	}
	//Metod för att spara objekt
	private void saveObjects() {
		//skapar objekt i array:en collection
		collection = new varorSpar[5];
		for(varorSpar a : collection) {
			a = new varorSpar();
		}
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(collection);
			oos.close();
			oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void loadObjects() {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			collection = (varorSpar[])ois.readObject();  //casta som rätt sorts object
			ois.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
