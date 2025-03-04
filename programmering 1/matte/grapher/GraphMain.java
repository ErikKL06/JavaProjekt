package grapher;

import java.awt.Color;

import javax.swing.JFrame;

public class GraphMain extends JFrame {

	public static void main(String[] args) {
		//Instanserar klassen
		
		GraphMain graph = new GraphMain();
		
	}
	
	public GraphMain() {
		setVisible(true);
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphPanel panel = new GraphPanel();
		panel.setBackground(Color.white);
		setContentPane(panel);

		
	}

}
