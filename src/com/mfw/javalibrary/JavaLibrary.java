package com.mfw.javalibrary;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class JavaLibrary {
    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    public static String readOptionString(String[] possibleChoices) {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            result = readString();

            if (!Arrays.asList(possibleChoices).contains(result.toLowerCase())) {
                System.err.println("Invalid input!");
                System.out.print("Try again: ");
            } else {
                isValid = true;
            }
        }

        return result;
    }

    /**
     * Reads user input and checks if the input matches the given regex.
     * @param regex defines what is allowed as input
     * @return the user input
     */
    public static String readOptionString(String regex) {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            result = readString();

            if (isInvalidString(regex, result)) {
                System.err.println("Invalid input! Input does not match the allowed ruleset.");
                System.out.print("Try again: ");
            } else {
                isValid = true;
            }
        }

        return result;
    }

    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    public static int readOptionInt(Integer[] possibleChoices) {
        boolean isValid = false;
        int result = -1;

        while (!isValid) {
            result = readInt();

            if (!Arrays.asList(possibleChoices).contains(result)) {
                System.err.println("Invalid input! Not in a valid choice.");
                System.out.print("Try again: ");
            } else {
                isValid = true;
            }
        }

        return result;
    }

    /**
     * Reads user input as String.
     * @return the user input
     */
    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Reads user input as int.
     * @return the user input
     */
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        int result = -1;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                break;
            } else {
                scanner.next();
                System.err.println("Invalid Input! Not a number.");
                System.out.print("Try again: ");
            }
        }

        return result;
    }

    /**
     * Clears run console for either Windows or Linux.
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // Clear console for Linux using an ANSI escape code
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        System.out.flush();
    }

    /**
     * Pauses run console.
     */
    public static void pauseConsole() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static boolean isInvalidString(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);

        if (string == null) {
            return true;
        }

        Matcher matcher = pattern.matcher(string);

        return !matcher.matches();
    }
}
