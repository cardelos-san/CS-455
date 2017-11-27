package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Select_Window frame = new Select_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	


	/**
	 * Create the frame.
	 */
	public Select_Window() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);
		setTitle("8 Brothers SuperMaket"); 
		JTextPane txtpnHello = new JTextPane();
		txtpnHello.setBackground(Color.CYAN);
		txtpnHello.setEditable(false);
		txtpnHello.setText("WHAT WOULD YOU LIKE TO DO ?");
		txtpnHello.setBounds(100, 59, 220, 16);
		contentPane.add(txtpnHello);
		
		JButton btnViewInventory = new JButton("VIEW STOCK");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock_Window view;
				try {
					view = new Stock_Window();
					view.run();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		btnViewInventory.setBounds(141, 116, 144, 29);
		contentPane.add(btnViewInventory);
		
		JButton btnEditInventory = new JButton("EDIT INVENTORY");
		btnEditInventory.addActionListener(new ActionListener (){
		  public void actionPerformed(ActionEvent e){
			  Edit_Window edit = new Edit_Window();
				edit.start();
				dispose();
		  }
		  
			});

		btnEditInventory.setBounds(141, 157, 144, 29);
		contentPane.add(btnEditInventory);
	}

}
