package ownGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class guiFromScratch extends JFrame{
	//fönsterdimesioner
	private final int SIZEX = 400;
	private final int SIZEY = 400;
	//Instansvariabler, objekt i fönstrerna:
	JPanel startPanel, instPanel;
	JButton btnAlt1, btnAlt2, btnAlt3, btnSettings;
	JTextField txtIn; 
	
	public static void main(String[] args) {
		JFrame window = new guiFromScratch();  //skapar ett objekt av klassen


	}
	
	private guiFromScratch() {
		//funktion för när fönstret stängs
		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
				//kalla på sparmetod
				System.out.print("stänger");
			}
		});
		//funktion för när fönstret öppnas
		addWindowListener(new WindowAdapter() {
			public void WindowOpening(WindowEvent e) {
				//kalla på laddmetod
				System.out.print("öppnar");
			}
		});
		
		//Synligt fönster
		setVisible(true);
		setSize(SIZEX, SIZEY); //fönsterstorlek
		startPanel = new JPanel();
		initComponents();
		startView();
	}
	private void initComponents() {
		btnAlt1 = new JButton("Click me!");
		btnAlt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodkall för nästa vy
				
			}
			
		});
		btnAlt2 = new JButton("Open me");
		btnAlt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodkall för nästa vy
				
			}
			
		});
		btnAlt3 = new JButton("Alt 3");
		btnAlt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodkall för nästa vy
				
			}
			
		});
		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodkall för nästa vy
				settings();
			}
			
		});
		txtIn = new JTextField();
		
		
	}
	private void startView() {
		startPanel.setLayout(new GridLayout(2, 2));
		startPanel.add(btnAlt1);
		startPanel.add(btnAlt2);
		startPanel.add(btnAlt3);
		startPanel.add(btnSettings);
		//startPanel.setBackground(Color
		setContentPane(startPanel);
		validate();
	}
	
	private void settings() {
		getContentPane().removeAll();
		instPanel = new JPanel(new GridLayout(2,1));
		instPanel.add(txtIn);
		setContentPane(instPanel);
		validate();
		
	}

}
