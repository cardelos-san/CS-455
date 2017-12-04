package d8bodega.model;

public class User {
	private int userID;
	private String uName;
	
	public User(int userID, String uName) {
		this.userID = userID;
		this.uName = uName;
	}
	
	public int getUserID() {return userID;}
	public String getUname() {return uName;}
	
	public String toString() {
		String result;
		result = "UserID: " + userID + "uName: " + uName;
		return result;
	}

}
