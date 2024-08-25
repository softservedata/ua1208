package hw.hw7;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {         // Check if the number is even or odd
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }
    }
}

