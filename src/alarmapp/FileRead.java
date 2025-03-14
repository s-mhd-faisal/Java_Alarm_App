package alarmapp;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;

public class FileRead {
	

	public void showFile() {
		// TODO Auto-generated method stub
		File file = new File("files/alarmfile.txt");
		
		if(!file.exists()) {
			System.out.println("No saved alarm found");
			return;
		}
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			String firstline = reader.readLine();
			if(firstline==null) {
				System.out.println("No saved Alarms");
				return;
			}
			String line;
			System.out.println("Saved Alarms:");
			System.out.println(firstline);
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		}
		catch(IOException e) {
			System.out.println("Error Reading File");
			e.printStackTrace();
		}
	}
		
		
		
}

