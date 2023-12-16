package app;

import obj.Initialization;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.JSONArray;

import crud.ManageFile;
import crud.ManageImage;
import crud.ManageTable;

public class JDBCOracleCRUDMain {

	public static void main(String[] args) {

		System.out.println(args[0]);
		
		switch (args[0].toUpperCase()) {
		
			case Initialization._CREATE: {
				if (ManageFile.isFileExist(Initialization._CREATE)) {
					
					try {
						
						File file = new File(ManageFile.getFileName(Initialization._CREATE));
						Scanner scanner = new Scanner(file);
						StringBuilder jsonContent = new StringBuilder();
						while (scanner.hasNextLine())
							jsonContent.append(scanner.nextLine());
						scanner.close();
						org.json.JSONArray jsonArray = new org.json.JSONArray(jsonContent.toString());
						for (int i = 0; i < jsonArray.length(); i++) {
							
							JSONObject jsonObject = jsonArray.getJSONObject(i);
			                String image = jsonObject.getString("image");
			                String name = jsonObject.getString("name");
			                String description = jsonObject.getString("description");
			                System.out.println("FOUND ONE image: " + image + ", name: " + name + ", description: " + description);
			                ManageImage imageManager = new ManageImage();
			                imageManager.addImage(image, name, description);
							
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
			case Initialization._UPDATE:
				break;
			case Initialization._DELETE:
				break;
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
