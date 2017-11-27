package d8bodega.view;

import d8bodega.database.Database;
import d8bodega.model.Stock;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Stock_Window extends JFrame {
	
	private ArrayList<Stock> list;

	private JPanel contentPane;

	/**
	 * Displays all stock in database
	 */
	
			public void run() {
				try {
					Stock_Window frame = new Stock_Window();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Stock_Window() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		JTextPane txtpnThisIsWhats = new JTextPane();
		txtpnThisIsWhats.setForeground(Color.RED);
		txtpnThisIsWhats.setEnabled(false);
		txtpnThisIsWhats.setText("THIS IS WHAT'S IN STOCK");
		txtpnThisIsWhats.setBounds(117, 6, 221, 41);
		contentPane.add(txtpnThisIsWhats);
		JScrollPane scrollTable = new JScrollPane();
		
		contentPane.add(scrollTable);
		
		scrollTable.setEnabled(false);
		
		scrollTable.setFocusable(true);
		
		scrollTable.setViewportView(show_stock());
		
		
		
		
	
		
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   Select_Window goBack;
				try {
					goBack = new Select_Window();
					goBack.run();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				    dispose();
				
			}
		});
		
		btnGoBack.setForeground(Color.GREEN);
		btnGoBack.setBounds(6, 229, 117, 29);
		contentPane.add(btnGoBack);
		
		JButton btnPrintInventory = new JButton("PRINT ALL STOCK");
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
	
	public JTable show_stock() throws Exception{
		Database db = new Database();
		list = db.getAllStock();
		String column[]= {"STOCKID","STOCKNAME","LastUpdate","noAvailable","noPreffered","noMissing"};
		Object data[][] = new Object[][]{{"3", "Pato", "123", "no", "klk", "loco"}, {"3", "Pato", "123", "no", "klk", "loco"},};
		JTable  stockTable = new JTable(data, column);
		return stockTable;
		
	}
}
	

