package d8bodega.model;
import java.util.Date;

public class Stock {
	private int stockID;
	private String stockName;
	private Date lastUpdate;
	private int noAvailable;
	private int noPreferred;
	private int noMissing;
	private int createdByUser;
	private int itemID;
	
	public Stock(int stockID, String stockName, Date lastUpdate, int noAvailable, int noPreferred, int noMissing){
		this.stockID = stockID;
		this.stockName = stockName;
		this.lastUpdate = lastUpdate;
		this.noAvailable = noAvailable;
		this.noPreferred = noPreferred;
		this.noMissing = noMissing;
	}
	
	public Stock(String stockName, Date lastUpdate, int noAvailable, int noPreferred, int noMissing){
		this.stockName = stockName;
		this.lastUpdate = lastUpdate;
		this.noAvailable = noAvailable;
		this.noPreferred = noPreferred;
		this.noMissing = noMissing;
	}
	
	public Stock(int itemID, int userID){
		this.itemID = itemID;
		this.createdByUser = userID;
	}
	
	public int getStockID(){return this.stockID;}
	
	public int getItemID() {return this.itemID;}
	
	public int getUserID() {return this.createdByUser;}
	
	public String getStockName(){return this.stockName;}
	
	public Date getLastUpdated(){return this.lastUpdate;}
	
	public int getNoAvailable(){return this.noAvailable;}
	
	public int getNoPreferred(){return this.noPreferred;}
	
	public int getNoMissing(){return this.noMissing;}
	
	public String toString(){
		String result;
		result = "stockID: " + this.stockID + " Stock Name: " + this.stockName + " Number Available: " + this.noAvailable +
				" Number Preferred: " + this.noPreferred + " Number Missing: " + this.noMissing + " Last updated: " +
				 this.lastUpdate + "\n";
		return result;
	}
}
