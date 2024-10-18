package com.softserve.edu.javapr2.les.pr05inter;

public class AppAB {
    public static void main(String[] args) {
        B b = new B();
        System.out.println("b.getI() = " + b.getI());
        b.m1();
        System.out.println("-------------------------------------------------------");
        A a = new A();
        System.out.println("a.getI() = " + a.getI());
        a.m1();
        System.out.println("-------------------------------------------------------");
        int k = 21;
        double d = 2.7;
        System.out.println("original d = " + d);
        d = k;
        // k=d; - error
        System.out.println("updated d = " + d);
        System.out.println("-------------------------------------------------------");

        IA a1 = new B();
        System.out.println("a1.getI = "+ a1.getI());
        if(a instanceof A) {
            ((A) a1).m1();
        }


    }
}
