package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class NumberAnalysis {
    public static void main(String[] args) {
        // Create an ArrayList to store Integer numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // Fill the ArrayList with 20 random numbers from 1 to 100
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100) + 1); // random.nextInt(100) generates 0-99, +1 to make it 1-100
        }

        // 1. Print all elements of the collection
        System.out.println("All numbers:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 2. Find and print the minimum and maximum numbers
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Minimum number: " + min);
        System.out.println("Maximum number: " + max);

        // 3. Calculate and print the average value
        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        double average = sum / numbers.size();
        System.out.println("Average value: " + average);

        // 4. Remove all even numbers and print the updated collection
        numbers.removeIf(number -> number % 2 == 0);
        System.out.println("After removing even numbers:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 5. Check if the collection contains a given number (e.g., 50) and print the result
        int checkNumber = 50;
        boolean contains = numbers.contains(checkNumber);
        System.out.println("Contains " + checkNumber + ": " + contains);

        // 6. Sort the collection in ascending order and print it
        Collections.sort(numbers);
        System.out.println("Sorted numbers:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

