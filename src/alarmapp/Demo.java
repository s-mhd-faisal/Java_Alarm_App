package alarmapp;

import java.util.Scanner;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Randommath quiz = new Randommath(scan); 
        String altime;
        Calctime calc = new Calctime();
        long secondsToWait;

        while (true) {
            System.out.println("What time should alarm ring (HH:mm) :");
            altime = scan.nextLine();
            secondsToWait = calc.calcseconds(altime);
            if (secondsToWait >= 0) {
                break;
            }
            System.out.println("Try again!");
        }
        System.out.println("Seconds till alarm "+ secondsToWait);
        final long[] waitTime = {secondsToWait};
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            System.out.println("It's been " + waitTime[0] + " seconds");
            System.out.println("'Alarm Ringing' Solve the problem to turn off");
            quiz.genmathproblem();
            System.out.println("Alarm Turned off");
            scheduler.shutdown();
            scan.close();

        }, 5, TimeUnit.SECONDS);

    }
}
