package com.softserve.edu05inher;

public class B extends A {

    public int j = 456;

    public B() {
        j = 678;
        System.out.println("\tConstructor B()");
    }

    @Override
    public void m1() {
        System.out.println("m1() from B");
        super.m1();
    }
}
