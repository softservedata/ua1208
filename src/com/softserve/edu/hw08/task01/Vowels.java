package com.softserve.edu.hw08.task01;

import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the string : ");
        String str = scanner.nextLine();
        String inputString;
        System.out.println("Vowels in the string:" + countVowels(str));
    }

    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }

        return count;
    }
}