package crud;

import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import db.DBUtil;
import obj.ImageObject;

public class ManageImage {
	
	public List<ImageObject> getAllImages() {
		
		List<ImageObject> imageList = new ArrayList<ImageObject>();
		try {
			
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("");
			while(rs.next()) {
				
				ImageObject image = new ImageObject(rs.getInt("id"), rs.getString("img_name"), rs.getString("img_description"), rs.getString("img_type"), rs.getDate("date_created"));
				imageList.add(image);
				
			}
			DBUtil.closeConnection(conn);
			
		}
		catch (Exception e) {

			e.printStackTrace();
			
		}
		return imageList;
		
	}
	public ImageObject getImageObjectById(Integer imageId) {
		
		ImageObject image = null;
		try {
			
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tb_crud_image WHERE id = ?");
			ps.setInt(1, imageId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				image = new ImageObject(rs.getInt("id"), rs.getString("img_name"), rs.getString("img_description"), rs.getString("img_type"), rs.getDate("date_created"));
			}
			
		}
		catch (Exception e) {

			e.printStackTrace();
			
		}
		return image;
		
	}
	public Integer addImage(ImageObject image) {
		
		Integer status = 0;
		try {
			
			Calendar calendar = Calendar.getInstance();
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO tb_crud_image VALUES (?, ?, ?, NOW())");
			FileInputStream obj_fis = new FileInputStream("C:\\Users\\daner\\Downloads\\huh.jpg");
			ps.setString(1, null);
			ps.setString(2, null);
			ps.setString(3, null);
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return status;
		
		
		
		
		
		
		
		
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
		
		
	}

}
