package com.softserve.pt_hw_07.task01;

public class StringComparator {

    public static boolean areStringsEqual(String str1, String str2, boolean caseSensitive) {
        return caseSensitive ? str1.equals(str2) : str1.equalsIgnoreCase(str2);
    }

    public static void main(String[] args) {
        String string1 = "Java";
        String string2 = "java";

        System.out.println(areStringsEqual(string1, string2, true));
        System.out.println(areStringsEqual(string1, string2, false));
    }
}
