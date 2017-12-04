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
		setBounds(100, 100, 869, 502);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGoBack)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(240)
								.addComponent(lblWhatWouldYou))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnDailySale, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)))
								.addGap(11))))
					.addContainerGap(219, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(lblWhatWouldYou)
					.addGap(48)
					.addComponent(btnDailySale)
					.addGap(30)
					.addComponent(btnNewButton)
					.addGap(33)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
