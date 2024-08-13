package com.softserve.edu05inher;

// public class A extends Object {
public class A implements IA {

    private int i;

    public A() {
        i = 123;
        System.out.println("\tConstructor A()");
    }

    public A(int i) {
        this.i = i;
        System.out.println("\tConstructor A(int i)");
    }

    public int getI() {
        return i;
    }

    public void m1() {
        System.out.println("m1() from A");
    }

    // Overload
    public void m1(String msg) {
        System.out.println("m1() from A, msg = " + msg);
    }
}
