package edu.softserve.edu.hw09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomNumbers {

private ArrayList<Integer> numbers;

public RandomNumbers() {
    numbers = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i <= 20; i++) {
        numbers.add(random.nextInt(100) + 1);
    }
}

public ArrayList<Integer> getNumbers() {
    return numbers;
}

public int getMin() {
    return Collections.min(numbers);
}

public int getMax() {
    return Collections.max(numbers);
}

public double getAverage() {
    return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
}

public void removeEvenNumbers() {
    numbers.removeIf(n -> n % 2 == 0);
}

public boolean contains50() {
    return numbers.contains(50);
}

public void sortNumbers() {
    Collections.sort(numbers);
}
}