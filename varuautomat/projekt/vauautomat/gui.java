package vauautomat;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class gui extends JFrame {
    // Window dimensions
    private final int SIZEX = 500;
    private final int SIZEY = 500;

    // UI Components
    private JPanel startPanel;
    private Utrymme utrymmet; // Add this line
    private HashMap<AbsVaror, Integer> varaHashMap = new HashMap<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JButton köp, avbryt;
    private JTextArea varukorg, varukorgPris;
    private JButton loadCSV;

    // Modify constructor to accept Utrymme object
    public gui(Utrymme utrymmet) {
        this.utrymmet = utrymmet; // Assign the passed object
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör så att fönsteret stängs rätt
        // Window close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing window...");
            }
        });

        // Window open event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Opening window...");

            }


        });
        if (utrymmet.load() == false) { //måste köra utanför opening windows eftersom annars kommer den inte hinna ladda in innan initcomponenets
            utrymmet.createDefaultData();
        }

        setSize(SIZEX, SIZEY); // Window size

        startPanel = new JPanel();
        initComponents();
        startView();

        setVisible(true); // Set visible at the end
    }

    private void initComponents() {
        varukorg = new JTextArea();
        varukorg.setEditable(false);
        varukorgPris = new JTextArea();
        varukorgPris.setEditable(false);
        loadCSV = new JButton("Ladda in CSV");
        loadCSV.addActionListener(e -> {
            JOptionPane.showMessageDialog(startPanel, "CSV laddad");
            utrymmet.loadCSV();
            uppdateraGui();
        });
        köp = new JButton("köp");
        köp.addActionListener(e -> {
            System.out.println("klickat på köp");
            JOptionPane.showMessageDialog(startPanel, "Du har köpt");
            try {
                utrymmet.save();
                utrymmet.saveKöpHistorik(varaHashMap);
                varaHashMap.clear();
                updateVarukorgDisplay();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(startPanel, "kunde inte spara");
            }
        });
        avbryt = new JButton("avbryt");
        avbryt.addActionListener(e -> {
            System.out.println("klickat avbryt");
            JOptionPane.showMessageDialog(startPanel, "Du har avbrutit");
            utrymmet.load();
            varaHashMap.clear(); //rensar hashmap som sparar varor
            uppdateraGui();
        });

        //skapar varo-knapp och funktionen när man clicka på den
        for (AbsVaror vara : utrymmet.varor) {
            JButton btn = new JButton(vara.getSort() + ": " + vara.getAntal());
            btn.addActionListener(e -> { //arrow funktion för att minska antal
                vara.reduceraAntal(); //callar funktionen som är ärvd av absvaror
                btn.setText(vara.getSort() + ": " + vara.getAntal()); //updaterar knappguin
                handleVaraClick(vara);
                if (vara.getAntal() == 0) {
                    btn.setEnabled(false);
                } //sänger av knappen om den är tom


            });
            if (vara.getTyp().equals("Dricka")) {
                btn.setBackground(Color.yellow);
            } //ändra färg
            if (vara.getTyp().equals("Snack")) {
                btn.setBackground(Color.green);
            } //ändra färg
            if (vara.getTyp().equals("Pocketbok")) {
                btn.setBackground(Color.pink);
            } //ändra färg
            if (vara.getAntal() <= 0) {
                btn.setEnabled(false);
            } //sänger av knappen om den är tom
            buttons.add(btn); //lägger till knappen i knapp-arrayen
        }
    }

    private void startView() {
        startPanel.setLayout(new GridLayout(5, 3));
        startPanel.add(varukorg);
        startPanel.add(varukorgPris);
        startPanel.add(loadCSV);
        startPanel.add(köp);

        startPanel.add(avbryt);
        for (JButton btn : buttons) {
            startPanel.add(btn);
        }

        setContentPane(startPanel);
        validate();
    }


    private void uppdateraGui() {
        buttons.clear();
        startPanel.removeAll();
        initComponents();
        startView();
    }

    private void handleVaraClick(AbsVaror vara) {
        if (varaHashMap.containsKey(vara)) {
            // Increment the count for the vara
            varaHashMap.put(vara, varaHashMap.get(vara) + 1);

        } else {
            // Add the vara to the HashMap with a count of 1
            varaHashMap.put(vara, 1);
        }
        // Update varukorg display with the current contents of varaHashMap
        updateVarukorgDisplay();
        // Optional: Debug log
        System.out.println("Vara: " + vara.getSort() + " clicked " + varaHashMap.get(vara) + " times.");
        // Print to demonstrate the updated count (can be replaced with other logic like UI update)
    }

    // Update the JTextArea (varukorg) with the HashMap contents
    private void updateVarukorgDisplay() {
        StringBuilder varukorgContent = new StringBuilder();
        double totalPris = 0.0; // Initialize total price

        for (AbsVaror vara : varaHashMap.keySet()) {
            int antal = varaHashMap.get(vara); // Get the quantity of the item
            double pris = vara.getPris(); // Assume AbsVaror has a method getPris()
            double itemTotalPris = pris * antal; // Total price for this item

            // Append the vara details to the varukorg display
            varukorgContent.append(vara.getSort()) // Assume AbsVaror has a method getNamn()
                    .append(" x ")
                    .append(antal);
            // Add the item total to the overall total
            totalPris += itemTotalPris;
        }
        // Update the varukorg text area
        varukorg.setText(varukorgContent.toString());
        // Update the varukorgPris text area with the total price
        varukorgPris.setText("Total Pris: " + String.format("%.2f", totalPris) + " SEK");
    }

}


