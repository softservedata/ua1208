package com.softserve.pt_hw_07.task02;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle defaultRectangle = new Rectangle();
        System.out.println("Default: " + defaultRectangle);

        Rectangle rectangle = new Rectangle(5.0, 10.0);
        System.out.println(rectangle);

        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Diagonal: " + rectangle.getDiagonal());

        rectangle.setWidth(7.0);
        rectangle.setHeight(14.0);
        System.out.println(rectangle);

        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Diagonal: " + rectangle.getDiagonal());
    }
}
