package com.softserve.edu05inher;

public class AppAB {

    public static void main(String[] args) {
        /*
        //A b = new A();
        B b = new B();
        System.out.println("b.getI() = " + b.getI());
        b.m1();
        */
        /*
        int k = 34;
        double d = 2.7;
        System.out.println("original d = " + d);
        //k = d;
        d = k;
        System.out.println("updated d = " + d);
        */
        /*
        A a = new B(); // upcasting
        System.out.println("a.getI() = " + a.getI());
        a.m1();
        */
        //
        IA a = new B();
        System.out.println("a.getI() = " + a.getI());
        if (a instanceof A) {
            ((A) a).m1(); // downcasting
        }
        //
    }
}
