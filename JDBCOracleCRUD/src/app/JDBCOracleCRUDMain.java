package app;

import obj.Initialization;
import crud.ManageTable;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		System.out.println(args[0]);
		ManageTable table = new ManageTable();
		switch (args[0].toUpperCase()) {
		
			case Initialization._CREATE: {
				break;
			}
			case Initialization._READ:
				break;
			case Initialization._UPDATE:
				break;
			case Initialization._DELETE:
				break;
			case Initialization._SETUP: {
				
				boolean tableExists = table.checkDatabase();
				boolean tableCreated = false;
				if (tableExists == false)
					tableCreated = table.createDatabase();
				if (tableCreated)
					System.out.println("Table " + Initialization._DB_TABLE + " has been created.");
				else
					System.out.println("Table " + Initialization._DB_TABLE + " already exist.");
				break;
				
			}
			case Initialization._DROP: {
				
				boolean databaseDropped = table.dropDatabase();
				if (databaseDropped)
					System.out.println("Table " + Initialization._DB_TABLE + " has been dropped.");
				else
					System.out.println("Table " + Initialization._DB_TABLE + " doesn't exist anymore.");
				break;
				
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + args[0]);
		}
		
	}

}
