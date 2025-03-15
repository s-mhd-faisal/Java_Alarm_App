package alarmapp;

import java.util.concurrent.*;

public class AlarmApp {
    private Randommath quiz;
    private Calctime calc;
    private ScheduledExecutorService scheduler;

    public AlarmApp() {
        quiz = new Randommath();
        calc = new Calctime();
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public static void main(String[] args) {
        AlarmApp app = new AlarmApp();
        app.run();
    }

    public void run() {
        int option, op2;
        System.out.println("\tAlarm App");
        while (true) {
            option = ExeptHandling.getInt("Choose an option\n\n1. Set alarm\n2. View alarm\n3. Clear Alarms\n0. Exit",0,3);

            switch (option) {
                case 0:
                	System.out.println("App Closed!!");
                	ExeptHandling.closeScanner();
                    return;
                case 1:
                    setAlarm();
                    break;
                case 2:
                    showAlarm();
                    break;
                case 3:
                    clearAlarms();
                    break;
            }

            op2 = ExeptHandling.getInt("1. Go to main menu\n0. Exit",0,1);
            if (op2 == 0) {
            	System.out.println("App Closed!!");
            	ExeptHandling.closeScanner();
                break;
            }
        }
        return;
    }

    public void setAlarm() {
        String altime;
        long secondsToWait;

        while (true) {
            altime = ExeptHandling.getString("What time should alarm ring (HH:mm):");
            secondsToWait = calc.calcseconds(altime);
            if (secondsToWait >= 0) {
                break;
            }
            System.out.println("Try again!");
        }

        System.out.println("Seconds till alarm: " + secondsToWait);
        final long[] waitTime = {secondsToWait};

        scheduler.schedule(() -> {
        	ExeptHandling.restartScanner();
            System.out.println("It's been " + waitTime[0] + " seconds");
            System.out.println("'Alarm Ringing' Solve the problem to turn off");
            quiz.genmathproblem();
            System.out.println("Alarm Turned off");
            scheduler.shutdown();
        }, waitTime[0], TimeUnit.SECONDS);
    }

    public void showAlarm() {
        FileRead read = new FileRead();
        read.showFile();
    }

    public void clearAlarms() {
        FileWrite write = new FileWrite();
        write.clearFile();
        stopScheduler();
    }

    public void stopScheduler() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
            System.out.println("Active alarm canceled.");
        }
    }
}
