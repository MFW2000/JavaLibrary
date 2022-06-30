package com.mfw.javalibrary;

import java.io.IOException;
import java.util.Scanner;

public class Console {
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
}
