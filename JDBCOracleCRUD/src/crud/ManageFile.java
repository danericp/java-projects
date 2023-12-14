package crud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import obj.Initialization;

public class ManageFile {
	
	public static void createFile (String fileNameUpper) {
		
		switch (fileNameUpper) {
			
			case Initialization._CREATE: {
				
				String fileName = fileNameUpper.toLowerCase() + ".json";
				try {
					
					FileWriter writer = new FileWriter(fileName);
					writer.write(Initialization._JSON_CREATE);
					writer.close();
					System.out.println("File '" + fileName + "' created successfully!");
					
				}
				catch (IOException e) {
					
					System.out.println("An error occurred: " + e.getMessage());
					e.printStackTrace();
					
				}
				break;
				
			}
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + fileNameUpper);
		}
		
	}
	
	public static void checkFile (String fileNameUpper) {
		
		String fileName = fileNameUpper.toLowerCase() + ".json";
		if ((new File(fileName)).exists() == false)
			ManageFile.createFile(fileNameUpper);
		else
			System.out.println("File '" + fileName + "' exists.");
		
	}

}
