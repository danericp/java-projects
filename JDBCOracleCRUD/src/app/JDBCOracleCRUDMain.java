package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.json.*;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		final String _CREATE = "CREATE";
		final String _DELETE = "DELETE";
		final String _DROP = "DROP";
		final String _READ = "READ";
		final String _SETUP = "SETUP";
		final String _UPDATE = "UPDATE";
		final String _CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
		final String _PASSWORD = "player";
		final String _USERNAME = "system";
		final String _TABLE = "tb_crud_image";
		
		System.out.println(args[0]);
		
		switch (args[0].toUpperCase()) {
			case _CREATE: {
				break;
			}
			case _DELETE: {
				break;
			}
			case _DROP: {
				try {
					System.out.println("DROP TABLE Statement");
					Connection obj_conn = DriverManager.getConnection(_CONNECTION, _USERNAME, _PASSWORD);
					Statement obj_st = obj_conn.createStatement();
					obj_st.executeUpdate("DROP TABLE " + _TABLE);
					System.out.println("Table dropped.");
					obj_conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					System.out.println("DROP TABLE Statement... Complete");
				}
				break;
			}
			case _READ: {
				break;
			}
			case _SETUP: {
				try {
					System.out.println("CREATE TABLE Statement");
					Connection obj_conn = DriverManager.getConnection(_CONNECTION, _USERNAME, _PASSWORD);
					Statement obj_st = obj_conn.createStatement();
					obj_st.executeUpdate("CREATE TABLE " + _TABLE + " (id int, img_name varchar2(100), img_description varchar2(100), img_type varchar2(10), date_created date )");
					System.out.println("Table created.");
					obj_conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					System.out.println("CREATE TABLE Statement... Complete");
				}
				break;
			}
			case _UPDATE: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + args[0]);
		}
		
//		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
//            StringBuilder jsonString = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) {
//                jsonString.append(line).append("\n");
//            }
//
//            // Parse the JSON string
//            JSONObject jsonObject = new JSONObject(jsonString.toString());
//
//            // Accessing elements in JSON
//            // String name = jsonObject.getString("name");
//            // int age = jsonObject.getInt("age");
//            // String city = jsonObject.getString("city");
//
//            // Printing the values
//            // System.out.println("Name: " + name);
//            // System.out.println("Age: " + age);
//            // System.out.println("City: " + city);
//            System.out.println(jsonObject.getString("property"));
//
//        } catch (IOException | JSONException e) {
//            e.printStackTrace();
//        }
		
	}

}