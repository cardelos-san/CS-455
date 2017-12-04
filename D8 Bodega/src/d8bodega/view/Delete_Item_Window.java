package d8bodega.view;


import d8bodega.database.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Delete_Item_Window extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textField;
	private Database db;
	private int itemID;

	public void run() {
		try {
			Delete_Item_Window frame = new Delete_Item_Window();
			frame.setVisible(true);
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Delete_Item_Window() {
		try {
			db = new Database();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEditSock = new JLabel("DELETE ITEM");
		lblEditSock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblEnterTheN = new JLabel("Enter the name of the item you wish to delete");
		lblEnterTheN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean itemExists = false;
				String itemName = textField.getText();

				try {
					itemID = db.getItemID(itemName);
					if(itemID != 0) {
						itemExists = true;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(itemExists) {
					
					try {
						db.deleteItem(itemName);
					} 
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Item has been deleted","DELETE ITEM",
							JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Item cannot be found","ITEM DOES NOT EXIST",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Select_Window goback = new Select_Window();
					goback.run();
					
				} catch (Exception ecp) {
					// TODO Auto-generated catch block
					ecp.printStackTrace();
				} 
			   dispose();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterTheN)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGoBack))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(lblEditSock, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(201))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblEditSock, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEnter)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(lblEnterTheN)))
					.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
