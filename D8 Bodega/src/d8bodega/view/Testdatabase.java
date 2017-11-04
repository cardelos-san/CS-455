package d8bodega.view;
import d8bodega.database.Database;;

public class Testdatabase {
	
	
	
	public static void main(String[]arg){
		
		Database db = new Database("root", "soyyo1996");
		
		String result = "";
		
		try {
			result = db.getItem(1).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
		
	}

}
