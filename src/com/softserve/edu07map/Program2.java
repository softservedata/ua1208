package com.softserve.edu07map;

import java.util.HashMap;
import java.util.Map;

public class Program2 {
        public static void main(String[] args) {
                Map<Integer, String> hashMap = new HashMap<>();
                hashMap.put(1, "Mike");
                hashMap.put(2, "Nick");
                hashMap.put(3, "Sara");
                hashMap.put(1, "Alex");
                hashMap.put(4, null);
                hashMap.put(5, null);
                hashMap.put(null, "Simon");
                //
                for (Map.Entry m : hashMap.entrySet()) {
                      System.out.println(m.getKey() + " " + m.getValue());
                }
       }
}