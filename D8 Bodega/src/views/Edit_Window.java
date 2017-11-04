package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit_Window extends JFrame {

	private JPanel contentPane;

	public void start() {
		try {
			Inventory_Window frame = new Inventory_Window();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Edit_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnWhatWouldYou = new JTextPane();
		txtpnWhatWouldYou.setBackground(Color.ORANGE);
		txtpnWhatWouldYou.setBounds(114, 30, 222, 16);
		txtpnWhatWouldYou.setText("What Would You like to edit ?");
		contentPane.add(txtpnWhatWouldYou);
		
		JButton btnEditItem = new JButton("EDIT ITEM");
		btnEditItem.setBackground(Color.RED);
		btnEditItem.setBounds(145, 120, 117, 29);
		contentPane.add(btnEditItem);
		
		JButton btnEditStock = new JButton("EDIT STOCK ");
		btnEditStock.setBounds(145, 152, 117, 29);
		contentPane.add(btnEditStock);
		
		JButton btnGoBack = new JButton("GO BACK ");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select_Window goback = new Select_Window();
				goback.run();
				dispose();
			}
		});
		btnGoBack.setBackground(Color.GREEN);
		btnGoBack.setBounds(5, 243, 117, 29);
		contentPane.add(btnGoBack);
		
		JButton btnDailySales = new JButton("DAILY SALES");
		btnDailySales.setBounds(142, 83, 117, 29);
		contentPane.add(btnDailySales);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(327, 229, 117, 29);
		contentPane.add(btnExit);
	}




}
