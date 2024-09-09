package com.softserve.edu.hw08.task01;

import com.softserve.edu.hw08.StringComparison;

public class Main {
    public static void main(String[] args) {
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();

        //task01
        System.out.println(StringComparison.areStringEquals("Hello", "Hello"));
        System.out.println(StringComparison.areStringEquals("hello", "Hello"));
        System.out.println(StringComparison.areStringIgnoreEquals("Hello", "hello"));
    }

    public static void task02() {
        String result1 = getSubstringBetween("Hello world!", 0, 5);
        System.out.println(result1); // Виведе: "hello"

        // Виклик методу з рядком "hello world" і індексами 6 та 11
        String result2 = getSubstringBetween("Hello world!", 6, 12);
        System.out.println(result2); // Виведе: "world"
    }

    private static String getSubstringBetween(String str, int startIndex, int endIndex) {
        return str.substring(startIndex, endIndex);
    }

//

    //indexOfSubstring
    public static void task03() {
        int index1 = indexOfSubstring("Hello world!", "!");
        System.out.println(index1);
        int index2 = indexOfSubstring("Hello world!", "?");
        System.out.println(index2);
    }

    public static int indexOfSubstring(String str, String substring) {
        return str.indexOf(substring);

    }

//

    // replaceSubstring
    public static void task04() {
        System.out.println(replaceSubstring("Hello Java", "Java", "!")); //
        System.out.println(replaceSubstring("Hello world", "world", "Java"));  //
    }

    public static String replaceSubstring(String str, String oldSubstring, String newSubstring) {
        return str.replace(oldSubstring, newSubstring);


    }

    public static void task05() {
        System.out.println(containsDigits("Hello Java 1991")); //
        System.out.println(containsDigits("Java"));  //
    }

    private static boolean containsDigits(String str) {

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch))
                return true;
        }
        return false;
    }

    public static void task06() {
        System.out.println(trimSpaces("  hello java  "));
        System.out.println(trimSpaces("  hello   "));
    }

    public static String trimSpaces(String str) {
        return str.trim();
    }
public static void task07(){
    String str = "Hello, world! Welcome to Java.";
    String delimiter = " ";
    String[] words = splitString(str, delimiter);
    for (String word : words){
        System.out.println(word);
    }

}
    private static String[] splitString(String sentence, String delimiter) {
        return sentence.split(delimiter);
    }
}
