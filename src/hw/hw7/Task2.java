package hw.hw7;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float total = 0;

        for (int i = 1; i <= 5; i++) {       // Loop to get 5 temperatures
            System.out.print("Enter temperature " + i + ": ");
            total += scanner.nextFloat();
        }

        float average = total / 5;

        System.out.println("Average temperature: " + average);
    }
}