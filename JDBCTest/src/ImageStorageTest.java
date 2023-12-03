import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageStorageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// INSERT Image
		try {
			System.out.println("ImageStorageTest INSERT");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "player");
			Integer int_n = 0;
			FileInputStream obj_fis = new FileInputStream("C:\\Users\\daner\\Downloads\\huh.jpg");
			PreparedStatement obj_ps = obj_conn.prepareStatement("INSERT INTO imagetest VALUES (?, ?)");
			obj_ps.setString(1, "Huh Cat");
			obj_ps.setBinaryStream(2, obj_fis);
			int_n += obj_ps.executeUpdate();
			System.out.println("Number of rows inserted: " + int_n);
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("ImageStorageTest INSERT... Complete");
		}
		// GET Image
		try {
			System.out.println("ImageStorageTest GET");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection obj_conn = DriverManager.getConnection("jdbc:oracle:thin:@:1521:", "", "");
			Statement obj_st = obj_conn.createStatement();
			ResultSet obj_rs = obj_st.executeQuery("SELECT * FROM imagetest");
			while(obj_rs.next()) {
				Blob obj_b = obj_rs.getBlob(2);
				byte byte_arr[] = obj_b.getBytes(1, (int) obj_b.length());
				FileOutputStream obj_fos = new FileOutputStream("C:\\Users\\daner\\Downloads\\out.jpg");
				obj_fos.write(byte_arr);
				obj_fos.close();
			}
			obj_conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("ImageStorageTest GET... Complete");
		}
		/* CREATE TABLE imagetest (
		 *   image_name VARCHAR2(100),
		 *   image_content BLOB
		 * );
		 */
	}

}
