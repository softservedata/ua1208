package Task01;

import java.util.Scanner;

public class ProductPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price of the product excluding VAT: ");
        double priceExcludingVAT = scanner.nextDouble();

        double vat = 0.20;  // 20% VAT
        double priceIncludingVAT = priceExcludingVAT * (1 + vat);

        System.out.println("Price excluding VAT: " + priceExcludingVAT);
        System.out.println("Price including VAT: " + priceIncludingVAT);
    }
}

