package com.softserve.pt_hw_07.task_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class NumberAnalysis {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        // 1. Print all elements of the collection
        System.out.println("All elements of the collection: " + numbers);

        // 2. Find and print the minimum and maximum numbers in the collection
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        System.out.println("Minimum number: " + min);
        System.out.println("Maximum number: " + max);

        // 3. Calculate and print the average value of the numbers in the collection
        double average = numbers.stream().mapToInt(Integer::intValue)
                .average().orElse(0.0);
        System.out.println("Average value: " + average);

        // 4. Remove all even numbers from the collection and print the updated collection
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("Collection after removing even numbers: " + numbers);

        // 5. Check if the collection contains a given number (for example, 50) and print the result
        int numberToCheck = 51;
        boolean containsNumber = numbers.contains(numberToCheck);
        System.out.println("Does the collection contain " + numberToCheck + "? " + containsNumber);

        // 6. Sort the collection in ascending order and print the sorted collection
        Collections.sort(numbers);
        System.out.println("Sorted collection in ascending order: " + numbers);
    }
}
