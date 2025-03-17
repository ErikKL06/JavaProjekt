package vauautomat;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class gui extends JFrame {
    // Fönster storlek
    private final int SIZEX = 500;
    private final int SIZEY = 500;

    // UI komponeneter
    private JPanel startPanel;
    private Utrymme utrymmet;
    private HashMap<AbsVaror, Integer> varaHashMap = new HashMap<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JButton köp, avbryt;
    private JLabel erikAutomat;
    private JTextArea varukorg, varukorgPris;
    private JButton loadCSV;

    // gui accepterar utrymme
    public gui(Utrymme utrymmet) {
        this.utrymmet = utrymmet;
        ; // Assign the passed object
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
            utrymmet.skapaObjekt();
        }

        setSize(SIZEX, SIZEY); //sätter storlek

        startPanel = new JPanel();
        initComponents();
        startView();

        setVisible(true); // gör den synlig
    }

    private void initComponents() {
        erikAutomat = new JLabel("ERIKs AUTOMAT");
        erikAutomat.setHorizontalAlignment(SwingConstants.CENTER);
        erikAutomat.setOpaque(true); //gör så att man kan ändra bakrundsfärg på jlabel
        erikAutomat.setBackground(Color.white);
        erikAutomat.setFont(erikAutomat.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        varukorg = new JTextArea();
        varukorg.setEditable(false); //gör att man inte kan skriva in saker
        varukorgPris = new JTextArea();
        varukorgPris.setEditable(false);
        loadCSV = new JButton("Ladda in CSV");
        loadCSV.addActionListener(e -> {

            JOptionPane.showMessageDialog(startPanel, "CSV laddad");
            utrymmet.loadCSV();
            varaHashMap.clear();
            uppdateraGui();
        });  //gör laddar in csv filen och rensar varahashmappen och sen uppdaterar gui.
        köp = new JButton("köp");
        köp.addActionListener(e -> {
            JOptionPane.showMessageDialog(startPanel, "Du har köpt");
            try {
                utrymmet.save();
                utrymmet.saveKöpHistorik(varaHashMap);
                varaHashMap.clear();
                updateVarukorgDisplay();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(startPanel, "kunde inte spara");
            }
        }); //try ctch för att hämta fel
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


            }); // foreach loop som skapa alla knappar med en actionlistner

            //gör så att alla knappar med samma klass får samma bakgrundsfärg
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
        startPanel.add(erikAutomat);
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
    } //funktion för att uppdaterta gui

    private void handleVaraClick(AbsVaror vara) {
        if (varaHashMap.containsKey(vara)) {  //ökar antalet på en vara i hashmapen om objektet redan finns

            varaHashMap.put(vara, varaHashMap.get(vara) + 1);

        } else {
            //lägger till i hashmapen om det inte finns något av samma objekt
            varaHashMap.put(vara, 1);
        }
        updateVarukorgDisplay();
    } //funktion som lägger till varje objekt som hare clickat på med en i en hashmap

    // funktion för att updatera varukorgens display
    private void updateVarukorgDisplay() {
        StringBuilder varukorgContent = new StringBuilder();
        double totalPris = 0.0; // instanserar en variable för totalpriset

        for (AbsVaror vara : varaHashMap.keySet()) {
            int antal = varaHashMap.get(vara); // hämtar antalet av en vara i varukorgen
            double pris = vara.getPris(); // hämtar piset
            double itemTotalPris = pris * antal; // skriver in totala priset för varan

            varukorgContent.append(vara.getSort()) //lägger till allt i displaten
                    .append(" x ")
                    .append(antal);
            // Add the item total to the overall total
            totalPris += itemTotalPris;
        }
        // uppdaterar varukorgen
        varukorg.setText(varukorgContent.toString());
        // uppdaterar totalpris-varukorgen
        varukorgPris.setText("Total Pris: " + String.format("%.2f", totalPris) + " SEK");
    }

}


