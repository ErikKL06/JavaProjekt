package vauautomat;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class gui extends JFrame {

	private ArrayList<JButton> buttons = new ArrayList<>();
	JButton köp, avbryt;
	JTextArea varukorg;


	// Window dimensions
	private final int SIZEX = 500;
	private final int SIZEY = 500;

	// UI Components
	private JPanel startPanel;
	private Utrymme utrymmet; // Add this line

	// Modify constructor to accept Utrymme object
	public gui(Utrymme utrymmet) {
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
		if(load() == false){ //måste köra utanför opening windows eftersom annars kommer den inte hinna ladda in innan initcomponenets
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
		köp = new JButton("köp");
		köp.addActionListener(e -> {
			System.out.println("klickat på köp");
			JOptionPane.showMessageDialog(startPanel, "Du har köpt");
			save();
		});
		avbryt = new JButton("avbryt");
		avbryt.addActionListener(e -> {
			System.out.println("klickat avbryt");
			JOptionPane.showMessageDialog(startPanel, "Du har avbrutit");
			load();
			uppdateraGui();
		});

		for (AbsVaror vara : utrymmet.varor) {
			JButton btn = new JButton(vara.getSort()+": " + vara.getAntal());
			btn.addActionListener(e -> { //arrow funktion
				vara.reduceraAntal(); //callar funktionen som är ärvd av absvaror
				btn.setText(vara.getSort()+": " + vara.getAntal()); //updaterar gui
				varukorg.append(vara.getSort()+": " + vara.getAntal() + "\n"); //lägger till i textarea
				if(vara.getAntal() == 0){btn.setEnabled(false);} //sänger av knappen om den är tom

			});
			if(vara.getTyp().equals("Dricka")) {btn.setBackground(Color.yellow);}
			if(vara.getTyp().equals("Snack")) {btn.setBackground(Color.green);}
			if(vara.getTyp().equals("Pocketbok")) {btn.setBackground(Color.pink);}
			if(vara.getAntal() <= 0){btn.setEnabled(false);} //sänger av knappen om den är tom
			buttons.add(btn); // Save the buttons
		}
	}

	private void startView() {
		startPanel.setLayout(new GridLayout(4, 3));
		startPanel.add(varukorg);
		startPanel.add(köp);
		startPanel.add(avbryt);
		for (JButton btn : buttons) {
			startPanel.add(btn);
		}

		setContentPane(startPanel);
		validate();
	}

	private void save() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("objekt.txt")))) {
			out.writeObject(utrymmet.varor); // Save the utrymme object'
			out.close();
			out.flush();
			System.out.println("Data saved successfully.");
			System.out.println("filen ligger i: " + System.getProperty("user.dir"));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error: Failed to write to file");
		}
	}

	public boolean load() {
		try {

			ObjectInputStream infil = new ObjectInputStream(new FileInputStream(new File("objekt.txt")));

			utrymmet.varor = (ArrayList<AbsVaror>) infil.readObject();
			infil.close();
			System.out.println("laddar in objekt");
			return true;

		} catch(Exception e) {
			System.out.println("Filen finns ej");
			return false;

		}

	}
	private void uppdateraGui(){
		buttons.clear();
		startPanel.removeAll();
		initComponents();
		startView();
	}
}