package d8bodega.model;

public class Item {
	private int itemID;
	private String itemName;
	private float price;
	
	public Item(int itemID, String itemName, float price){
		this.itemID = itemID;
		this.itemName = itemName;
		this.price = price;
	}
	
	public String toString(){
		String result;
		result = "ItemID: " + this.itemID + " ItemName: " + this.itemName + " Price: " + this.price;
		return result;
	}
}
