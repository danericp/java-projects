package crud;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBUtil;
import obj.Initialization;

public class ImageTable {
	
	public final static String _SQL = "CREATE TABLE " + Initialization._DB_TABLE + " (" +
			Initialization._DB_TABLE_COL1_N_ID + " INT AUTO_INCREMENT PRIMARY KEY," +
			Initialization._DB_TABLE_COL2_N_CONTENT + " BLOB NOT NULL," +
			Initialization._DB_TABLE_COL3_N_NAME + " VARCHAR(100) NOT NULL," +
			Initialization._DB_TABLE_COL4_N_DESC + " VARCHAR(200)" +
			Initialization._DB_TABLE_COL5_N_TYPE + " VARCHAR(25)" +
			Initialization._DB_TABLE_COL6_N_CREATED + " DATE" +
			")";
	
	public boolean checkDatabase() {
		
		Connection conn = null;
		boolean isExists = true;
        ResultSet resultSet = null;
		try {
			
			// Create a connection to the Oracle database
			conn = DBUtil.getConnection();
		
			// Get the database metadata
			DatabaseMetaData metaData = conn.getMetaData();

			// Check if the table exists
			resultSet = metaData.getTables(null, user.toUpperCase(), tableName, new String[]{"TABLE"});

			if (resultSet.next()) {
				System.out.println("Table '" + tableName + "' exists in the database.");
				} else {
	                System.out.println("Table '" + tableName + "' does not exist in the database.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources in the finally block to ensure they're always closed
	            try {
	                if (resultSet != null) {
	                    resultSet.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		return isExists;
		
	}
	
	public Integer createDatabase() {
		
		Connection conn = null;
		Statement statement = null;
		Integer status = 0;
		try {

			conn = DBUtil.getConnection();
			statement = conn.createStatement();
            statement.execute(_SQL);

        }
		catch (SQLException e) {
			
            e.printStackTrace();
            
        }
		finally {
			
            try {
            	
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
                
            }
            catch (SQLException e) {
            	
                e.printStackTrace();
                
            }
        }
		return status;
		
	}

}
