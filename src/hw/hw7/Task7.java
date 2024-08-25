package hw.hw7;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Ask for the initial deposit amount (Principal)
        System.out.print("Enter the initial deposit amount (P): ");
        double principal = scanner.nextDouble();

        // Ask for the annual interest rate (as a percentage)
        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualRate = scanner.nextDouble();

        // Ask for the number of years the money is invested
        System.out.print("Enter the number of years (t): ");
        int years = scanner.nextInt();

        // Convert the annual interest rate from percentage to decimal
        double rate = annualRate / 100;

        // Loop to calculate the final amount year by year
        double amount = principal; // Start with the initial principal
        for (int i = 1; i <= years; i++) {
            amount = amount * (1 + rate);
            System.out.printf("After year %d: %.2f%n", i, amount);
        }

        // Final output showing the amount after all years
        System.out.printf("After %d years at %.2f%% interest rate, the final amount is: %.2f%n", years, annualRate, amount);
    }
}
