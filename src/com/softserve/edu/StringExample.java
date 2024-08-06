package com.softserve.edu;

public class StringExample {
    protected static String localStr = "Hello Java!";

    static {
        System.out.println(localStr);
        localStr = "World!";
    }

    public StringExample() {
        System.out.println("Constructor done");
        localStr = "Constructor done";
    }

}
