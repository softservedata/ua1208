package com.softserve.pt01;

import java.util.Scanner;

public class PracticalTask1 {

    public static void main(String[] args) {
        int number1 = getNumber("Enter the first number: ");
        int number2 = getNumber("Enter the second number: ");
        int total = getTotal(number1, number2);
        double average = getAverage(number1, number2);
        System.out.println("The sum of " + number1 + " and " + number2 + " is " + total);
        System.out.println("The average of " + number1 + " and " + number2 + " is " + average);
    }

    public static int getTotal(int num1, int num2) {
        return num1 + num2;
    }

    public static double getAverage(int num1, int num2){
        return (num1 + num2) / 2.0;
    }

    public static int getNumber(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextInt();
    }
}