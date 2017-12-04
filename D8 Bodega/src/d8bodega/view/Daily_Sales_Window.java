package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import d8bodega.database.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Daily_Sales_Window extends JFrame {

	private JPanel contentPane;
	private JTextField itemNameTextField;
	private JTextField AmtSoldTextField;
	private Database db;
	private int itemID;
	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Daily_Sales_Window frame = new Daily_Sales_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Daily_Sales_Window() throws Exception {
		db = new Database();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectWhatTo = new JLabel("ENTER DAILY SALES");
		lblSelectWhatTo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSelectWhatTo.setBackground(new Color(255, 255, 255));
		
		JLabel lblEnterTheName = new JLabel("ENTER THE NAME OF THE ITEM");
		
		itemNameTextField = new JTextField();
		itemNameTextField.setColumns(10);
		
		JLabel lblEnterAmountSold = new JLabel("ENTER AMOUNT SOLD");
		
		AmtSoldTextField = new JTextField();
		AmtSoldTextField.setColumns(10);
		
		JButton btnEnter = new JButton("ENTER");
		
		
		btnEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String itemName= itemNameTextField.getText();
				try {
					itemID = db.getItemID(itemName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(itemID == 0) {
					JOptionPane.showMessageDialog(null,"Item cannot be found","ITEM DOES NOT EXIST",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					int stockID = 0;
					int currentNoAvailable=0;
					int currentNoPreferred=0;
					try {
						stockID = db.getStockID(itemName);
						currentNoAvailable = db.getStock(stockID).getNoAvailable();
						currentNoPreferred = db.getStock(stockID).getNoPreferred();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					int noSold = Integer.parseInt(AmtSoldTextField.getText());
					
					if(noSold > currentNoAvailable) {
						JOptionPane.showMessageDialog(null,"Number sold cannot exceed current number available \n"
								+ "Current available is: " + currentNoAvailable,"VALUE ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						try {
							db.updateNoSold(stockID, noSold);
							db.updateNoAvailable(stockID, noSold);
							currentNoAvailable = db.getStock(stockID).getNoAvailable();
							db.updateNoMissing(stockID, currentNoAvailable, currentNoPreferred);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null,"Daily sales has been updated","DAILY SALES",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
			}
			
			
		});
		
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Edit_Window goBack = new Edit_Window();
				goBack.run();
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(282, Short.MAX_VALUE)
					.addComponent(lblSelectWhatTo)
					.addGap(294))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEnter)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterTheName)
								.addComponent(lblEnterAmountSold))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(AmtSoldTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(itemNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(436, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnGoBack)
					.addContainerGap(738, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(lblSelectWhatTo)
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterTheName)
						.addComponent(itemNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterAmountSold)
						.addComponent(AmtSoldTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnEnter)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
