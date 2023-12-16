package crud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import obj.Initialization;

public class ManageFile {
	
	public static void createFile (String fileNameUpper) {
		
		FileWriter writer = null;
		String fileName = null;
		String fileContent = null;
		switch (fileNameUpper) {
			
			case Initialization._CREATE: {
				
				fileName = getFileName(Initialization._CREATE);
				fileContent = Initialization._JSON_CREATE;
				break;
				
			}
			case Initialization._READ: {
				
				fileName = getFileName(Initialization._READ);
				fileContent = Initialization._JSON_READ;
				break;
				
			}
			case Initialization._UPDATE: {
				
				fileName = getFileName(Initialization._UPDATE);
				fileContent = Initialization._JSON_UPDATE;
				break;
				
			}
			case Initialization._DELETE: {
				
				fileName = getFileName(Initialization._DELETE);
				fileContent = Initialization._JSON_DELETE;
				break;
				
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + fileNameUpper);
			
		}
		try {
			
			writer = new FileWriter(fileName);
			writer.write(fileContent);
			writer.close();
			System.out.println("File '" + fileName + "' created successfully!");
			
		}
		catch (IOException e) {
			
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public static String getFileExtension(String path) {
        Path p = Paths.get(path);
        String fileExtension = null;
        if (p != null) {
            String fileName = p.getFileName().toString();
            int lastDotIndex = fileName.lastIndexOf('.');
            if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
                fileExtension = fileName.substring(lastDotIndex + 1);
            }
        }
        return fileExtension;
    }
	
	public static String getFileName (String fileNameUpper) {
		
		return fileNameUpper.toLowerCase() + ".json";
		
	}
	
	public static boolean isFileExist (String fileNameUpper) {
		
		return (new File(getFileName(fileNameUpper))).exists();
		
	}
	
	public static org.json.JSONArray parseFileToJson (String fileNameUpper) {
		
		StringBuilder jsonContent = new StringBuilder();
		File file = new File(ManageFile.getFileName(fileNameUpper));
		try {
			
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
				jsonContent.append(scanner.nextLine());
			scanner.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return (new org.json.JSONArray(jsonContent.toString()));
		
	}

}
