package app;

import obj.Initialization;
import crud.ManageTable;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		System.out.println(args[0]);
		ManageTable table = new ManageTable();
		switch (args[0].toUpperCase()) {
		
			case Initialization._CREATE: {
				boolean tableExists = table.checkDatabase();
				boolean tableCreate = true;
				if (tableExists == false)
					tableCreate = table.createDatabase();
				if (tableCreate)
					System.out.println("Table " + Initialization._DB_TABLE + " has been created.");
				else
					System.out.println("Table " + Initialization._DB_TABLE + " has failed to be created. (Error Code: " + tableCreate + ")");
					
				break;
			}
			case Initialization._READ:
				break;
			
			case Initialization._UPDATE:
				break;
			
			case Initialization._DELETE:
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + args[0]);
		}
		
	}

}
