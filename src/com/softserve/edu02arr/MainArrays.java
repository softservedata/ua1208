package com.softserve.edu02arr;

import java.util.Arrays;

public class MainArrays {
    public static void main(String[] args) {
        //
        int[] numbers = { 2, -5, 8, -4, 7 };
        System.out.println("Original = " + Arrays.toString(numbers));
        //
        Arrays.sort(numbers);
        System.out.println("Sorted = " + Arrays.toString(numbers));
        //
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("index = " + index);
        //
        System.out.println("is contains 2: " + (Arrays.binarySearch(numbers, 2) > 0) );
        //
        String elements = Arrays.toString(numbers);
        System.out.println("Numbers = " + elements);
    }
}
