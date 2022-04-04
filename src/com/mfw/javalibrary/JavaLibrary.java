package com.mfw.javalibrary;

import com.mfw.javalibrary.model.Input;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class JavaLibrary implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readOptionString(String[] possibleChoices) {
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

    @Override
    public String readOptionString(String regex) {
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

    @Override
    public int readOptionInt(Integer[] possibleChoices) {
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

    @Override
    public int readOptionInt() {
        boolean isValid = false;
        int result = -1;

        while (!isValid) {
            try {
                result = scanner.nextInt();

                if ((float)result%1 == 0) {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
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
