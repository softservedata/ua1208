package com.softserve.edu.javapr2.les.pr06Set;

import java.util.HashSet;
import java.util.Set;

public class FindDups {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < args.length; i++){
            if (!s.add(args[i])){
                System.out.println("Duplicate detected: " + args[i]);

            }
        }
        System.out.println("Elements: " + s);

    }


}
