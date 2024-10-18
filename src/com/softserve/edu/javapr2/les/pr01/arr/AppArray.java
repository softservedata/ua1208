package com.softserve.edu.javapr2.les.pr01.arr;

import java.util.Arrays;

public class AppArray {
    public static void main(String[] args) {
        int max = 4;
        double[] arr = new double[max];
        arr[0] = 1.2;
        arr[1] = 4.7;
        arr[2] = 3.1;
        arr[3] = 2.4;

        System.out.println("Origsinal Array: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
        System.out.println("\n done");
        System.out.println("Array =  "+ Arrays.toString(arr));

        double [] arr2 = {1.2, 3.5, 34.43, 43,23};
        System.out.println("Array 2 " + Arrays.toString(arr2));
    }
}
