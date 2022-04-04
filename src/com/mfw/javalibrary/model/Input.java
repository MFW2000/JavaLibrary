package com.mfw.javalibrary.model;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public interface Input {
    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    String readOptionString(String[] possibleChoices);

    /**
     * Reads user input and checks if the input matches the given regex.
     * @param regex defines what is allowed as input
     * @return the user input
     */
    String readOptionString(String regex);

    /**
     * Reads user input and checks if the input is in the given array of choices.
     * @param possibleChoices array of possible choices
     * @return the user input
     */
    int readOptionInt(Integer[] possibleChoices);

    /**
     * Reads user input and checks if the input is valid.
     * @return the user input
     */
    int readOptionInt();
}
