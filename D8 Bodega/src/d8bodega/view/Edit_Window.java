package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 
			public void run() {
				try {
					Edit_Window frame = new Edit_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	

	/**
	 * Create the frame.
	 */
	public Edit_Window() {
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWhatWouldYou = new JLabel("What Would You Like To Update");
		lblWhatWouldYou.setBackground(new Color(0, 0, 0));
		lblWhatWouldYou.setForeground(new Color(0, 0, 0));
		lblWhatWouldYou.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWhatWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatWouldYou.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnDailySale = new JButton("DAILY SALE");
		btnDailySale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Daily_Sales_Window nextFrame = new Daily_Sales_Window();
					nextFrame.run();
					
				} catch (Exception ecp) {
					// TODO Auto-generated catch block
					ecp.printStackTrace();
				} 
			   dispose();
			}
		});
		btnDailySale.setForeground(new Color(0, 0, 0));
		btnDailySale.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("UPDATE STOCK");
		btnNewButton.setBackground(new Color(245, 245, 245));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						Select_Stock_Window nextFrame = new Select_Stock_Window();
						nextFrame.run();
						
					} catch (Exception ecp) {
						// TODO Auto-generated catch block
						ecp.printStackTrace();
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
		
		JButton btnNewButton_1 = new JButton("ADD ITEM");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add_Item_Window goback = new Add_Item_Window();
					goback.run();
					
				} catch (Exception ecp) {
					// TODO Auto-generated catch block
					ecp.printStackTrace();
				} 
			   dispose();
		}
			
		});
		
		JButton btnDeleteItem = new JButton("DELETE ITEM");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete_Item_Window nextFrame = new Delete_Item_Window();
				nextFrame.run();
				dispose();
			}
		});
		btnDeleteItem.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnGoBack)
					.addContainerGap(322, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(308, Short.MAX_VALUE)
					.addComponent(lblWhatWouldYou)
					.addGap(289))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(339)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDeleteItem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(btnDailySale, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
					.addGap(314))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblWhatWouldYou)
					.addGap(38)
					.addComponent(btnDailySale)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnDeleteItem)
					.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
