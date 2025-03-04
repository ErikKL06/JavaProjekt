package intro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class miniräknare extends JFrame {

	private JPanel contentPane;
	private JTextField txtIn1;
	private JTextField txtIn2;
	private JTextField txtUt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miniräknare frame = new miniräknare();
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
	public miniräknare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("term1");
		lblNewLabel.setBounds(31, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("term2");
		lblNewLabel_1.setBounds(141, 10, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("summa");
		lblNewLabel_2.setBounds(326, 10, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		txtIn1 = new JTextField();
		txtIn1.setBounds(10, 36, 96, 19);
		contentPane.add(txtIn1);
		txtIn1.setColumns(10);
		
		txtIn2 = new JTextField();
		txtIn2.setBounds(123, 36, 96, 19);
		contentPane.add(txtIn2);
		txtIn2.setColumns(10);
		
		txtUt = new JTextField();
		txtUt.setBounds(297, 36, 96, 19);
		contentPane.add(txtUt);
		txtUt.setColumns(10);
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtTerm1 = txtIn1.getText();
				String txtTerm2 = txtIn2.getText();
				
				double term1 = Double.valueOf(txtTerm1);
				double term2 = Double.valueOf(txtTerm2);
				
				double summa = term1 + term2;
				String txtsumma = Double.toString(summa);
				txtUt.setText(txtsumma);
			}
		});
		btnCalc.setBounds(307, 65, 85, 21);
		contentPane.add(btnCalc);
	}
}
