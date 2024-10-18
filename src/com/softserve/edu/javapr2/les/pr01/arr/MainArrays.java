package com.softserve.edu.javapr2.les.pr01.arr;

import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {
        int[] numbers = {2, -5, 8, -4, 7};

        System.out.println("Original = " + Arrays.toString(numbers)); // друкуємо значення

        Arrays.sort(numbers); //сортуємо від меншого до більшого
        System.out.println("Sorted = " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 7);//знаходимо на якій позиції число 7
        System.out.println("index = " + index);

        System.out.println("is contains 2: " + (Arrays.binarySearch(numbers, 2) > 0));

        String elements = Arrays.toString(numbers);
        System.out.println("Numbers = " + elements);


    }
}
