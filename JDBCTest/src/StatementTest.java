import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StatementTest {
	public static void main(String[] args) {
		String str_tb = "employi";
		// SELECT Statement
		try {
			System.out.println("SELECT Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			ResultSet obj_rs = obj_st.executeQuery("SELECT * FROM " + str_tb);
			// JDBC Indexing starts at 1
			while(obj_rs.next()) {
				System.out.println("ID: " + obj_rs.getInt("EMP_ID") + " Table: " + obj_rs.getString("EMP_NAME") + " Salary: " + obj_rs.getInt("EMP_SALARY"));
			}
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("SELECT Statement... Complete");
		}
		// DROP TABLE Statement
		try {
			System.out.println("DROP TABLE Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			obj_st.executeUpdate("DROP TABLE " + str_tb);
			System.out.println("Table dropped.");
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("DROP TABLE Statement... Complete");
		}
		// CREATE TABLE Statement
		try {
			System.out.println("CREATE TABLE Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			obj_st.executeUpdate("CREATE TABLE " + str_tb + "(emp_id int, emp_name varchar2(30), emp_salary int)");
			System.out.println("Table created.");
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("CREATE TABLE Statement... Complete");
		}
		// INSERT Statement
		try {
			System.out.println("INSERT Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			Integer int_n = 0;
			int_n += obj_st.executeUpdate("INSERT INTO " + str_tb + " VALUES (101, 'Henry Sy', 1000)");
			int_n += obj_st.executeUpdate("INSERT INTO " + str_tb + " VALUES (102, 'Daniel Radcliffe', 1000)");
			int_n += obj_st.executeUpdate("INSERT INTO " + str_tb + " VALUES (103, 'Vegeta', 9001)");
			int_n += obj_st.executeUpdate("INSERT INTO " + str_tb + " VALUES (104, 'Goku', 10000)");
			System.out.println(int_n + " row/s inserted to the table.");
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("INSERT Statement... Complete");
		}
		// UPDATE Statement
		try {
			System.out.println("UPDATE Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			Integer int_n = obj_st.executeUpdate("UPDATE " + str_tb + " SET emp_salary = 69 WHERE emp_name IN ('Goku', 'Vegeta')");
			System.out.println(int_n + " row/s updated to the table.");
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("UPDATE Statement... Complete");
		}
		// DELETE Statement
		try {
			System.out.println("DELETE Statement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			Integer int_n = obj_st.executeUpdate("DELETE FROM " + str_tb + " WHERE emp_name = 'Henry Sy'");
			System.out.println(int_n + " row/s deleted.");
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("DELETE Statement... Complete");
		}
	}
}