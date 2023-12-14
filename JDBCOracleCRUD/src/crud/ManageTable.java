package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBUtil;
import obj.Initialization;

public class ManageTable {
	
	public static boolean checkDatabase () {
		
		Connection conn = DBUtil.getConnection();;
		boolean isExists = false;
        
        try {
        	Statement obj_st = conn.createStatement();
        	ResultSet obj_rs = obj_st.executeQuery("SELECT null FROM " + Initialization._DB_TABLE + " UNION SELECT 1 FROM dual");
        	while(obj_rs.next()) {
        		
        		isExists = true;
        		
        	}
        	DBUtil.closeConnection(conn);
        }        
		catch (java.sql.SQLSyntaxErrorException e) {
			
			System.out.println("Table " + Initialization._DB_TABLE + " doesn't exist. Error Code " + e.getErrorCode());
	        
		}        
		catch (Exception e) {
			
			e.printStackTrace();
	        
		}
		return isExists;
		
	}
	public static boolean createDatabase() {
		
		Connection conn = null;
		Statement statement = null;
		boolean status = true;
		try {

			conn = DBUtil.getConnection();
			statement = conn.createStatement();
			statement.execute(Initialization._SQL_CREATE_SEQ);
			statement.execute(Initialization._SQL_CREATE);
            DBUtil.closeConnection(conn);
            status = true;

        }
		catch (Exception e) {
			
            e.printStackTrace();
            status = false;
            
        }
		return status;
		
	}
	public static boolean dropDatabase() {
		
		Connection conn = null;
		Statement statement = null;
		boolean status = true;
		try {

			conn = DBUtil.getConnection();
			statement = conn.createStatement();
			statement.execute(Initialization._SQL_DROP);
			statement.execute(Initialization._SQL_DROP_SEQ);
            DBUtil.closeConnection(conn);
            status = true;

        }
		catch (java.sql.SQLSyntaxErrorException e) {
			
			status = false;
	        
		} 
		catch (Exception e) {
			
            e.printStackTrace();
            status = false;
            
        }
		return status;
		
	}

}
