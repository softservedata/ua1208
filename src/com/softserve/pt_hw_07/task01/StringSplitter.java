package com.softserve.pt_hw_07.task01;

public class StringSplitter {
    public static String[] splitString(String str, String delimiter) {
        if (str == null || delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("String and delimiter cannot be null or empty");
        }
        return str.split(delimiter);
    }

    public static void main(String[] args) {
        String testString = "apple,banana,cherry,dates";
        String delimiter = ",";

        try {
            String[] result = splitString(testString, delimiter);
            for (String s : result) {
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
