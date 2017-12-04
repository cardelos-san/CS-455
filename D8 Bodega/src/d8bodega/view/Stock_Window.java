package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import d8bodega.database.Database;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import d8bodega.model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Stock_Window extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Database db;
	private ArrayList<Stock> allStock;
	private int tableSize;

	/**
	 * Launch the application.
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
		try {
			db = new Database();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allStock = db.getAllStock();
		tableSize = allStock.size();
		db.close();
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton goBack = new JButton("Go back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 try {
				Select_Window goback = new Select_Window();
				goback.run();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   dispose();
			}
		
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDisplayingStock = new JLabel("DISPLAYING STOCK");
		lblDisplayingStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDisplayingStock.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDisplayingStock.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(goBack)
					.addContainerGap(709, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
					.addGap(69))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(331)
					.addComponent(lblDisplayingStock, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(320))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblDisplayingStock)
					.addGap(53)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(goBack))
		);
		
		try {
			table = show_stock();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	public JTable show_stock() throws Exception{
		String column[]= {"Stock Name","Number available","Number Missing","Preferred Number","Last Updated"};
		Object data2[][] = new Object[tableSize][5];
		
		for(int i = 0; i < tableSize; i++) {
			data2[i][0] = allStock.get(i).getStockName();
			data2[i][1] = allStock.get(i).getNoAvailable();
			data2[i][2] = allStock.get(i).getNoMissing();
			data2[i][3] = allStock.get(i).getNoPreferred();
			data2[i][4] = allStock.get(i).getLastUpdated();
			}
		
		JTable  stockTable = new JTable(data2, column);
		stockTable.setBackground(new Color(51, 255, 255));
		
		return stockTable;
		
	}
}
