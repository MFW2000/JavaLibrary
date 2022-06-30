package com.mfw.javalibrary;

import java.util.Random;

public class Helpers {
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

    /**
     * Generates random int from 0 to the maximum value.
     * @param max maximum value
     * @return generated int
     */
    public static int generateRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }

    /**
     * Generates random int from the minimum value to the maximum value.
     * @param min minimum value
     * @param max maximum value
     * @return generated int
     */
    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

    /**
     * Generates random double from 0 to the maximum value.
     * @param max maximum value
     * @return generated double
     */
    public static double generateRandomDouble(double max) {
        Random random = new Random();
        return random.nextDouble(max);
    }

    /**
     * Generates random double from the minimum value to the maximum value.
     * @param min minimum value
     * @param max maximum value
     * @return generated double
     */
    public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        return random.nextDouble(min, max);
    }
}
