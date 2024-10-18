package com.softserve.edu.javapr2.les.pr01;

import java.util.Scanner;

public class PracticalTask01 {


    public static void main(String[] args) {
        int number1 = getNumber("Enter the first number: ");
        int number2 = getNumber("Enter the second number: ");
        int total = getTotal(number1, number2);
        double average = getAverage(number1, number2);
        System.out.println("The sum of " + number1 + " and " + number2 + " is " + total);
        System.out.println("The average of " + number1 + " and " + number2 + " is " + average);


    }

    private static double getAverage(int number1, int number2) {
        return (number1 + number2) / 2;
    }

    private static int getTotal(int number1, int number2) {
        return number1 + number2;
    }

    private static int getNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }
}
