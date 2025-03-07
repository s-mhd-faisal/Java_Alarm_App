package alarmapp;

import java.time.*;
import java.time.format.*;
import java.util.Scanner;

public class Calctime {
    private Scanner scan;
    private LocalTime now_time, alarmtime;
    private DateTimeFormatter formatter;
    private long seconds_to_wait;

    public Calctime(Scanner scan) {
        this.scan = scan;
    }

    public long calcseconds(String u_time) {
        now_time = LocalTime.now();
        formatter = DateTimeFormatter.ofPattern("HH:mm");
        alarmtime = LocalTime.parse(u_time, formatter);
        seconds_to_wait = Duration.between(now_time, alarmtime).getSeconds();
        
        // Adjust if the time is for the next day
        if (seconds_to_wait < 0) {
            seconds_to_wait += 86400; // 24 hours in seconds
        }

        System.out.println("Time now: " + now_time);
        System.out.println("The time you said: " + alarmtime);
        System.out.println("Seconds till alarm: " + seconds_to_wait);
        return seconds_to_wait;
    }
}
