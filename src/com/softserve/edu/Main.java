package com.softserve.edu;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the method 'main' StringExample.localStr = "
                + StringExample.localStr);
        //
        StringExample stringExp = new StringExample();
        stringExp.localStr = "Privet";
        System.out.println("stringExp.localStr = " + stringExp.localStr);
    }

}
