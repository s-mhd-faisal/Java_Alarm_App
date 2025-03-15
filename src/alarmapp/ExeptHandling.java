package alarmapp;

import java.util.Scanner;

public final class ExeptHandling {
    private static Scanner scan = new Scanner(System.in);

    private ExeptHandling() {
        // Private constructor to prevent instantiation
    }

    public static int getInt(String mes) {
        while (true) {
            try {
                System.out.print(mes + " ");
                String str = scan.nextLine().trim();
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    public static double getDouble(String mes) {
        while (true) {
            try {
                System.out.print(mes + " ");
                String str = scan.nextLine().trim();
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid double.");
            }
        }
    }

    public static float getFloat(String mes) {
        while (true) {
            try {
                System.out.print(mes + " ");
                String str = scan.nextLine().trim();
                return Float.parseFloat(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid float.");
            }
        }
    }

    public static String getString(String mes) {
        while (true) {
            System.out.print(mes + " ");
            String str = scan.nextLine().trim();
            if (!str.isEmpty()) {
                return str;
            }
            System.out.println("Input cannot be empty! Please enter a valid string.");
        }
    }

    public static boolean getBoolean(String mes) {
        while (true) {
            System.out.print(mes + " (yes/no) ");
            String str = scan.nextLine().trim().toLowerCase();
            if (str.equals("yes") || str.equals("y")) {
                return true;
            } else if (str.equals("no") || str.equals("n")) {
                return false;
            }
            System.out.println("Invalid input! Please enter 'yes' or 'no'.");
        }
    }

    public static char getChar(String mes) {
        while (true) {
            System.out.print(mes + " ");
            String str = scan.nextLine().trim();
            if (str.length() == 1) {
                return str.charAt(0);
            }
            System.out.println("Invalid input! Please enter a single character.");
        }
    }
    public static int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                String str = scan.nextLine().trim();
                int num = Integer.parseInt(str);
                
                if (num < min || num > max) {
                    System.out.println("Invalid input! Please enter a number between " + min + " and " + max);
                    continue;  // Ask for input again
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
    public static void closeScanner() {
        if (scan != null) {
            scan.close();
            scan = null; // Prevent further input
        }
    }

    public static void restartScanner() {
        if (scan == null) {
            scan = new Scanner(System.in); // Reopen scanner for alarm input
        }
    }
}


