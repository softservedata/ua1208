package com.softserve.edu;

public class MyArray {

    public int[] createArr() {
        return new int[]{1, 2, 3, 4, 5};
    }

    public boolean isContains(int[] arr, int number) {
        boolean result = false;
        for (int current : arr) {
            if (current == number) {
                result = true;
                break;
            }
        }
        return  result;
    }
}
