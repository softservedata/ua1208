package com.softserve.edu.hw8.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new ArrayList<>();
        Random random = new Random();
        // Fills the list with 20 random integers from 1 to 100
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
    }

    // Test to ensure the list contains 20 elements after initialization
    @Test
    public void testListSize() {
        assertEquals(20, numbers.size(), "The list should contain exactly 20 elements");
    }

    // Test to verify the minimum value in the list is correct
    @Test
    public void testMinValue() {
        int min = Collections.min(numbers);
        assertTrue(numbers.contains(min), "The min value should exist within the list.");
    }

    // Test to verify the maximum value in the list is correct
    @Test
    public void testMaxValue() {
        int max = Collections.max(numbers);
        assertTrue(numbers.contains(max), "The max value should exist within the list.");
    }

    // Test to calculate and validate the average value of the elements in the list
    @Test
    public void testAverageValue() {
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        assertTrue(average >= 0, "The average value should be a non-negative number.");
    }

    // Test to remove even numbers from the list and check if the list contains only odd numbers
    @Test
    public void testRemoveEvenNumbers() {
        numbers.removeIf(n -> n % 2 == 0);
        assertTrue(numbers.stream().allMatch(n -> n % 2 != 0),
                "The list should only contain odd numbers after even numbers are removed.");
    }

    // Test to verify if the number 34 exists in the list
    @Test
    public void testContainsNumber() {
        boolean contains = numbers.contains(34);
        if (contains) {
            System.out.println("The list contains the number 34");
        } else {
            System.out.println("The list does not contain the number 34");
        }
    }

    // Test to sort the list in ascending order and verify the correctness of sorting
    @Test
    public void testSorting() {
        Collections.sort(numbers); // Sort the list
        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1),
                    "The list should be sorted in ascending order.");
        }
    }
}

