package com.softserve.edu.javapr2.les.pr01.arr;

public class AppTwoDim {
    public static void main(String[] args) {
        double[][] arr = {{0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("  " + arr[i][j]);
            }
            System.out.println();
        }

        //2 варіант
        //int[][] twoD={{1},{2,3,4},{5},{6,7}};
        int [][] twoD = new int[4][];
        twoD[0] = new int[1];
        twoD[1] = new int[3];
        twoD[2] = new int[1];
        twoD[3] = new int[2];

        twoD[0][0]=1;
        twoD[1][0]=2;
        twoD[1][1]=3;
        twoD[1][2]=4;
        twoD[2][0]=5;
        twoD[3][0]=6;
        twoD[3][1]=7;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" twoD = " + arr[i][j]);
            }
            System.out.println();
        }






    }
}
