package com.softserve.edu.hw08.task01;

import java.util.Scanner;

public class AgeCategoryClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age : ");
        int age = scanner.nextInt();

        if (age <= 0) {
            System.out.println("Invalid input");

        } else if (age >= 0 && age <= 12) {
            System.out.println("Child");

        } else if (age >= 13 && age <= 19) {
            System.out.println("Teenager");
        } else if (age >= 20 && age <= 59) {
            System.out.println("Adult");
        } else if (age >= 60) {
            System.out.println("Senior");

        }
    }
}
