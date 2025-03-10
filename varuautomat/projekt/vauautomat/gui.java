package vauautomat;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame {

	// Window dimensions
	private final int SIZEX = 400;
	private final int SIZEY = 400;

	// UI Components
	private JPanel startPanel, instPanel;
	private JButton btnAlt1, btnAlt2, btnAlt3, btnSettings;
	private JTextField txtIn;
	private Utrymme utrymme; // Add this line

	// Modify constructor to accept Utrymme object
	public gui(Utrymme utrymme) {
		this.utrymme = utrymme; // Assign the passed object
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
				load();
			}
		});

		setSize(SIZEX, SIZEY); // Window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure app exits properly
		startPanel = new JPanel();

		initComponents();
		startView();

		setVisible(true); // Set visible at the end
	}

	private void initComponents() {
		btnAlt1 = new JButton("Click me!");
		btnAlt1.addActionListener(e -> System.out.println("Button 1 clicked"));

		btnAlt2 = new JButton("Open me");
		btnAlt2.addActionListener(e -> System.out.println("Button 2 clicked"));

		btnAlt3 = new JButton("Alt 3");
		btnAlt3.addActionListener(e -> System.out.println("Button 3 clicked"));

		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(e -> settings());

		txtIn = new JTextField();
	}

	private void startView() {
		startPanel.setLayout(new GridLayout(2, 2));
		startPanel.add(btnAlt1);
		startPanel.add(btnAlt2);
		startPanel.add(btnAlt3);
		startPanel.add(btnSettings);

		setContentPane(startPanel);
		validate();
	}

	private void settings() {
		getContentPane().removeAll();
		instPanel = new JPanel(new GridLayout(2, 1));
		instPanel.add(txtIn);

		setContentPane(instPanel);
		validate();
		repaint();
	}

	private void save() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objekt.dat"))) {
			out.writeObject(utrymme); // Save the utrymme object
			System.out.println("Data saved successfully.");
			System.out.println("filen ligger i: " + System.getProperty("user.dir"));
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error: Failed to write to file");
		}
	}

	private void load() {
		try {

			ObjectInputStream infil = new ObjectInputStream(new FileInputStream("objekt.dat"));
			utrymme = (Utrymme) infil.readObject();
			infil.close();
			System.out.println("laddar in objekt");

		} catch (ClassNotFoundException | IOException ex2) {
			ex2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Failed to read file");
		}

	}
}