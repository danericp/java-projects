package crud;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import obj.ImageObject;
import obj.Initialization;

public class ManageImage {
	
	public List<ImageObject> getAllImages() {
		
		List<ImageObject> imageList = new ArrayList<ImageObject>();
		try {
			
			Class.forName(Initialization._DRIVER);
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("");
			while(rs.next()) {
				
				ImageObject image = new ImageObject(
					rs.getInt(Initialization._DB_TABLE_COL1_N_ID),
					rs.getBlob(Initialization._DB_TABLE_COL2_N_CONTENT),
					rs.getString(Initialization._DB_TABLE_COL3_N_NAME),
					rs.getString(Initialization._DB_TABLE_COL4_N_DESC),
					rs.getString(Initialization._DB_TABLE_COL5_N_TYPE),
					rs.getDate(Initialization._DB_TABLE_COL6_N_CREATED)
				);
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
			
			Class.forName(Initialization._DRIVER);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + Initialization._DB_TABLE + " WHERE id = ?");
			ps.setInt(1, imageId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				image = new ImageObject(
					rs.getInt(Initialization._DB_TABLE_COL1_N_ID),
					rs.getBlob(Initialization._DB_TABLE_COL2_N_CONTENT),
					rs.getString(Initialization._DB_TABLE_COL3_N_NAME),
					rs.getString(Initialization._DB_TABLE_COL4_N_DESC),
					rs.getString(Initialization._DB_TABLE_COL5_N_TYPE),
					rs.getDate(Initialization._DB_TABLE_COL6_N_CREATED)
				);

			}
			DBUtil.closeConnection(conn);
			
		}
		catch (Exception e) {

			e.printStackTrace();
			
		}
		return image;
		
	}
	public Integer addImage(String imageLocation, String imageName, String imageDesc) {
		
		Integer status = 0;
		try {
			
			Class.forName(Initialization._DRIVER);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO " + Initialization._DB_TABLE + " VALUES (" + Initialization._DB_SEQ + ".nextval, ?, ?, ?, ?, SYSDATE)");
			FileInputStream obj_fis = new FileInputStream(imageLocation);
			ps.setBinaryStream(1, obj_fis);
			ps.setString(2, imageName);
			ps.setString(3, imageDesc);
			ps.setString(4, ManageFile.getFileExtension(imageLocation));
			status = ps.executeUpdate();
			DBUtil.closeConnection(conn);
			System.out.println("Inserted name: " + imageName + ", description: " + imageDesc);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return status;
		
	}
	public Integer updateImage(String imageLocation, String imageName, String imageDesc, Integer imageId) {
		
		Integer status = 0;
		try {
			
			Class.forName(Initialization._DRIVER);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE " + Initialization._DB_TABLE + " " +
					"SET " +
					Initialization._DB_TABLE_COL2_N_CONTENT + "=?, " +
					Initialization._DB_TABLE_COL3_N_NAME + "=?, " +
					Initialization._DB_TABLE_COL4_N_DESC + "=?, " +
					Initialization._DB_TABLE_COL5_N_TYPE + "=? " +
					"WHERE " + Initialization._DB_TABLE_COL1_N_ID + "=?");
			FileInputStream obj_fis = new FileInputStream(imageLocation);
			ps.setBinaryStream(1, obj_fis);
			ps.setString(2, imageName);
			ps.setString(3, imageDesc);
			ps.setString(4, ManageFile.getFileExtension(imageLocation));
			ps.setInt(5, imageId);
			status = ps.executeUpdate();
			DBUtil.closeConnection(conn);
			if (status != 0)
				System.out.println("Updated name: " + imageName + ", description: " + imageDesc);
			else
				System.out.println("Update failed for name: " + imageName + ", description: " + imageDesc);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return status;
		
	}

}
