package hw.hw7;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter price without VAT: ");
        double price = scanner.nextDouble();

        double priceWithVAT = price * 1.2; // Add 20% VAT

        System.out.println("Price without VAT: " + price);
        System.out.println("Price with VAT: " + priceWithVAT);
    }
}
