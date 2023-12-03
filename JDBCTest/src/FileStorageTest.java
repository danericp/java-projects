import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FileStorageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// INSERT File
		try {
			System.out.println("FileStorageTest INSERT");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			File obj_file = new File("C:\\Users\\daner\\Downloads\\huh.txt");
			FileReader obj_fr = new FileReader(obj_file);
			Integer int_n = 0;
			PreparedStatement obj_ps = obj_conn.prepareStatement("INSERT INTO filetest VALUES (?, ?)");
			obj_ps.setString(1, "huh");
			obj_ps.setCharacterStream(2, obj_fr, obj_file.length());
			int_n += obj_ps.executeUpdate();
			System.out.println("Number of files inserted: " + int_n);
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("FileStorageTest INSERT... Complete");
		}
		// SELECT File
		try {
			System.out.println("FileStorageTest SELECT");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Statement obj_st = obj_conn.createStatement();
			ResultSet obj_rs = obj_st.executeQuery("SELECT * FROM filetest WHERE rownum = 1");
			while(obj_rs.next()) {
				Clob obj_c = obj_rs.getClob(2);
				BufferedReader obj_br = new BufferedReader(obj_c.getCharacterStream());
				String str_line = obj_br.readLine();
				while(str_line != null) {
					System.out.println(str_line);
					str_line = obj_br.readLine();
				}
			}
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("FileStorageTest SELECT... Complete");
		}
		/* CREATE TABLE filetest (
		 *   file_name VARCHAR2(100),
		 *   file_content CLOB
		 * );
		 */
	}

}
