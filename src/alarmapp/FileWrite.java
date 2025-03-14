package alarmapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	private File file;
	
	public FileWrite() {
		// TODO Auto-generated constructor stub
		file = new File("files/alarmfile.txt");
	}
	public void writeFile(String alarmtime) {
		try {
		file.getParentFile().mkdirs();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		writer.write("alarm.time="+alarmtime);
		writer.newLine();
		writer.close();	
		System.out.println("Alarm saved successfully");	
		}
		catch(IOException e){		
			System.out.println("Error Writing to the File");
			e.printStackTrace();	
		}
	}
	
	public void clearFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(""); // Overwrites the file with an empty string
			System.out.println("Alarm file cleared successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
}
		
		

