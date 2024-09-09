package com.softserve.edu.hw08.task03;

import org.openqa.selenium.devtools.v85.css.model.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <= 20; i++) {
            numbers.add(random.nextInt(100) + 1);
        }
        System.out.println("Collection numbers:" + numbers);
        //
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Min number:" + min);
        System.out.println("Max number:" + max);

        //Обчислення середнього значення
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average value:" + average);

        //  Видалення всіх парних чисел
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("Array without even numbers" + numbers);

        // Перевірка наявності числа 50
        boolean contains50= numbers.contains(50);
        System.out.println("Does the collection contain 50 number ? " +contains50);
        //Сортування по зростанню

       Collections.sort(numbers);
        System.out.println("Sorted collection:"+ numbers);



    }
}


