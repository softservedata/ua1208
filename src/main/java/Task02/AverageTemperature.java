package Task02;

import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float totalTemperature = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter the temperature for day " + i + ": ");
            float temp = scanner.nextFloat();
            totalTemperature += temp;
        }

        float averageTemperature = totalTemperature / 5;
        System.out.println("Average temperature over 5 days: " + averageTemperature);
    }
}
