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
    public ArrayList<AbsVaror> varor;

    public Utrymme() {
        varor = new ArrayList<AbsVaror>();
    }

    public void addVara(AbsVaror vara) {
        varor.add(vara);
    }

    public void createDefaultData() {
        DrickaSub cola = new DrickaSub("Coca Cola");
        addVara(cola);
        DrickaSub orange = new DrickaSub("Orange");
        addVara(orange);
        DrickaSub lime = new DrickaSub("Lime");
        addVara(lime);

        SnacksSub chips = new SnacksSub("Chips");
        addVara(chips);
        SnacksSub nuts = new SnacksSub("Nötter");
        addVara(nuts);
        SnacksSub gum = new SnacksSub("gum");
        addVara(gum);

        PocketbokSub SoT = new PocketbokSub("Sea of Tranquility");
        addVara(SoT);
        PocketbokSub SE = new PocketbokSub("Station elven");
        addVara(SE);
        PocketbokSub TGH = new PocketbokSub("The glass hotel");
        addVara(TGH);
        System.out.println("skapat");
    }

    public void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("varoFyllnadsform.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming CSV format: ItemName,Quantity
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String itemName = parts[0].trim();
                    int quantity;
                    try {
                        quantity = Integer.parseInt(parts[1].trim());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid quantity for item: " + itemName);
                        continue;
                    }

                    for (AbsVaror vara : varor) {
                        if (vara.getSort().equalsIgnoreCase(itemName)) {
                            vara.setAntal(quantity); // Assumes AbsVaror has setQuantity method
                            break;
                        }
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objekt.txt"))) {
            out.writeObject(varor); // Save the utrymme object
            System.out.println("Data saved successfully.");
            System.out.println("filen ligger i: " + System.getProperty("user.dir"));
        }

    }


    public boolean load() {
        try {
            ObjectInputStream infil = new ObjectInputStream(new FileInputStream(new File("objekt.txt")));

            varor = (ArrayList<AbsVaror>) infil.readObject();
            infil.close();
            System.out.println("laddar in objekt");
            return true;

        } catch (Exception e) {
            System.out.println("Filen finns ej");
            return false;

        }
    }
    public void saveKöpHistorik(HashMap<AbsVaror, Integer> köpHistorik) {
        LocalDateTime datumTid = LocalDateTime.now();
        DateTimeFormatter datumformat= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //sätter formatet på datumet

        String datum = datumTid.format(datumformat); //gör en string av datumTid i formatet datumformat

        try (FileOutputStream fos = new FileOutputStream("köpHistorik.txt", true)) {  //true för att annars bytar den ut all text i filen
            for (AbsVaror vara : köpHistorik.keySet()) {
                String line = "Vara: " + vara.toStringWithoutAntal() + ", Antal: " + köpHistorik.get(vara) + ", Datum: " + datum + "\n";
                fos.write(line.getBytes()); //.getBytes gör om stringen till utf-8
            }
            System.out.println("KöpHistorik är sparat i: " + "köpHistorik.txt");
        } catch (IOException e) {
            System.err.println("kunde inte spara historik: " + e.getMessage());
        }
    }



}
