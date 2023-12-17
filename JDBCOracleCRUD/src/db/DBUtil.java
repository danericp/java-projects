package db;

import java.sql.Connection;
import java.sql.DriverManager;

import obj.Initialization;

public class DBUtil {

	public static Connection getConnection() {

		Connection conn = null;
		try {

			Class.forName(Initialization._DRIVER);
			conn = DriverManager.getConnection(Initialization._CONNECTION, Initialization._USERNAME, Initialization._PASSWORD);

		}
		catch(Exception e) {

			e.printStackTrace();

		}
		return conn;

	}

	public static void closeConnection(Connection conn) {

		try {

			conn.close();

		}
		catch (Exception e) {

			e.printStackTrace();

		}

	}

}
