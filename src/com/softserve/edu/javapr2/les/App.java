package com.softserve.edu.javapr2.les;

public class App {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student("Petro");
        Student st3 = new Student("Ira", 18);

        System.out.println("count = " + Student.getCount());
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);

        double i = 2.4;
        double j = 2.4;
        System.out.println("i == j " + (i==j)); // без іквелс порівнює один об'єкт з іншим, і якщо вони однакові - true, так як вони примітивні

        Student st4 = new Student("Ira", 18);
        System.out.println(st3==st4);// без іквелс, тобто у них різні хеши, тож буде фолс
        System.out.println(st3.equals(st4)); //без іквелс, також буде фолс, так як хеш код різний
        System.out.println(st3.hashCode());
        System.out.println(st4.hashCode());
        System.out.println(st3.equals(st4));//якщо є іквелс метод, то тоді порівнює контент, а не хешкод


    }

}
