package com.softserve.edu02arr;

import java.util.Arrays;

public class AppArray {
    public static void main(String[] args) {
        /*
        int max = 4;
        double[] arr = new double[max];
        arr[0] = 1.2;
        arr[1] = 4.7;
        arr[2] = 3.1;
        arr[3] = 2.4;
        */
        //
        double[] arr = {1.2, 4.7, 3.1, 2.4};
        //
        System.out.print("Original Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  " + arr[i]);
        }
        System.out.println(" ]\ndone");
        System.out.println("Array = " + Arrays.toString(arr));
        //
    }
}
