package d8bodega.model;

public class Item {
	private int itemID;
	private String itemName;
	private String categoryName;
	private float price;
	
	public Item(int itemID, String itemName, String categoryName, float price){
		this.itemID = itemID;
		this.itemName = itemName;
		this.categoryName = categoryName;
		this.price = price;
	}
	
	public String toString(){
		String result;
		result = "ItemID: " + this.itemID + " Item Name: " + this.itemName + " Category Name: " 
				+ this.categoryName + " Price: $" + this.price + "\n";
		return result;
	}
}
