package com.softserve.edu.hw08.task02;

import java.util.Scanner;

public class Rectangle {
    Scanner scanner = new Scanner(System.in);
    private double width;
    private double height;
    private double angle = 90.0; // Angle is 90 degrees
     public Rectangle (){
         this.width=0.0;
         this.height=0.0;

     }
public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
}

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getAngle() {
        return angle;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double calculateArea(){
         return width*height;
    }
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    public  double getDiagonal(){
         return (width*width+height*height);
    }
}


