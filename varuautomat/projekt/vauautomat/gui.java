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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame {

	private ArrayList<JButton> buttons = new ArrayList<>();

	// Window dimensions
	private final int SIZEX = 500;
	private final int SIZEY = 500;

	// UI Components
	private JPanel startPanel, instPanel;
	private Utrymme utrymmet; // Add this line

	// Modify constructor to accept Utrymme object
	public gui(Utrymme utrymmet) {
		this.utrymmet = utrymmet; // Assign the passed object
		// Window close event
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Closing window...");
				save(); // No need to pass utrymme here
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure app exits properly
		startPanel = new JPanel();
		initComponents();
		startView();

		setVisible(true); // Set visible at the end
	}

	private void initComponents() { //möjlig förbättreign: skippa att lägga btn i arraylist


		for (AbsVaror vara : utrymmet.varor) {
			JButton btn = new JButton(vara.getSort()+": " + vara.getAntal());
			btn.addActionListener(e -> { //arrow funktion
				vara.reduceraAntal(); //callar funktionen som är ärvd av absvaror
				btn.setText(vara.getSort()+": " + vara.getAntal()); //updaterar gui
				if(vara.getAntal() == 0){btn.setEnabled(false);} //sänger av knappen om den är tom

			});
			if(vara.getTyp().equals("Dricka")) {btn.setBackground(Color.yellow);}
			if(vara.getTyp().equals("Snacks")) {btn.setBackground(Color.LIGHT_GRAY);}
			if(vara.getTyp().equals("Pocketbok")) {btn.setBackground(Color.pink);}
			if(vara.getAntal() <= 0){btn.setEnabled(false);} //sänger av knappen om den är tom
			buttons.add(btn); // Save the buttons
		}

	}

	private void startView() {
		startPanel.setLayout(new GridLayout(3, 3));
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
}