package crud;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import db.DBUtil;
import obj.Initialization;

public class ManageTable {
	
	public boolean checkDatabase () {
		
		Connection conn = null;
		boolean isExists = false;
        ResultSet resultSet = null;
		try {
			
			conn = DBUtil.getConnection();
			DatabaseMetaData metaData = conn.getMetaData();
			resultSet = metaData.getTables(null, Initialization._USERNAME.toUpperCase(), Initialization._DB_TABLE, new String[]{"TABLE"});
			while (resultSet.next()) {
				isExists = true;
			}
			DBUtil.closeConnection(conn);

		}
		catch (SQLException e) {
			
			e.printStackTrace();
	        
		}
		return isExists;
		
	}
	
	public boolean createDatabase() {
		
		Connection conn = null;
		Statement statement = null;
		boolean status = true;
		try {

			conn = DBUtil.getConnection();
			statement = conn.createStatement();
			statement.execute(Initialization._SQL_CREATE_SEQ);
			status = statement.execute(Initialization._SQL_CREATE);
            DBUtil.closeConnection(conn);

        }
		catch (SQLSyntaxErrorException e) {
			
			e.printStackTrace();
            
        }
		catch (Exception e) {
			
            e.printStackTrace();
            
        }
		return status;
		
	}

}
