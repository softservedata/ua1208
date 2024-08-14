package com.softserve.pt_hw_07.task01;

public class SubstringReplacer {
    public static String replaceSubstring(String str, String target, String replacement) throws IllegalAccessException {
        if (str == null || target == null || replacement == null) {
            throw new IllegalAccessException("String, target, and replacement-substring cannot be null");
        }
        return str.replace(target, replacement);
    }

    public static void main(String[] args) {
        String originalString = "I wish you great day";
        String target = "day";
        String replacement = "evening";

        try {
            String result = replaceSubstring(originalString, target, replacement);
            System.out.println(result);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
