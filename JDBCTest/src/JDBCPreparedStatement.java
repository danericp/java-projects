import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class JDBCPreparedStatement {
	public static void main(String[] args) {
		String str_tb = "employi";
		// SELECT PreparedStatement
		try {
			System.out.println("INSERT PreparedStatement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			Integer int_n = 0;
			PreparedStatement obj_ps = obj_conn.prepareStatement("INSERT INTO " + str_tb + " VALUES (?, ?, ?)");
			// JDBC indexing starts at 1
			// Sets value in index 1
			obj_ps.setInt(1, 106);
			// Sets value in index 2
			obj_ps.setString(2, "Power Ranger Blue");
			// Sets value in index 3
			obj_ps.setInt(3, 100);
			int_n += obj_ps.executeUpdate();
			System.out.println("Number of rows inserted: " + int_n);
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("INSERT PreparedStatement... Complete");
		}
		// UPDATE PreparedStatement
		try {
			System.out.println("UPDATE PreparedStatement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			Integer int_n = 0;
			PreparedStatement obj_ps = obj_conn.prepareStatement("UPDATE " + str_tb + " SET emp_salary = ? WHERE emp_name = ?");
			// JDBC indexing starts at 1
			// Sets value in index 1
			obj_ps.setInt(1, 5000);
			// Sets value in index 2
			obj_ps.setString(2, "Vegeta");
			int_n += obj_ps.executeUpdate();
			System.out.println("Number of rows updated: " + int_n);
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("UPDATE PreparedStatement... Complete");
		}
		// DELETE PreparedStatement
		try {
			System.out.println("DELETE PreparedStatement");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			Integer int_n = 0;
			PreparedStatement obj_ps = obj_conn.prepareStatement("DELETE FROM " + str_tb + " WHERE emp_name = ?");
			// JDBC indexing starts at 1
			// Sets value in index 1
			obj_ps.setString(1, "Vegeta");
			int_n += obj_ps.executeUpdate();
			System.out.println("Number of rows deleted: " + int_n);
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("DELETE PreparedStatement... Complete");
		}
	}
}