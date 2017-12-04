package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextPane txtpnEnterName;
	private JComboBox categoryList;
	private Database db;
	private int categoryID;
	private final int DEFAULT_STOCK = 0;
	int itemID;

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
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtpnEnterName = new JTextPane();
		txtpnEnterName.setEditable(false);
		txtpnEnterName.setText("Enter Name");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JTextPane txtpnEnterPrice = new JTextPane();
		txtpnEnterPrice.setEditable(false);
		txtpnEnterPrice.setText("Enter Price");
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Edit_Window goback = new Edit_Window();
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
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				priceTextField.setText(null);
				nameTextField.setText(null);
			}
		});
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean itemExists = false;
				String itemName = nameTextField.getText();
				
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
					JOptionPane.showMessageDialog(null,"Item already exists in the dabase","ITEM DOES NOT EXIST",
							JOptionPane.ERROR_MESSAGE);
					priceTextField.setText(null);
					nameTextField.setText(null);	
				}
				
				else {
					float price = Float.parseFloat(priceTextField.getText());
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
					
					case "Beverages": 
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
					
					
					JOptionPane.showMessageDialog(null,"Item added succesfully","ITEM ADDED",
							JOptionPane.INFORMATION_MESSAGE);
					
					Update_Stock_Window nextFrame = new Update_Stock_Window();
					nextFrame.run(itemName);
					db.close();
					dispose();
				}
			}
			
			
			
			
		});
		
		
		JLabel lblAddItem = new JLabel("ADD ITEM");
		lblAddItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAddItem.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel label = new JLabel("$");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGoBack)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnReset)
							.addGap(10)
							.addComponent(btnSubmit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtpnSelectCate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtpnEnterPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(categoryList, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtpnEnterName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(28))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(lblAddItem, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblAddItem, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnEnterName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label))
						.addComponent(txtpnEnterPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnSelectCate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(categoryList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSubmit)
							.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
							.addComponent(btnGoBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
