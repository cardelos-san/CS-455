package d8bodega.model;
import java.util.Date;

public class Stock {
	private int stockID;
	private String stockName;
	private Date lastUpdate;
	private int noAvailable;
	private int noPreferred;
	private int noMissing;
	
	public Stock(int stockID, String stockName, Date lastUpdate, int noAvailable, int noPreferred, int noMissing){
		this.stockID = stockID;
		this.stockName = stockName;
		this.lastUpdate = lastUpdate;
		this.noAvailable = noAvailable;
		this.noPreferred = noPreferred;
		this.noMissing = noMissing;
	}
	
	public String toString(){
		String result;
		result = "stockID: " + this.stockID + " Stock Name: " + this.stockName + " Number Available: " + this.noAvailable +
				" Number Preferred: " + this.noPreferred + " Number Missing: " + this.noMissing + " Last updated: " +
				 this.lastUpdate + "\n";
		return result;
	}
}
