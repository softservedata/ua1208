package com.softserve.edu.javapr2.les.pr05inter;

public class A implements IA {
    private int i;

    public A() {
        i = 123;
        System.out.println("\t constructor A()");
    }

    public A(int i) {
        this.i = i;
        System.out.println("\t constructor A(int i)");
    }

    public int getI() {
        return i;
    }

    public void m1() {
        System.out.println("m1() from A");
    }

    public void m1(String msg) {
        System.out.println("m1() from A, msg " + msg);
    }
}
