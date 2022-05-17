package com.mfw.javalibrary;

import java.util.Random;

public class Helpers {
    // TODO: Add Javadoc

    /**
     * Trims invalid whitespaces from the given string.
     * Invalid whitespaces are whitespaces before characters, space after characters
     * and multiple spaces throughout the string.
     * @param string string to trim
     * @return the trimmed string
     */
    public static String trimInvalidWhitespaces(String string) {
        return string.trim().replaceAll(" +", " ");
    }

    public static int generateRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }

    public static double generateRandomDouble(double max) {
        Random random = new Random();
        return random.nextDouble(max);
    }

    public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        return random.nextDouble(min, max);
    }
}
