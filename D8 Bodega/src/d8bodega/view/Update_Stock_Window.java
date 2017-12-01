package d8bodega.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import d8bodega.model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
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
import javax.swing.JScrollPane;

public class Update_Stock_Window extends JFrame {

	private JPanel contentPane;
	private Stock stock;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	 
			public void run(Stock stock) {
				try {
					Update_Stock_Window frame = new Update_Stock_Window(stock);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	public Update_Stock_Window(String placeHolder) {
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @wbp.parser.constructor
	 */
	public Update_Stock_Window(Stock stock) throws Exception {
		table_1 = new JTable();
		try {
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(table_1 == null) {
			System.out.println("In Update_Stock_widow, table is null");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWhatWouldYou = new JLabel("Updating Stock");
		lblWhatWouldYou.setBackground(new Color(0, 0, 0));
		lblWhatWouldYou.setForeground(new Color(0, 0, 0));
		lblWhatWouldYou.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWhatWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatWouldYou.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGoBack)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(331)
							.addComponent(lblWhatWouldYou))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(lblWhatWouldYou)
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
					.addComponent(btnGoBack))
		);
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JTable show_stock(Stock stock) throws Exception{
		System.out.println(stock.getStockName());
		String column[]= {"Stock Name","Number available","Number Missing","Preferred Number","Last Updated"};
		Object data2[][] = new Object[1][5];
		data2[0][0] = stock.getStockName();
		data2[0][1] = stock.getNoAvailable();
		data2[0][2] = stock.getNoMissing();
		data2[0][3] = stock.getNoPreferred();
		data2[0][4] = stock.getLastUpdated();
		JTable  stockTable = new JTable(data2, column);
		stockTable.setBackground(new Color(51, 255, 255));
		
		return stockTable;
	}
}
