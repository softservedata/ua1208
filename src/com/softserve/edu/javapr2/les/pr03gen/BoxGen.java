package com.softserve.edu.javapr2.les.pr03gen;

public class BoxGen<T> {
    private T obj;

    public T get(){
        return obj;
    }

    public void set(T obj){
        this.obj = obj;
    }
}
