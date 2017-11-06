package d8bodega;
import d8bodega.database.Database;
import java.util.Scanner;

/*Class for testing database functionality*/

public class Testdatabase {
	
	public static void main(String[]arg) throws Exception {
		Scanner scan = new Scanner(System.in);
		String username;
		String password; 
		System.out.println("Database user: ");
		username = scan.next();
		System.out.println("Database password: ");
		password = scan.next();
		Database db = new Database(username, password);
		scan.close();
		String testItem = "";
		String testStock = "";
		String testItemList = "";
		String testStockList = "";
		try {
			testItem = db.getItem(1).toString();
			testStock = db.getStock(1).toString();
			testItemList = db.getAllItems().toString();
			testStockList = db.getAllStock().toString();	
			db.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(testItem);
		System.out.println(testStock);
		System.out.println(testItemList);
		System.out.println(testStockList);	
	}
}
