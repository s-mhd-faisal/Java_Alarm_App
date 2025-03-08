package alarmapp;

import java.time.*;
import java.time.format.*;
import java.util.Scanner;

public class Calctime {
    private Scanner scan;
    private LocalTime nowTime, alarmTime;
    private DateTimeFormatter formatter;
    private long secondsToWait;

    public Calctime(Scanner scan) {
        this.scan = scan;
    }

    public long calcseconds(String unFormTime) {
    	
    
    	nowTime = LocalTime.now();
        formatter = DateTimeFormatter.ofPattern("HH:mm");
    	
    	try {

            alarmTime = LocalTime.parse(unFormTime, formatter);  // May throw DateTimeParseException
            secondsToWait = Duration.between(nowTime, alarmTime).getSeconds();
            
            // Adjust if the time is for the next day
        if (secondsToWait < 0) {
            secondsToWait += 86400; // 24 hours in seconds
        }
    	
    	}catch (DateTimeParseException e) {  // Catch invalid time input
            System.out.println("Invalid time format! Please enter in HH:mm (24-hour) format.");
            return -1; // Indicate an error so the user can try again
        }

        return secondsToWait;
    }
}
