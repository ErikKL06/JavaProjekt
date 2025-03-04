package inluppa3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;

public class inluppa3 extends JFrame {

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField mail;
	public ArrayList<Telefonkata> lista = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inluppa3 frame = new inluppa3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inluppa3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		
		JLabel lblNewLabel = new JLabel("Namn");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(159, 10, 73, 13);
		contentPane.add(lblNewLabel_1);
		
		namefield = new JTextField();
		namefield.setBounds(10, 25, 96, 19);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(159, 25, 96, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		
		
		
		Panel popup = new Panel();   //skapar panel som är osynlig
		popup.setBackground(new Color(255, 128, 0));
		popup.setBounds(56, 107, 161, 111);
		popup.setVisible(false);
		contentPane.add(popup);
		popup.setLayout(null);
		
		TextField changefield1 = new TextField();
		changefield1.setBounds(10, 10, 124, 21);
		popup.add(changefield1);
		
		TextField changefield2 = new TextField();
		changefield2.setBounds(10, 41, 124, 21);
		popup.add(changefield2);
		

		
		Button comfirm = new Button("Ändra");

		comfirm.setBounds(92, 80, 59, 21);
		popup.add(comfirm);
		
		Panel fel = new Panel();
		fel.setForeground(new Color(0, 0, 0));
		fel.setBackground(new Color(255, 0, 0));
		fel.setBounds(174, 88, 221, 136);
		contentPane.add(fel);
		fel.setLayout(null);
		fel.setVisible(false);
		
		Label felmed = new Label("Du saknar *@* eller *.*");
		felmed.setBounds(25, 40, 129, 21);
		fel.add(felmed);

		
		Button OK = new Button("OK");
		OK.setBounds(145, 105, 66, 21);
		fel.add(OK);
		
		JTextArea txtEmail = new JTextArea();  //lägger så att den kan bli synlig
		txtEmail.setEditable(false);
		txtEmail.setBounds(24, 67, 221, 186);
		contentPane.add(txtEmail);
		comfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String namn = namefield.getText();
				String email = mail.getText();
				
				String nyttnamn = changefield1.getText();
				String nyttemail = changefield2.getText();
				
				boolean snabelA = false;
				boolean punkt = false;
				
				for (int i = 0; i < email.length(); i++) {	
					if(nyttemail.charAt(i) == '@') {
						snabelA = true;
					}
					if(nyttemail.charAt(i) == '.') {
						punkt = true;
					}
				}
				
				if(snabelA == true && punkt == true) {
					for(int i = 0; i < lista.size(); i++) {  //for-sats till att byta ut namn och telnr med nytt
						if(lista.get(i).getName().equals(namn) && lista.get(i).getEmail().equals(email)) { //kollar om det är samma namn och telnr
							lista.remove(i);
							lista.add(new Telefonkata(nyttnamn, nyttemail));	
						}
					}
					txtEmail.setText(null);  
					for(int i = 0; i < lista.size(); i++) {  //appedar allt i textarean
						txtEmail.append(lista.get(i).getName() +" "+ lista.get(i).getEmail() + "\n");
					}
					popup.setVisible(false);   //tar bort popupet
					changefield1.setText(null); //sätter textfieldsen till null
					changefield2.setText(null);
					namefield.setText(null);
					mail.setText(null);
					
				}
				else {
					fel.setVisible(true);
			}
		}
			
		}
		
	);
		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fel.setVisible(false);
			}
		});

		

		JButton btnNewButton = new JButton("Skapa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namn = namefield.getText();  //kopplar variablen till textfield
				String email = mail.getText();
				boolean snabelA = false;
				boolean punkt = false;
				
				for (int i = 0; i < email.length(); i++) {	
					if(email.charAt(i) == '@') {
						snabelA = true;
					}
					if(email.charAt(i) == '.') {
						punkt = true;
					}
				}
				
				if(snabelA == true && punkt == true) {
					lista.add(new Telefonkata(namn, email)); //lägger till i arraylist
					
					txtEmail.setText(null); //Rensar textarean
					for(int i = 0; i < lista.size(); i++) {  //for sats till att lägga in alla namn och telfonnummer i textarean
						txtEmail.append(lista.get(i).getName() +"   "+ lista.get(i).getEmail() + "\n");
					}
				}	
				else {
					fel.setVisible(true);
				}
			}
			
		});
		btnNewButton.setBounds(321, 61, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ta bort");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namn = namefield.getText();
			
				for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getName().contains(namn)) { //ifall texten inehåller
						lista.remove(i);       //ta bort namnet i arraylisten
						
					}
				}
				txtEmail.setText(null);
				for(int i = 0; i < lista.size(); i++) {
					txtEmail.append(lista.get(i).getName() +"   "+ lista.get(i).getEmail() + "\n");
				}
			}
		});
		btnNewButton_1.setBounds(321, 90, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ändra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changefield1.setText(namefield.getText()); //så att det blir samma text som man sökte efter
				changefield2.setText(mail.getText());
				popup.setVisible(true);  //gör så att rutan blir synlig när man klickar ändra 
			}
		}
		);
		
		btnNewButton_2.setBounds(321, 121, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Visa alla");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtEmail.setText(null); //tar bort allt i textarean
				for(int i = 0; i < lista.size(); i++) { //lägger till alla namn i arraylisten i textarean
						txtEmail.append(lista.get(i).getName() +"   "+ lista.get(i).getEmail() + "\n");
					}
				}
			}
		);
		btnNewButton_3.setBounds(321, 152, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sök");
		btnNewButton_4.addActionListener(new ActionListener() { //söker efter ett namn och rensar tetarean och sen lägger till arraylisten i textarean
			public void actionPerformed(ActionEvent e) {
				String namn = namefield.getText();
				
				txtEmail.setText(null);
				
				for(int i = 0; i < lista.size(); i++) {
					if(lista.get(i).getName().contains(namn)) {
						txtEmail.append(lista.get(i).getName() +"   "+ lista.get(i).getEmail() + "\n");
					}
				}
			}
		});
		btnNewButton_4.setBounds(321, 183, 85, 21);
		contentPane.add(btnNewButton_4);
		


	}
}

