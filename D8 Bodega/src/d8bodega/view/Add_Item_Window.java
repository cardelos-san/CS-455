package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import d8bodega.database.*;
import d8bodega.model.*;
import java.awt.Color;

public class Add_Item_Window extends JFrame {

	private JPanel contentPane;
	private JTextField NameTextField;
	private JTextField PriceTextField;
	private JTextPane txtpnEnterName;
	private JComboBox categoryList;
	private Database db;
	private int categoryID;
	private final int DEFAULT_STOCK = 0;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					Add_Item_Window frame = new Add_Item_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				
			
				}
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Add_Item_Window() throws Exception {
		db= new Database();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtpnEnterName = new JTextPane();
		txtpnEnterName.setEditable(false);
		txtpnEnterName.setText("Enter Name");
		
		NameTextField = new JTextField();
		NameTextField.setColumns(10);
		
		JTextPane txtpnEnterPrice = new JTextPane();
		txtpnEnterPrice.setEditable(false);
		txtpnEnterPrice.setText("Enter Price");
		
		PriceTextField = new JTextField();
		PriceTextField.setColumns(10);
		
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
		categoryList = new JComboBox();
		JTextPane txtpnSelectCate = new JTextPane();
		txtpnSelectCate.setEditable(false);
		txtpnSelectCate.setText("Select Category");
		categoryList.setModel(new DefaultComboBoxModel(new String[] {"Produce", "Meat", "Seafood", "Dairy", "Beverages", "Bread & Bakery", "Rice, Pasta & Beans", "Frozen", "Sauces", "Snack & Candy", "Canned Goods", "Cleaning & Laundry"}));
		categoryList.setMaximumRowCount(13);
		
		JButton btnReset = new JButton("RESET");
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String itemName = NameTextField.getText();
				float price = Float.parseFloat(PriceTextField.getText());
				String categoryName = categoryList.getSelectedItem().toString();
				Item newItem = null;
				Stock defaultStock = null;
				
				switch(categoryName) {
				
				case "Produce": 
					categoryID = 1;
					break;
				
				case "Meat":	
					categoryID = 2;
					break;
				
				case "Seafood": 
					categoryID = 3;
					break;
				
				case "Dairy":	
					categoryID = 4;
					break;
				
				case "Bevarage": 
					categoryID = 5;
					break;
				
				case "Bread & Bakery": 
					categoryID = 6;
					break;
				
				case "Rice, Pasta & Beans": 
					categoryID = 7;
					break;
				
				case "Frozen": 
					categoryID = 8;
					break;
				
				case "Sauces": 
					categoryID = 9;
					break;
				
				case "Snack & Candy": 
					categoryID = 10;
					break;
				
				case "Canned Goods": 
					categoryID = 11;
					break;
				
				case "Cleaning & Laundry": 
					categoryID = 12;
					break;
				}
				newItem = new Item(itemName, categoryID , price, 1);
				
				try {
					db.addItem(newItem);
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					defaultStock = new Stock(db.getItemID(itemName), 1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					db.addStock(defaultStock);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		
		
		JLabel lblAddItem = new JLabel("ADD ITEM");
		lblAddItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnGoBack)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnReset)
							.addGap(10)
							.addComponent(btnSubmit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnSelectCate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtpnEnterPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(categoryList, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
										.addComponent(PriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(txtpnEnterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(NameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(478))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(318)
					.addComponent(lblAddItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(392))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(lblAddItem, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGap(60)
							.addComponent(NameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpnEnterName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(PriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnEnterPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnSelectCate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(categoryList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSubmit)
							.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
							.addComponent(btnGoBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
