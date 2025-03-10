package vauautomat;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
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

	public gui() {
		// Window close event
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Closing window...");
				save();
			}
		});

		// Window open event
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Opening window...");
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
			// Save an actual object here instead of a class
			out.writeObject("utrymme");
			System.out.println("Data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error: Failed to write to file");
		}
	}
}
