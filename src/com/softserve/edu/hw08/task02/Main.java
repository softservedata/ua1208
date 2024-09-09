package com.softserve.edu.hw08.task02;

public class Main {
    public static void main(String[] args) {
        Rectangle rect01=new Rectangle();
        System.out.println("Default Rectangle:");
        System.out.println("Width:"+rect01.getWidth());
        System.out.println("Height:"+rect01.getHeight());
        System.out.println("Angle:"+rect01.getAngle());
        System.out.println("Perimeter:"+rect01.calculateArea());
        System.out.println("Diagonal:"+rect01.getDiagonal());
        //
        // Create a rectangle with specific dimensions
        Rectangle rect02=new Rectangle(10,20);
        System.out.println("Default Rectangle:");
        System.out.println("Width:"+rect02.getWidth());
        System.out.println("Height:"+rect02.getHeight());
        System.out.println("Angle:"+rect02.getAngle());
        System.out.println("Perimeter:"+rect02.calculateArea());
        System.out.println("Diagonal:"+rect02.getDiagonal());

    }

}
