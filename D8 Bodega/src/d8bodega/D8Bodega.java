package d8bodega;

import java.awt.EventQueue;

import d8bodega.view.Login_Window;

public class D8Bodega{

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Window frame = new Login_Window();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
