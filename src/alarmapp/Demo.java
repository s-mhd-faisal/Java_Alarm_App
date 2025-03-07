package alarmapp;

import java.util.Scanner;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Randommath quiz = new Randommath(); 
        String altime;
        Calctime calc = new Calctime(scan);
        long seconds_to_wait;

        while (true) {
            System.out.println("What time should alarm ring (HH:mm) :");
            altime = scan.nextLine();
            seconds_to_wait = calc.calcseconds(altime);
            if (seconds_to_wait >= 0) {
                break;
            }
            System.out.println("Try again!");
        }

        System.out.println("Seconds till alarm: " + seconds_to_wait);
        final long[] waitTime = {seconds_to_wait};
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            System.out.println("It's been " + waitTime[0] + " seconds");
            System.out.println("'Alarm Ringing' Solve the problem to turn off");
            quiz.genmathproblem();
            System.out.println("Alarm Turned off");
            scheduler.shutdown();
        }, waitTime[0], TimeUnit.SECONDS);

        scan.close();
    }
}
