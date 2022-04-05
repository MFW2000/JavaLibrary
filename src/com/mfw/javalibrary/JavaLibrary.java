package com.mfw.javalibrary;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class JavaLibrary {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Test: ");
        int i = readOptionInt();

        System.out.print(i);
    }

    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    public static String readOptionString(String[] possibleChoices) {
        boolean isValid = false;
        String result = "";

        while (!isValid) {
            result = scanner.nextLine();

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
            result = scanner.nextLine();

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
            readOptionInt();

            if (!Arrays.asList(possibleChoices).contains(result)) {
                System.err.println("Invalid input!");
                System.out.print("Try again: ");
            } else {
                isValid = true;
            }
        }

        return result;
    }

    /**
     * Reads user input and checks if the input is valid.
     * @return the user input
     */
    public static int readOptionInt() {
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
     * Clears run console
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pauses run console
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
