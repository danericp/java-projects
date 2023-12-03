import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("DatabaseMetaDataTest");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			
			DatabaseMetaData obj_dbmd = obj_conn.getMetaData();

			System.out.println("Driver: " + obj_dbmd.getDriverName());
			System.out.println("Driver Version: " + obj_dbmd.getDriverVersion());
			System.out.println("Database URL: " + obj_dbmd.getURL());
			System.out.println("Maximum Number of Columns in a Table: " + obj_dbmd.getMaxColumnsInTable());
			System.out.println("Username: " + obj_dbmd.getUserName());
			System.out.println("Database Product Name: " + obj_dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + obj_dbmd.getDatabaseProductVersion());
			System.out.println("Database Stored Procedure Support?: " + obj_dbmd.supportsStoredProcedures());
			
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("DatabaseMetaDataTest... Complete");
		}
		
	}

}
