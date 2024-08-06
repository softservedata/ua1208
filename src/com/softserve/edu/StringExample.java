package com.softserve.edu;

public class StringExample {
    protected static String localStr = "Hello Java!";

    static {
        System.out.println(localStr);
        localStr = "World!";
    }

}
