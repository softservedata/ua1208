package main.java.com.softserve.homework.hw08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class CollectionsOfNumbers {

    public Integer findMin(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NoSuchElementException("List is empty or null");
        }
        return Collections.min(numbers);
    }

    public int findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NoSuchElementException("List is empty or null");
        }
        return Collections.max(numbers);
    }

    public double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public List<Integer> removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(integer -> integer % 2 == 0);
        return numbers;
    }

    public boolean containsNumber(List<Integer> numbers, int numberToCheck) {
        return numbers.contains(numberToCheck);
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
