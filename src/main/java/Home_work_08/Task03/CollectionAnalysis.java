package Home_work_08.Task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionAnalysis {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            numbers.add(rand.nextInt(100) + 1);
        }

        System.out.println("All numbers: " + numbers);

        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average: " + average);

        numbers.removeIf(num -> num % 2 == 0);
        System.out.println("After removing even numbers: " + numbers);

        boolean contains50 = numbers.contains(50);
        System.out.println("Contains 50: " + contains50);

        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);
    }
}
