package com.softserve.edu.javapr2.les.pr03gen;

public class AppBox {
    public static void main(String[] args) {
        //Box box = new Box();
        //box.set(123);


        /*BoxWrapper box = new BoxWrapper();
        box.set("123");
        String i = box.get();
        System.out.println("i = " + (i + 11));*/

        BoxGen<String> box = new BoxGen<>();
        box.set("321");
        String j = box.get();
        System.out.println("j = " + (j+11));

        BoxGen<Integer> box2 = new BoxGen<>();
        box2.set(456);

        int i2 = box2.get();
        System.out.println("i2 = " + (i2+11));

    }
}
