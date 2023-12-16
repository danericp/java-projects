package app;

import obj.Initialization;

import crud.ManageFile;
import crud.ManageImage;
import crud.ManageTable;
import org.json.JSONObject;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		System.out.println(args[0]);
		
		switch (args[0].toUpperCase()) {
		
			case Initialization._CREATE: {
				if (ManageFile.isFileExist(Initialization._CREATE)) {
					
					try {
						
						org.json.JSONArray jsonArray = ManageFile.parseFileToJson(Initialization._CREATE);
						for (int i = 0; i < jsonArray.length(); i++) {
							
							JSONObject jsonObject = jsonArray.getJSONObject(i);
			                ManageImage imageManager = new ManageImage();
			                imageManager.addImage(jsonObject.getString("image"), jsonObject.getString("name"), jsonObject.getString("description"));
							
						}
						
					}
					catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
				}
				else
					System.out.println("Cannot create an entry to " + Initialization._DB_TABLE + ". JSON file doesn't exist.");
				break;
				
			}
			case Initialization._READ:
				break;
			case Initialization._UPDATE: {
			
				if (ManageFile.isFileExist(Initialization._UPDATE)) {
					
					try {
						
						org.json.JSONArray jsonArray = ManageFile.parseFileToJson(Initialization._UPDATE);
						for (int i = 0; i < jsonArray.length(); i++) {
							
							JSONObject jsonObject = jsonArray.getJSONObject(i);
			                ManageImage imageManager = new ManageImage();
			                imageManager.updateImage(jsonObject.getString("image"), jsonObject.getString("name"), jsonObject.getString("description"), jsonObject.getInt("id"));
							
						}
						
					}
					catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
				}
				else
					System.out.println("Cannot update an entry to " + Initialization._DB_TABLE + ". JSON file doesn't exist.");
				break;
				
			}
			case Initialization._DELETE: {
				
				if (ManageFile.isFileExist(Initialization._DELETE)) {
					
					try {
						
						org.json.JSONArray jsonArray = ManageFile.parseFileToJson(Initialization._DELETE);
						for (int i = 0; i < jsonArray.length(); i++) {
							
							JSONObject jsonObject = jsonArray.getJSONObject(i);
			                ManageImage imageManager = new ManageImage();
			                imageManager.deleteImage();
							
						}
						
					}
					catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
				}
				else
					System.out.println("Cannot delete an entry to " + Initialization._DB_TABLE + ". JSON file doesn't exist.");
				break;
				
			}
			case Initialization._SETUP: {

				ManageFile.createFile(Initialization._CREATE);
				ManageFile.createFile(Initialization._READ);
				ManageFile.createFile(Initialization._UPDATE);
				ManageFile.createFile(Initialization._DELETE);
				boolean tableExists = ManageTable.checkDatabase();
				boolean tableCreated = false;
				if (tableExists == false)
					tableCreated = ManageTable.createDatabase();
				if (tableCreated)
					System.out.println("Table " + Initialization._DB_TABLE + " has been created.");
				else
					System.out.println("Table " + Initialization._DB_TABLE + " already exist.");
				break;
				
			}
			case Initialization._DROP: {
				
				boolean databaseDropped = ManageTable.dropDatabase();
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
