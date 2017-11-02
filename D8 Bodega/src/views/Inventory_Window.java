package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					Inventory_Window frame = new Inventory_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public Inventory_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		JTextPane txtpnThisIsWhats = new JTextPane();
		txtpnThisIsWhats.setForeground(Color.RED);
		txtpnThisIsWhats.setEnabled(false);
		txtpnThisIsWhats.setText("THIS IS WHATS IN THE INVENTORY");
		txtpnThisIsWhats.setBounds(117, 6, 221, 41);
		contentPane.add(txtpnThisIsWhats);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Select_Window goBack = new Select_Window();
				    goBack.run();
				    dispose();
				
			}
		});
		btnGoBack.setForeground(Color.GREEN);
		btnGoBack.setBounds(6, 229, 117, 29);
		contentPane.add(btnGoBack);
		
		JButton btnPrintInventory = new JButton("PRINT INVENTORY");
		btnPrintInventory.setBounds(163, 229, 145, 29);
		contentPane.add(btnPrintInventory);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(333, 229, 117, 29);
		contentPane.add(btnExit);
	
	}
}
	

