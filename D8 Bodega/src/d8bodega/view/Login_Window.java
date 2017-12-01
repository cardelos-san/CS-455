package d8bodega.view;

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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login_Window() {
		setTitle("8 Brothers SuperMaket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.CYAN);
		
		JTextPane txtpnUserid = new JTextPane();
		txtpnUserid.setEditable(false);
		txtpnUserid.setBackground(Color.LIGHT_GRAY);
		txtpnUserid.setText("USERID");
		txtpnUserid.setBounds(179, 131, 56, 16);
		contentPane.add(txtpnUserid);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(Color.LIGHT_GRAY);
		txtpnPassword.setText("PASSWORD");
		txtpnPassword.setBounds(179, 159, 76, 16);
		contentPane.add(txtpnPassword);
		
		textField = new JTextField();
		textField.setBounds(234, 131, 120, 16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 159, 100, 16);
		contentPane.add(passwordField);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setForeground(Color.GREEN);
		btnReset.setBounds(138, 197, 117, 29);
		contentPane.add(btnReset);
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password= passwordField.getText();
				String username= textField.getText();
				
				if (password.contains("hann")&username.contains("luis")){
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
					JOptionPane.showMessageDialog(null,"Invalid UserName or Password","LOGINERROR",
						JOptionPane.ERROR_MESSAGE);
				}
				
			}});
		btnLogin.setForeground(Color.RED);
		btnLogin.setBounds(255, 197, 117, 29);
		contentPane.add(btnLogin);
		
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setEditable(false);
		txtpnWelcome.setBackground(Color.CYAN);
		txtpnWelcome.setForeground(Color.BLACK);
		txtpnWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		txtpnWelcome.setText("WELCOME");
		txtpnWelcome.setBounds(204, 62, 108, 29);
		contentPane.add(txtpnWelcome);
	}
}
