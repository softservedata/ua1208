package com.softserve.edu.javapr2.les;

public class StaticBlock {
    //Статична змінна
   protected static String localStr = "Hello Java!";

    //Статичний блок, працює як метод для статичних змінних
    static {
        System.out.println(localStr);
        localStr = "World!";
    }
    public static void main(String[] args) {
        System.out.println("Hello from the method 'main' StaticBlock = "
                + localStr);
    }
}
