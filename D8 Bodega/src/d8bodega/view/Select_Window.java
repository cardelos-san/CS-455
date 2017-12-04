package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	public Select_Window() {
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectWhatTo = new JLabel("SELECT WHAT TO DO ");
		lblSelectWhatTo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectWhatTo.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("VIEW INVENTORY");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_1 = new JButton("EDIT INVENTORY");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit_Window edit = new Edit_Window();
				edit.run();
				dispose();
		  }
		  
			
		});
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Login_Window nextFrame = new Login_Window();
					nextFrame.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
			}
		});
		
		btnLogout.setForeground(Color.RED);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(389, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(368, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSelectWhatTo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(335))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(lblSelectWhatTo)
					.addGap(86)
					.addComponent(btnNewButton)
					.addGap(64)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
					.addComponent(btnLogout))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
