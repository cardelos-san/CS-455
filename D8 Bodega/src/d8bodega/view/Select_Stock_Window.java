package d8bodega.view;


import d8bodega.database.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Select_Stock_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Database db;

	public void run() {
		try {
			Select_Stock_Window frame = new Select_Stock_Window();
			frame.setVisible(true);
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Select_Stock_Window() {
		try {
			db = new Database();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEditSock = new JLabel("STOCK SEARCH ");
		lblEditSock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblEnterTheN = new JLabel("Enter the Name of the Stock To Edit");
		lblEnterTheN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String stockName = textField.getText();
			    try {
			    	Update_Stock_Window nextFrame = new Update_Stock_Window();
			    	nextFrame.run(stockName);
			    	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   dispose();
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
							.addGap(347)
							.addComponent(lblEditSock, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterTheN, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(263)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(404)
									.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnGoBack))
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblEditSock, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEnterTheN))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEnter))
					.addPreferredGap(ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
