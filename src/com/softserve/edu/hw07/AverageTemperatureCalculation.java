package com.softserve.edu.hw07;

import java.util.Scanner;
/*  for (int i = 1; i <= 5; i++) {
            System.out.print("Введіть температуру за день " + i + ": ");
            float dailyTemperature = scanner.nextFloat();
            totalTemperature += dailyTemperature;  // Додавання температури до загальної суми
        }

        // Обчислення середньої температури
        float averageTemperature = totalTemperature / days;
        System.out.println("Середня температура за " + days + " днів: " + averageTemperature);
    }
}*/


public class AverageTemperatureCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature for the first day");
        float tempDay1 = scanner.nextFloat();
        System.out.println("Enter temperature for the second day");
        float tempDay2 = scanner.nextFloat();
        System.out.println("Enter temperature for the third day");
        float tempDay3 = scanner.nextFloat();
        System.out.println("Enter temperature for the forth day");
        float tempDay4 = scanner.nextFloat();
        System.out.println("Enter temperature for the fifth day");
        float tempDay5 = scanner.nextFloat();


        float averageTemp = (tempDay1 + tempDay2 + tempDay3 + tempDay4 + tempDay5) / 5;
        System.out.println("Average temperature for five days: " + averageTemp);

    }
}