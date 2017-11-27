package d8bodega.database;

import java.util.List;
import d8bodega.model.*;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

/*Database class manages connection between the application and database*/
public class Database{
	private Connection dbConnection;
    private boolean connected;
    
    public Database(String username, String password) throws Exception{
        try {
        	dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bodega", username, password);
        } 
        catch (Exception e) {dbConnection = null;}
        connected = (dbConnection != null);
        if(!connected) throw new Exception("Could not establish connection to Database. Check username/password.");
    }
    
    public Database() throws Exception{
        try {
        	dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bodega", "root", "soyyo1996");
        } 
        catch (Exception e) {dbConnection = null;}
        connected = (dbConnection != null);
        if(!connected) throw new Exception("Could not establish connection to Database. Check username/password.");
    }
    
    public void close(){
        if (!connected) return;
        try {dbConnection.close();}
        catch (Exception e) {}
        connected = false;
        dbConnection = null;
    }
    
    public Item getItem(int itemID) throws Exception{
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	String sql, itemName, categoryName;
        float price;
		Item item = null;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
        try {
            sql = "SELECT itemName, price, categoryName FROM item, category WHERE itemID = ? LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, itemID );
            rset = stmt.executeQuery();
            if (rset.next()){
            	itemName = rset.getString( "itemName" );
            	categoryName = rset.getString("categoryName");
                price = rset.getFloat("price" );
                item = new Item( itemID, itemName, categoryName, price );
            }
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return item;
    }
    
    public List<Item> getAllItems() throws Exception{
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	String sql, itemName, categoryName;
        float price;
        int itemID;
		Item item = null;
		List<Item> items = new ArrayList<Item>();
        if (!connected) return null;
        try{
            sql = "SELECT itemID, itemName, price, categoryName FROM item, category WHERE item.categoryID = category.categoryID";
            stmt = dbConnection.prepareStatement(sql);
            rset = stmt.executeQuery();
            while (rset.next()) {
            	itemID = rset.getInt("itemID");
                itemName = rset.getString( "itemName" );
                price = rset.getFloat("price");
                categoryName = rset.getString("categoryName");
                item = new Item( itemID, itemName, categoryName, price );
                items.add(item);
            }
        } 
        catch (Exception e){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return items;
    }
    
    public Stock getStock(int stockID) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	String sql, stockName;
    	java.sql.Date lastUpdate;
    	int noAvailable, noPreferred, noMissing;
    	Stock stock = null;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed!" );
        try{
            sql = "SELECT stockID, date_updated, noAvailable, noPreferred, noMissing, itemName " + 
            		"FROM stock, item WHERE stockID = ? LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, stockID );
            rset = stmt.executeQuery();
            if (rset.next()){
                noAvailable = rset.getInt( "noAvailable" );
                noPreferred = rset.getInt("noPreferred");
                noMissing = rset.getInt("noMissing");
                lastUpdate = rset.getDate("date_updated" );
                stockName = rset.getString("itemName");
                stock = new Stock(stockID, stockName, lastUpdate, noAvailable, noPreferred, noMissing);
            }
        } 
        catch ( Exception e ){
        	System.out.println( "Error getting item from database: " + e.getMessage());
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return stock;
    }
    
    public ArrayList<Stock> getAllStock() throws Exception{
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	String sql, stockName;
    	java.sql.Date lastUpdate;
    	int stockID, noAvailable, noPreferred, noMissing;
    	ArrayList<Stock> stockList = new ArrayList<Stock>();
    	Stock stock = null;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed!" );
        try{
        	sql = "SELECT stockID, date_updated, noAvailable, noPreferred, noMissing, itemName "+
        "FROM stock, item WHERE item.itemID = stock.itemID";
            stmt = dbConnection.prepareStatement( sql );
            rset = stmt.executeQuery();
            while (rset.next()) {
            	stockID = rset.getInt("stockID");
            	noAvailable = rset.getInt( "noAvailable" );
                noPreferred = rset.getInt("noPreferred");
                noMissing = rset.getInt("noMissing");
                lastUpdate = rset.getDate("date_updated" );
                stockName = rset.getString("itemName");
                stock = new Stock(stockID, stockName, lastUpdate, noAvailable, noPreferred, noMissing);
                stockList.add(stock);
            }
        } 
        catch (Exception e){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return stockList;
    }

}
