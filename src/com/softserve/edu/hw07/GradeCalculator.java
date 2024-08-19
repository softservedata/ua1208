package com.softserve.edu.hw07;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a numerical score : ");
        int score = scanner.nextInt();
        char grade;
        if (score <= 100 && score >= 90) {
            grade = 'A';
        } else if (score >= 80 && score < 90) {
            grade = 'B';
        } else if (score >= 70 && score < 80) {
            grade = 'C';
        } else if (score >= 60 && score < 70) {
            grade = 'D';
        } else if (score >= 50 && score < 60) {
            grade = 'F';
        } else {
            grade = 'X';
            System.out.println("Invalid value ");
        }
        System.out.println("Grade letter : " + grade);
    }
}
