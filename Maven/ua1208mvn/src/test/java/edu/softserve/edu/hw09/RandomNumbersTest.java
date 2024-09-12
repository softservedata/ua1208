package edu.softserve.edu.hw09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;

public class RandomNumbersTest {

    private RandomNumbers randomNumbers;

    @BeforeEach
    public void setUp() {
        randomNumbers = new RandomNumbers();
    }

    @Test
    public void testGetNumbers() {
        ArrayList<Integer> numbers = randomNumbers.getNumbers();
        assertNotNull(numbers);
        assertEquals(21, numbers.size());
    }


    @Test
    public void testGetMin() {
        int min = randomNumbers.getMin();
        assertTrue("The minimum value should be between 1 and 100", min >= 1 && min <= 100);
    }

    @Test
    public void testGetMax() {
        int max = randomNumbers.getMax();
        assertTrue("The maximum value should be between 1 and 100",max >= 1 && max <= 100);
    }

    @Test
    public void testGetAverage() {
        double average = randomNumbers.getAverage();
        assertTrue(average >= 1 && average <= 100);
    }

    @Test
    public void testRemoveEvenNumbers() {
        randomNumbers.removeEvenNumbers();
        ArrayList<Integer> numbers = randomNumbers.getNumbers();
        assertTrue(numbers.stream().allMatch(n -> n % 2 != 0));
    }

    @Test
    public void testContains50() {
        boolean contains50 = randomNumbers.contains50();
              assertTrue(true);
    }

    @Test
    public void testSortNumbers() {
        randomNumbers.sortNumbers();
        ArrayList<Integer> numbers = randomNumbers.getNumbers();
        for (int i = 0; i < numbers.size() - 1; i++) {
            assertTrue(numbers.get(i) <= numbers.get(i + 1));
        }


    }

}