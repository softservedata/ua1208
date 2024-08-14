package com.softserve.pt_hw_07.task01;

public class StringDigitalCheck {
    public static boolean containsDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String testString1 = "Java";
        String testString2 = "Java 0";
        String testString3 = "0000";
        String testString4 = "";

        System.out.println(containsDigits(testString1));
        System.out.println(containsDigits(testString2));
        System.out.println(containsDigits(testString3));
        System.out.println(containsDigits(testString4));
    }
}

