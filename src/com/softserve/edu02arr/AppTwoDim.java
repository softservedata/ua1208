package com.softserve.edu02arr;

public class AppTwoDim {
    public static void main(String[] args) {
        /*
        double[][] arr = {  {0, 1, 2, 3},
                            {4, 5, 6, 7},
                            {8, 9, 10, 11},
                            {12, 13, 14, 15}
        };
        */
        int[][] arr = new int[4][];
        arr[0] = new int[1];
        arr[1] = new int[3];
        arr[2] = new int[1];
        arr[3] = new int[2];
        //
        arr[0][0] = 1;
        arr[1][0] = 2;
        arr[1][1] = 3;
        arr[1][2] = 4;
        arr[2][0] = 5;
        arr[3][0] = 6;
        arr[3][1] = 7;
        //int[][] arr = { {1},{2,3,4},{5},{6,7} };
        //
        //
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("  " + arr[i][j]);
            }
            System.out.println();
        }
    }
}
