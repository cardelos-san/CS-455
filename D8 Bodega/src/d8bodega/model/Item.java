package d8bodega.model;

public class Item {
	private int itemID;
	private int categoryID;
	private String itemName;
	private String categoryName;
	private float price;
	private int createdByUser;
	
	public Item(int itemID, String itemName, String categoryName, float price){
		this.itemID = itemID;
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.price = price;
	}
	
	public Item(String itemName, int categoryID, float price, int userID){
		this.itemName = itemName;
		this.categoryID = categoryID;
		this.price = price;
		this.createdByUser = userID;
	}
	
	public String getItemName(){return this.itemName;}
	
	public String getCategoryName() {return this.categoryName;}
	
	public int getCategoryID() {return this.categoryID;}
	
	public int getItemID(){return this.itemID;}
	
	public int getUserID() {return this.createdByUser;}
	
	public float getPrice(){return this.price;}

	
	public String toString(){
		String result;
		result = "ItemID: " + this.itemID + " Item Name: " + this.itemName + " Category Name: " 
				+ this.categoryName + " Price: $" + this.price + "\n";
		return result;
	}
}
