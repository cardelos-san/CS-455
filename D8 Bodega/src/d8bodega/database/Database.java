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
        if(!connected) throw new Exception("Could not establish connection to Database. Check username/password or if table exists.");
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
    
    public int getItemID(String itemName) throws Exception{
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	int itemID = 0;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
        try {
            sql = "SELECT itemID FROM item WHERE itemName = ? LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setString( 1, itemName );
            rset = stmt.executeQuery();
            if (rset.next()){
            	itemID = rset.getInt("itemID");
            }
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return itemID;
    }
    
    public int getStockID(String stockName) throws Exception{
    	
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	int stockID = 0;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
        try {
            sql = "SELECT stockID FROM stock,item WHERE itemName = ? AND stock.itemId = item.itemId LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setString( 1, stockName );
            rset = stmt.executeQuery();
            if (rset.next()){
            	stockID = rset.getInt("stockId");
            }
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
        return stockID;
    	
    }
    
    public void addItem(Item item) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
    	String itemName = item.getItemName();
    	int categoryID = item.getCategoryID();
    	int userID = item.getUserID();
    	float price = item.getPrice();
    	
    	
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
        
        try {
            sql = "INSERT INTO item(itemName, price, categoryId, userId ) VALUES (?, ?, ?, ?)";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setString( 1, itemName );
            stmt.setFloat(2, price);
            stmt.setInt(3, categoryID);
            stmt.setInt(4, userID );
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void deleteItem(String itemName) throws Exception {
    	PreparedStatement stmt = null;
    	String sql;
    	
    	try {
    		sql = "DELETE FROM item WHERE itemName = ?";
    		stmt = dbConnection.prepareStatement( sql );
    		stmt.setString( 1, itemName );
    		stmt.executeUpdate();
    	}
    	catch ( Exception e ){
        	throw e;
        } 
    	
    	finally {
    		stmt.close();
    	}
    	
    	
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
    
    public Stock getStockByName(String stockName) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rset = null;
    	String sql;
    	java.sql.Date lastUpdate;
    	int noAvailable, noPreferred, noMissing;
    	Stock stock = null;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed!" );
        try{
            sql = "SELECT date_updated, noAvailable, noPreferred, noMissing, itemName " + 
            		"FROM stock, item WHERE itemName = ? AND stock.itemId = item.itemId  LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setString( 1, stockName);
            rset = stmt.executeQuery();
            if (rset.next()){
                noAvailable = rset.getInt( "noAvailable" );
                noPreferred = rset.getInt("noPreferred");
                noMissing = rset.getInt("noMissing");
                lastUpdate = rset.getDate("date_updated" );
                stockName = rset.getString("itemName");
                stock = new Stock(stockName, lastUpdate, noAvailable, noPreferred, noMissing);
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
    
    public void addStock(Stock newStock) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
    	int itemID = newStock.getItemID();
    	int userID = newStock.getUserID();
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "INSERT INTO stock(itemId, userId ) VALUES (?, ?)";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, itemID );
            stmt.setInt(2, userID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void addStock(int stockID, int noAvailable) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "UPDATE stock SET noAvailable = noAvailable + ? WHERE stockID = ?";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, noAvailable );
            stmt.setInt(2, stockID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void updateNoAvailable(int stockID, int noSold) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "UPDATE stock SET noAvailable = noAvailable - ? WHERE stockID = ?";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, noSold );
            stmt.setInt(2, stockID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void updateNoPreferred(int stockID, int noPreferred) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "UPDATE stock SET noPreferred = ? WHERE stockID = ?";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, noPreferred );
            stmt.setInt(2, stockID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void updateNoSold(int stockID, int noSold) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "UPDATE stock SET noSold = noSold + ? WHERE stockID = ?";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, noSold );
            stmt.setInt(2, stockID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
    }
    
    public void updateNoMissing(int stockID, int noAvailable, int noPreferred) throws Exception{
    	PreparedStatement stmt = null;
    	String sql;
        if (!connected) throw new Exception( "Could not connect to database: Connection closed" );
     
        try {
            sql = "UPDATE stock SET noMissing = ? - ? WHERE stockId = ?";
            stmt = dbConnection.prepareStatement( sql );
            stmt.setInt( 1, noPreferred );
            stmt.setInt(2, noAvailable);
            stmt.setInt(3, stockID);
            stmt.executeUpdate();
        } 
        catch ( Exception e ){
        	throw e;
        } 
        finally{
        	stmt.close();
        }
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
    
    public String getPassword( String uName ) throws SQLException {
    	PreparedStatement stmt = null;
    	String sql;
    	String hash = "";
    	
    	sql = "SELECT pWord FROM users WHERE uName = ? LIMIT 1";
    	try {
    		stmt = dbConnection.prepareStatement( sql );
    		stmt.setString( 1, uName );
    		ResultSet rset = stmt.executeQuery();
    		
    		if ( rset.next() ) {
    			hash = rset.getString( "pWord" );
    		}
    	} finally {
    		stmt.close();
    	}
    	
    	return hash;
    }
    
    public User getUser(String username)throws SQLException {
    	User user;
    	int userId = 0;
    	PreparedStatement stmt = null;
    	String sql;
    	
    	sql = "SELECT userId, uName FROM users WHERE uName = ? LIMIT 1";
    	try {
    		stmt = dbConnection.prepareStatement( sql );
    		stmt.setString( 1, username );
    		ResultSet rset = stmt.executeQuery();
    		if ( rset.next() ) {
    			userId = rset.getInt( "userId" );
    		}
    	} finally {
    		stmt.close();
    	}
    	
    	user = new User(userId, username);    	
    	return user;
    	
    }
    
   
}
