package alarmapp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Randommath {
    private Random random = new Random();

    public void genmathproblem() {
        Scanner scan = new Scanner(System.in);
        String operators[] = {"+", "-", "*", "/"};
        int operand = random.nextInt(4);
        int op1, op2, result = 0;
        int answer = 0;

        // Generate numbers based on the operator
        if (operand == 0 || operand == 1) {
            op1 = random.nextInt(100);
            op2 = random.nextInt(100);
        } else {
            op1 = random.nextInt(100);
            op2 = random.nextInt(10) + 1; // Ensure no division by zero
        }

        while (true) {
            try {
                System.out.printf("%d %s %d = : ", op1, operators[operand], op2);
                answer = scan.nextInt();

                // Calculate the correct result
                switch (operators[operand]) {
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
                        result = op1 / op2;
                        break;
                    default:
                        System.out.println("Error");
                }

                // Check the answer
                if (answer == result) {
                    System.out.println("Correct Answer!");
                    break; // Exit loop when answer is correct
                } else {
                    System.out.println("Wrong! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scan.next(); // Clear invalid input
            } catch (ArithmeticException e) {
                System.out.println("Math error occurred! Regenerating problem.");
                return;
            }
        }
        scan.close();
    }
}
