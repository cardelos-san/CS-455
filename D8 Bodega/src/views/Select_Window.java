package views;

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
	public Select_Window() {
		
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
		
		JButton btnViewInventory = new JButton("VIEW INVENTORY");
		btnViewInventory.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				Inventory_Window view = new Inventory_Window();
				view.run();
				dispose();
			}
		});
		
		btnViewInventory.setBounds(141, 116, 144, 29);
		
		contentPane.add(btnViewInventory);
	
		
		JButton btnEditInventory = new JButton("EDIT INVERTORY");
		btnEditInventory.addActionListener(new ActionListener (){
  public void actionPerformed(ActionEvent e)
  {
	  Edit_Window edit = new Edit_Window();
		edit.start();
		dispose();
  }
  
	});

		btnEditInventory.setBounds(141, 157, 144, 29);
		contentPane.add(btnEditInventory);
	}

}
