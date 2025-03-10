package vauautomat;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class varorSpar {
	
	public void save(WindowEvent e) {
		try {

ObjectOutputStream utfil = new ObjectOutputStream (
		new FileOutputStream("filnamn.dat")); 
utfil.writeObject("Arraylistnamn");
utfil.close();
utfil.flush();


             } catch(IOException e ) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: Failed to write to file");
            }


	}
});

}

}
