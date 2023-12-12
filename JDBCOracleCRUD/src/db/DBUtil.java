package db;

import java.sql.*;

public class DBUtil {
	
	final static String _CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String _PASSWORD = "player";
	final static String _USERNAME = "system";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			
			Class.forName("");
			conn = DriverManager.getConnection(_CONNECTION, _USERNAME, _PASSWORD);
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return conn;
		
	}
	
	public static void closeConnection(Connection conn) {
		
		try {
			
			conn.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
