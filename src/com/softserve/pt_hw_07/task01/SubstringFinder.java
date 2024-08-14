package com.softserve.pt_hw_07.task01;

public class SubstringFinder {
    public static int findSubstringIndex(String str, String substring) throws IllegalAccessException {
        if (str == null || substring == null) {
            throw new IllegalAccessException("The string and substring can't be null");
        }
        return str.indexOf(substring);
    }

    public static void main(String[] args) {
        String originalString = "Good day";
        String substring = "od";

        try {
            int index = findSubstringIndex(originalString, substring);
            System.out.println("The index of the first occurrence: " + index);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
