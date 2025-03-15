package alarmapp;

import java.time.*;
import java.time.format.*;

public class Calctime {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private final FileWrite write;

    public Calctime() {
        write = new FileWrite();
    }

    public long calcseconds(String unFormTime) {
        try {
            LocalTime nowTime = LocalTime.now();
            LocalTime alarmTime = LocalTime.parse(unFormTime, FORMATTER); // May throw DateTimeParseException

            long secondsToWait = Duration.between(nowTime, alarmTime).getSeconds();

            // If the time is for the next day, adjust by adding 24 hours
            if (secondsToWait < 0) {
                secondsToWait += 86400; // 24 hours in seconds
            }

            write.writeFile(unFormTime);
            return secondsToWait;

        } catch (DateTimeParseException e) {  // Catch invalid time input
            System.out.println("Invalid time format! Please enter in HH:mm (24-hour) format.");
            return -1; // Indicate an error so the user can try again
        }
    }
}
