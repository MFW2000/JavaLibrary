package com.mfw.javalibrary;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IO {
    /**
     * Reads user input as string.
     * @return the user input
     */
    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Reads user input as string and checks if the input matches the given regex.
     * @param regex the regex that defines what is allowed as input
     * @return the user input
     */
    public static String readString(String regex) {
        while (true) {
            String result = readString();

            if (isInvalidStringByRegex(regex, result)) {
                System.err.println("Invalid input, does not match the allowed ruleset.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Reads user input as int and checks if the input is in the given array of options.
     * @param possibleOptions array of possible options
     * @return the user input
     */
    public static String readString(String[] possibleOptions) {
        while (true) {
            String result = readString();

            if (Arrays.asList(possibleOptions).contains(result.toLowerCase())) {
                return result;
            } else {
                System.err.println("Invalid input, does not match any known option.");
                System.out.print("Try again: ");
            }
        }
    }

    /**
     * Reads user input as string where extra whitespaces are not allowed.
     * @return the user input
     */
    public static String readValidString() {
        while (true) {
            String result = readString();

            if (isNullOrWhitespace(result)) {
                System.err.println("Invalid input, may not be empty.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Reads user input as char.
     * @return the user input
     */
    public static char readChar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String result = scanner.next();

            if (isInvalidChar(result)) {
                System.err.println("Invalid input, not a single character.");
                System.out.print("Try again: ");
            } else {
                return result.charAt(0);
            }
        }
    }

    /**
     * Reads user input as char and automatically converts the given char to either uppercase or lowercase.
     * @param uppercase flag to allow uppercase
     * @return the user input
     */
    public static char readChar(boolean uppercase) {
        char result = readChar();
        return setCharCase(uppercase, result);
    }

    /**
     * Reads user input as char and checks if the input is in the given array of options.
     * @param possibleOptions array of possible options
     * @return the user input
     */
    public static char readChar(Character[] possibleOptions) {
        while (true) {
            char result = readChar();

            if (Arrays.asList(possibleOptions).contains(result)) {
                return result;
            } else {
                System.err.println("Invalid input, does not match any known option.");
                System.out.print("Try again: ");
            }
        }
    }

    /**
     * Reads user input as int.
     * @return the user input
     */
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.err.println("Invalid input, not a number.");
                System.out.print("Try again: ");
                scanner.next();
            }
        }
    }

    /**
     * Reads user input as int and checks if the input contains an allowed negative value.
     * @param negativeValues flag to allow negative values
     * @return the user input
     */
    public static int readInt(boolean negativeValues) {
        while (true) {
            int result = readInt();

            if (!negativeValues && result < 0) {
                System.err.println("Invalid input, negative values are not allowed.");
                System.out.print("Try again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Reads user input as int and checks if the input is in the given array of options.
     * @param possibleOptions array of possible options
     * @return the user input
     */
    public static int readInt(Integer[] possibleOptions) {
        while (true) {
            int result = readInt();

            if (Arrays.asList(possibleOptions).contains(result)) {
                return result;
            } else {
                System.err.println("Invalid input, does not match any known option.");
                System.out.print("Try again: ");
            }
        }
    }

    private static boolean isInvalidStringByRegex(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);

        if (string == null) {
            return true;
        }

        Matcher matcher = pattern.matcher(string);

        return !matcher.matches();
    }

    private static boolean isInvalidChar(String string) {
        return string.length() > 1;
    }

    private static boolean isNullOrWhitespace(String string) {
        return string == null || string.length() == 0 || isWhiteSpace(string);
    }

    private static boolean isWhiteSpace(String string) {
        int length = string.length();

        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(string.charAt(i))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private static char setCharCase(boolean uppercase, char character) {
        if (uppercase) {
            return Character.toUpperCase(character);
        } else {
            return Character.toLowerCase(character);
        }
    }
}
