import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataTest {

	public static void main(String[] args) {
		String str_tb = "employi";
		// TODO Auto-generated method stub
		try {
			System.out.println("ResultSetMetaDataTest");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			ResultSet obj_rs = obj_st.executeQuery("SELECT * FROM " + str_tb);
			ResultSetMetaData obj_rsmd = obj_rs.getMetaData();
			System.out.println("Column Total Count: " + obj_rsmd.getColumnCount());
			System.out.println("Column #2 Name: " + obj_rsmd.getColumnName(2));
			System.out.println("Column #2 Type: " + obj_rsmd.getColumnTypeName(2));
			System.out.println("Column #1 Auto-Increment: " + obj_rsmd.isAutoIncrement(1));
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("ResultSetMetaDataTest... Complete");
		}
		
	}

}
