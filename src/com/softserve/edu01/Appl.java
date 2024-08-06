package com.softserve.edu01;

public class Appl {

    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student("Petro");
        Student st3 = new Student("Ira", 18);
        //
        System.out.println("count = " + Student.getCount());
        //
        System.out.println("st1 = " + st1.toString());  // by default
        System.out.println("st2 = " + st2);
        System.out.println("st3 = " + st3);
        //
        double d1 = 2.4;
        double d2 = 2.4;
        System.out.println("(d1 == d2) = " + (d1 == d2));
        //
        Student st4 = new Student("Ira", 18);
        System.out.println("(st3 == st4) = " + (st3 == st4)); // Invalid Solution
        System.out.println("st3.equals(st4) = " + st3.equals(st4));
        System.out.println("st3.hashCode() = " + st3.hashCode());
        System.out.println("st4.hashCode() = " + st4.hashCode());
    }
}
