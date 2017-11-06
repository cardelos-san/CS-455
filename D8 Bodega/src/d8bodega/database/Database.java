package d8bodega.database;

import java.util.List;

import d8bodega.model.Item;

import java.util.ArrayList;
import java.sql.*; //Allows you to use JDBC classes/interfaces
import java.time.LocalDate;
import java.util.Date;

public class Database{
	private Connection dbConnection;
    private boolean connected;
    
    public Database(String username, String password){
        try {
            //Connect to the database
        	dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bodega", username, password);
        } catch (Exception e) {dbConnection = null;}
        connected = (dbConnection != null);
    }
    
    public boolean checkDBConnection() {return connected;}
    
    public void close(){
        if (!connected) return;
        try {dbConnection.close();}
        catch (Exception e) {}
        connected = false;
        dbConnection = null; // Clean up before clearing
    }
    
    public Item getItem(int itemID) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rset = null; // result - gets returned
    	String sql, itemName;
        float price;
		Item item = null;
        
        // Return if the database is closed.
        if (!connected) throw new Exception( "Could not connect to database: Connection closed!" );
        
        try {
            // Create a PreparedStatement for the update.
            sql = "SELECT * FROM item WHERE itemID = ? LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );

            // Set the parameters in the statement
            stmt.setInt( 1, itemID );

            // Execute SQL Update
            rset = stmt.executeQuery();

            if (rset.next()){
            	itemName = rset.getString( "itemName" );
                price = rset.getFloat("price" );
                item = new Item( itemID, itemName, price );
            }

        } catch ( Exception e ) {
        	System.out.println( "Error getting item from database: " + e.getMessage());
        	throw e;
        } finally {
        	stmt.close();
        }
        
        return item;
    }
    
    public Item getStock(int stockID) throws Exception {
    	PreparedStatement stmt = null;
    	ResultSet rset = null; // result - gets returned
    	String sql, stockName;
    	java.sql.Date lastUpdate;
    	int noAvailable, noPreferred, noMissing;
        
        // Return if the database is closed.
        if (!connected) throw new Exception( "Could not connect to database: Connection closed!" );
        
        try {
            // Create a PreparedStatement for the update.
            sql = "SELECT * FROM stock WHERE stockID = ? LIMIT 1";
            stmt = dbConnection.prepareStatement( sql );

            // Set the parameters in the statement
            stmt.setInt( 1, stockID );

            // Execute SQL Update
            rset = stmt.executeQuery();

            if (rset.next()){
                noAvailable = rset.getInt( "noAvailable" );
                price = rset.getFloat("price" );
                item = new Item( itemID, itemName, price );
            }

        } catch ( Exception e ) {
        	System.out.println( "Error getting item from database: " + e.getMessage());
        	throw e;
        } finally {
        	stmt.close();
        }
        
        return item;
    }

}
