package com.softserve.edu.hw08.task01;

import java.util.Scanner;

public class VAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price excluding VAT: ");
        double excludingVAT = scanner.nextDouble();
        // Розрахунок ПДВ( 20% від ціни)
        double vat = excludingVAT * 0.20;
        double includingVAT=excludingVAT+vat;
        System.out.println("Price excluding VAT ]:"+excludingVAT);
        System.out.println("Price including VAT ]:"+includingVAT);
        scanner.close();

    }
}
