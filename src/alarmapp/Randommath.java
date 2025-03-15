package alarmapp;

import java.util.Random;

public class Randommath {
    private final Random random = new Random();
    private final AlarmSoundPlayer player;

    public Randommath() {
        player = new AlarmSoundPlayer();
    }

    public void genmathproblem() {
        final String[] operators = {"+", "-", "*", "/"};
        int op1, op2, operator, result = 0, answer;

        while (true) {
            operator = random.nextInt(4);

            // Generate numbers based on the operator
            if (operator == 0 || operator == 1) { // Addition & Subtraction
                op1 = random.nextInt(100);
                op2 = random.nextInt(100);
            } else { // Multiplication & Division
                op1 = random.nextInt(100) + 1;
                op2 = random.nextInt(10) + 1;
            }

            // Swap for division to ensure op1 > op2
            if (operator == 3 && op1 < op2) {
                int temp = op1;
                op1 = op2;
                op2 = temp;
            }

            // Calculate correct answer
            switch (operators[operator]) {
                case "+" -> result = op1 + op2;
                case "-" -> result = op1 - op2;
                case "*" -> result = op1 * op2;
                case "/" -> result = op1 / op2;
            }

            // Play alarm sound
            player.playSound();

            // Ask user to solve the problem
            String question = String.format("%d %s %d = : ", op1, operators[operator], op2);

            while (true) {
                answer = ExeptHandling.getInt(question);

                if (answer == result) {
                    System.out.println("Correct Answer!");
                    player.stopSound();
                    return; // Exit the method when the answer is correct
                } else {
                    System.out.println("Wrong! Try again.");
                }
            }
        }
    }
}
