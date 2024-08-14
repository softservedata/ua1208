package com.softserve.pt_hw_07.task01;

public class StringTrimmer {
    public static String trimString(String str) throws IllegalAccessException {
        if (str == null) {
            throw new IllegalAccessException("The row can't be null");
        }
        return str.trim();
    }

    public static void main(String[] args) throws IllegalAccessException {
        String testString1 = "   Hello, world!   ";
        String testString2 = "Java";
        String testString3 = "                                Java  ";

        System.out.println("'" + trimString(testString1) + "'");
        System.out.println("'" + trimString(testString2) + "'");
        System.out.println("'" + trimString(testString3) + "'");
    }
}
