package alarmapp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Randommath {
	private final Random random = new Random();
    private Scanner scan;
    private AlarmSoundPlayer player;
    
    public Randommath(Scanner scan) {
		// TODO Auto-generated constructor stub
    	this.scan=scan;
    	player = new AlarmSoundPlayer();

	}

    public void genmathproblem() {
    	final String operators[] = {"+", "-", "*", "/"};
    	int op1, op2,operator, result = 0,answer = 0;
        operator = random.nextInt(4);
    	
       // Generate numbers based on the operator
        if (operator == 0 || operator == 1) {
            op1 = random.nextInt(100);
            op2 = random.nextInt(100);
        } else {
            op1 = random.nextInt(100)+1;
            op2 = random.nextInt(10)+1;
        }
        player.playSound();
        while (true) {
            try {
                System.out.printf("%d %s %d = : ", op1, operators[operator], op2);
                answer = scan.nextInt();

                // Calculate the correct result
                switch (operators[operator]) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                    	if(op1<op2) {
                    		int temp = op1;
                    		op1 = op2;
                    		op2 = temp;
                    	}
                    	result = op1/op2;
                        break;
                    default:
                        System.out.println("Error");
                }

                // Check the answer
                if (answer == result) {
                    System.out.println("Correct Answer!");
                    player.stopSound();
                    break; // Exit loop when answer is correct
                } else {
                    System.out.println("Wrong! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scan.next(); // Clear invalid input
            } 
            
        }
    }
}
