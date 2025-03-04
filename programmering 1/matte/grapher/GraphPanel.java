package grapher;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		
		g.drawLine(20, 20, 20, 500);  //y-axeln
		g.drawLine(20, 500, 1000, 500);  //x-axeln
		
		g.setColor(Color.red);
		//for-sats för x-axelns värden
		for(int x = 20; x <= 1000; x++) {
			g.fillOval(x, (500-x)*(500-x), 3, 3);  //parabel
		}
		g.setColor(Color.blue);
		for(int x = 20; x <= 1000; x++) {
			g.fillOval(x, 500 - (int)(400*Math.abs(Math.sin(0.01 *(20-x)))), 5, 5);
		}
	}

}
