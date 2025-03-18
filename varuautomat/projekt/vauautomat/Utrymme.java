package vauautomat;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Utrymme {
    public static ArrayList<AbsVaror> varor = new ArrayList<>();

    private static void skapaObjekt() {
        DrickaSub cola = new DrickaSub("Cola");
        varor.add(cola);
        DrickaSub orange = new DrickaSub("Orange");
        varor.add(orange);
        DrickaSub lime = new DrickaSub("Lime");
        varor.add(lime);

        SnacksSub chips = new SnacksSub("Chips");
        varor.add(chips);
        SnacksSub nuts = new SnacksSub("Nötter");
        varor.add(nuts);
        SnacksSub gum = new SnacksSub("Gum");
        varor.add(gum);

        PocketbokSub SoT = new PocketbokSub("Sea of Tranquility");
        varor.add(SoT);
        PocketbokSub SE = new PocketbokSub("Station elven");
        varor.add(SE);
        PocketbokSub TGH = new PocketbokSub("The glass hotel");
        varor.add(TGH);
        System.out.println("skapat");
    } //funktion som skapar alla objekt

    public static void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("Refill_VM.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] kolum = line.split(";");
                for (int i = 0; i < kolum.length; i += 2) {
                    String sort = kolum[i].trim();
                    int nyAntal;
                    try {
                        nyAntal = Integer.parseInt(kolum[i + 1].trim()); //vara(i); antal(i+1)
                    } catch (NumberFormatException e) {
                        System.err.println("fel nummer: " + sort);
                        continue; //fortsätter till nästa vara även om det inte funkade på den
                    }

                    for (AbsVaror vara : varor) {
                        if (vara.getSort().equalsIgnoreCase(sort)) {
                            vara.antal = nyAntal;
                            break; //går ut ur for loopen om den hittar rätt sort
                        }
                    } //if sats som hittar rätt sort baserat på csv filen
                } //for loop som går igenom varje vara med typ.
            }
        } catch (IOException e) {
            System.err.println("Could not read CSV file: " + e.getMessage());
        }
    }


    public static void save() {
        //skapar objekt i array:en collection
        try {
            FileOutputStream fos = new FileOutputStream("objekt.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(varor); //skriver ut obejektet i filen
            oos.close();
            oos.flush();
            System.out.println("filen ligger i: " + System.getProperty("user.dir"));
        } catch (Exception e) {
            e.printStackTrace(); //skriver ut felmeddelande
        }
    }

    public static void load() {
        try {
            ObjectInputStream infil = new ObjectInputStream(new FileInputStream(new File("objekt.txt")));

            varor = (ArrayList<AbsVaror>) infil.readObject(); //sätter varor till det som finns i filen
            infil.close();
            System.out.println("laddar in objekt");

        } catch (Exception e) {
            System.out.println("Filen finns ej");
            skapaObjekt(); //skapar objekt om filen inte finns
        }
    }

    public static void saveKöpHistorik(HashMap<AbsVaror, Integer> köpHistorik) { //tillåter intag av hashmap
        LocalDateTime datumTid = LocalDateTime.now();
        DateTimeFormatter datumformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //sätter formatet på datumet

        String datum = datumTid.format(datumformat); //gör en string av datumTid i formatet datumformat

        try (FileOutputStream fos = new FileOutputStream("köpHistorik.txt", true)) {  //true för att annars bytar den ut all text i filen
            for (AbsVaror vara : köpHistorik.keySet()) {
                String line = "Vara: " + vara.getSort() + ", Typ: " + vara.typ + ", Pris: " + vara.pris + ", Moms: " + vara.moms + ", Antal: " + köpHistorik.get(vara) + ", Datum: " + datum + "\n";
                fos.write(line.getBytes()); //.getBytes gör om stringen till utf-8
            }
            System.out.println("KöpHistorik är sparat i: " + "köpHistorik.txt");
        } catch (IOException e) {
            System.err.println("kunde inte spara historik: " + e.getMessage());
        }
    }


}
