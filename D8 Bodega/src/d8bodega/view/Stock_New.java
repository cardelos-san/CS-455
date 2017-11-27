package d8bodega.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import d8bodega.database.Database;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class Stock_New {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock_New window = new Stock_New();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Stock_New() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 933, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		frame.getContentPane().add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblDisplayingStock = new JLabel("DISPLAYING STOCK");
		lblDisplayingStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titlePanel.add(lblDisplayingStock);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBackground(Color.WHITE);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		try {
			scrollPane.setViewportView(show_stock());
			
			JPanel navigation = new JPanel();
			frame.getContentPane().add(navigation, BorderLayout.SOUTH);
			navigation.setLayout(new BorderLayout(0, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JTable show_stock() throws Exception{
		String column[]= {"Stock ID","Item Name","Available","Preferred","Missing", "Last Updated"};
		Object data[][] = new Object[][]{{"3", "Pato", "123", "no", "klk", "loco"}, {"3", "Pato", "123", "no", "klk", "loco"},};
		JTable  stockTable = new JTable(data, column);
		stockTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		stockTable.setFillsViewportHeight(true);
		stockTable.setRowSelectionAllowed(false);
		stockTable.setBackground(Color.WHITE);
		stockTable.setEnabled(false);
		return stockTable;
		
	}

}
