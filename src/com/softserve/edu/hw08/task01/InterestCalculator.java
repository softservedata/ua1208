package com.softserve.edu.hw08.task01;

import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the rate: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the time: ");
        double time = scanner.nextDouble();

        double decimal = rate / 100;

        double amount = principal;

        for (int i = 1; i <= time; i++) {
            amount = amount * (1 + decimal);
            System.out.println("Amount after year " + i + ":" + amount);
        }
        System.out.printf("Total amount after %d years: %.2f%n", (int) time, amount);
    }
}
