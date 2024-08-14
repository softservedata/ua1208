package com.softserve.pt_hw_07.task01;

public class SubstringExtractor {
    public static String getSubstring(String str, int start, int end) throws IllegalAccessException {
        if (start < 0 || end > str.length() || start > end) {
            throw new IllegalArgumentException("Invalid start or end subscripts");
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String originalString = "Hello, world!";
        int startIndex = 7;
        int endIndex = 12;

        try {
            String result = getSubstring(originalString, startIndex, endIndex);
            System.out.println(result);
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
    }
}
