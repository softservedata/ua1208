package com.softserve.edu.javapr2.les.pr05inter;

public class B extends A {
    public int j = 456;

    public B() {
        j = 321;
        System.out.println("\t Constructor B() ");
    }

    public void m1() {
        System.out.println("m1() from B");
    }
}
