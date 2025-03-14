package alarmapp;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Demo {
	private Scanner scan;
	private Randommath  quiz;
	private Calctime calc;
	private ScheduledExecutorService scheduler;

	
	public Demo(){
		scan = new Scanner(System.in);
		quiz = new Randommath(scan);
		calc = new Calctime();
        scheduler = Executors.newSingleThreadScheduledExecutor();

	}
	
	
    
    public static void main(String[] args) {
    	
    	Demo app = new Demo();
    	app.run();
    }
    
    public void run() {
		// TODO Auto-generated method stub
    	int option;
        System.out.println("\tAlarm App");
    	while(true) {
    		System.out.println("choose an option\n\n1. Set alarm\n2. View alarm\n3. Clear Alarms\n0. Exit");
        
    		try {
	        	option = scan.nextInt();
	        	scan.nextLine();
	        	
	        	if(option==0) {
	        		return;
	        	}
	        	else if(option<1 || option>3) {
	        		System.out.println("Enter a Valid number");
	        		continue;
	        	}
	        	switch(option){
	            
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
	        	
	        System.out.println("1. Go to main menu\n0. Exit");
	        try {
	        	int op2 = scan.nextInt();
	        	scan.nextLine();
	 	        if(op2==1) {
	 	        	continue;
	 	        }
	 	        else if(op2==0) {
	 	        	return;
	 	        }
	        }catch(InputMismatchException e) {
	        	continue;
	        }
	       
	        		
	       
        }
        catch(InputMismatchException e) {
        	
        	System.out.println("Enter a valid Number");
        	scan.nextLine();
        }
    	}
	}
 
    public void setAlarm() {
    	
        String altime;
        
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
        scheduler.schedule(() -> {
            System.out.println("It's been " + waitTime[0] + " seconds");
            System.out.println("'Alarm Ringing' Solve the problem to turn off");
            quiz.genmathproblem();
            System.out.println("Alarm Turned off");
            scheduler.shutdown();
            scan.close();

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
            scheduler.shutdownNow();  // Stops the scheduler immediately
            System.out.println("Active alarm canceled.");
        }
    }

}
