package vauautomat;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.*;

public class gui extends JFrame {
    // Window dimensions
    private final int SIZEX = 500;
    private final int SIZEY = 500;

    // UI Components
    private JPanel startPanel;
    private Utrymme utrymmet; // Add this line
    private historikHanterarer historik;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JButton köp, avbryt;
    private JTextArea varukorg;
    private JButton loadCSV;

    // Modify constructor to accept Utrymme object
    public gui(Utrymme utrymmet, historikHanterarer historik) {
        this.utrymmet = utrymmet; // Assign the passed object
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
        utrymmet.printVaror();

        setSize(SIZEX, SIZEY); // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // gör så att fönsteret stängs rätt
        startPanel = new JPanel();
        initComponents();
        startView();

        setVisible(true); // Set visible at the end
    }

    private void initComponents() { //möjlig förbättreign: skippa att lägga btn i arraylist
        varukorg = new JTextArea();
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
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(startPanel, "kunde inte spara");
            }
        });
        avbryt = new JButton("avbryt");
        avbryt.addActionListener(e -> {
            System.out.println("klickat avbryt");
            JOptionPane.showMessageDialog(startPanel, "Du har avbrutit");
            utrymmet.load();
            uppdateraGui();
        });

        for (AbsVaror vara : utrymmet.varor) {
            JButton btn = new JButton(vara.getSort() + ": " + vara.getAntal());
            btn.addActionListener(e -> { //arrow funktion för att minska antal
                vara.reduceraAntal(); //callar funktionen som är ärvd av absvaror
                btn.setText(vara.getSort() + ": " + vara.getAntal()); //updaterar knappguin
                varukorg.append(vara.getSort() + ": " + 1 + "\n"); //lägger till i textarea
                historik.addItem(vara);
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
        startPanel.setLayout(new GridLayout(4, 3));
        startPanel.add(loadCSV);
        startPanel.add(varukorg);
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
}