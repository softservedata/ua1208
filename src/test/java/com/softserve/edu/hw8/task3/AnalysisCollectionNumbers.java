package com.softserve.edu.hw8.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AnalysisCollectionNumbers {
    public static void main(String[] ars) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("All elements:" + numbers);

        //2. Find and print the minimum and maximum numbers in the collection.
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Minimum numbers:" + min);
        System.out.println("MMaximum numbers:" + max);

        // 3. Calculate and print the average value of the numbers in the collection.
        double avarage = numbers.stream().mapToInt(Integer:: intValue).average().orElse(0);
        System.out.println("Avarage value:" + avarage);

       //4. Remove all even numbers from the collection, and then print the updated collection to the console.
        numbers.removeIf(n -> n % 2 ==0);
        System.out.println("After removing even number:" + numbers );

        //5. Check if the collection contains a given number (for example, 50), and print the result to the console
        int numberToCheck = 34;
        boolean contains = numbers.contains(numberToCheck);
        System.out.println("Collection contains " + numberToCheck + ": " + contains);

        // 6. Sort the collection in ascending order and print the sorted collection to the console.
        Collections.sort(numbers);
        System.out.println("Sorted collection: " + numbers);


    }

}
