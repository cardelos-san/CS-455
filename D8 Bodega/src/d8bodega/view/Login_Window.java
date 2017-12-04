package d8bodega.view;

import org.mindrot.jbcrypt.*;
import d8bodega.database.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Login_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Database db;

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Login_Window() throws Exception {
		db = new Database();
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.CYAN);
		
		JTextPane txtpnUserid = new JTextPane();
		txtpnUserid.setEditable(false);
		txtpnUserid.setBackground(Color.LIGHT_GRAY);
		txtpnUserid.setText("USER");
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.LIGHT_GRAY);
		txtpnPassword.setText("PASSWORD");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setForeground(Color.GREEN);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password= passwordField.getText();
				String username= textField.getText();
				
				String hash = "dummy";
				
				
				
				
				try {
					hash = db.getPassword(username);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				boolean authenticated = false;
				boolean bcrypted = true;
				
				try {
				authenticated = BCrypt.checkpw(password, hash);
				}
				catch(Exception bcrypt) {
					bcrypted = false;	
				}
				
                
				
				if (authenticated && bcrypted){
					passwordField.setText(null);
				    textField.setText(null);
				    Select_Window nextFrame;
					try {
						nextFrame = new Select_Window ();
						nextFrame.run();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
				    dispose();
			}
				else {
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password","LOGINERROR",
						JOptionPane.ERROR_MESSAGE);
				}
				
			}});
		btnLogin.setForeground(Color.RED);
		
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setBackground(Color.CYAN);
		txtpnWelcome.setForeground(Color.BLACK);
		txtpnWelcome.setFont(new Font("Dialog", Font.BOLD, 40));
		txtpnWelcome.setText("WELCOME");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Carl\\Documents\\CS-455\\D8 Bodega\\images\\d8bodega.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(320)
					.addComponent(txtpnWelcome, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(404, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnUserid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPassword, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, 176, 176, 176)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGap(236)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(183))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(txtpnWelcome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnUserid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnPassword, GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReset)
								.addComponent(btnLogin)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addGap(172))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
