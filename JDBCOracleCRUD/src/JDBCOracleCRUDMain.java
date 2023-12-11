
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		final String _CREATE = "CREATE";
		final String _DELETE = "DELETE";
		final String _READ = "READ";
		final String _SETUP = "SETUP";
		final String _UPDATE = "UPDATE";
		
		System.out.println(args[0]);
		
		switch (args[0].toUpperCase()) {
			case _SETUP: {
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
