import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class JDBCCallableStatement {
	public static void main(String[] args) {
		// SELECT PreparedStatement
		try {
			System.out.println("Calling Stored Procedure");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			Integer int_n = 0;
			CallableStatement obj_stmt = obj_conn.prepareCall("{call insertEmployi(?, ?, ?)}");
			obj_stmt.setInt(1, 110);
			obj_stmt.setString(2, "Ichigoat");
			obj_stmt.setInt(3, 9999);
			int_n += obj_stmt.executeUpdate();
			System.out.println("Number of rows affected: " + int_n);
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Calling Stored Procedure... Complete");
		}
		// SELECT PreparedStatement
		try {
			System.out.println("Calling Stored Procedure");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "player");
			CallableStatement obj_stmt = obj_conn.prepareCall("{call getEmployiByName(?, ?, ?)}");
			obj_stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			obj_stmt.setString(2, "Goku");
			obj_stmt.registerOutParameter(3, java.sql.Types.INTEGER);
			obj_stmt.executeUpdate();
			System.out.println("ID: " + obj_stmt.getString(1) + " Salary: " + obj_stmt.getInt(3));
			obj_conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Calling Stored Procedure... Complete");
		}
		/*
		 * CREATE OR REPLACE PROCEDURE insertEmployi (
		 *   eid IN NUMBER,
		 *   ename IN VARCHAR2,
		 * 	 esal IN NUMBER
		 * )
		 * IS
		 * BEGIN
		 * INSERT INTO employi VALUES (eid, ename, esal);
		 * END;
		 * /
		 * 
		 * CREATE OR REPLACE PROCEDURE getEmployiByName (
		 *   eid OUT employi.emp_id%TYPE,
		 * 	 ename IN employi.emp_name%TYPE,
		 * 	 esal OUT employi.emp_salary%TYPE
		 * )
		 * IS
		 * BEGIN
		 *   SELECT emp_id, emp_salary
		 *   INTO eid, esal
		 *   FROM employi
		 *   WHERE emp_name = ename;
		 * END;
		 * /
		 * 
		 */
	}
}