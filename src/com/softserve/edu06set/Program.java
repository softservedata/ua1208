package com.softserve.edu06set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
        public static void main(String[] args) {
                //Set<String> set = new HashSet<>(); // by hashCode
                //Set<String> set = new LinkedHashSet<>(); // By Order
                Set<String> set = new TreeSet<>(); // by Name
                //
                set.add("Mike");
                set.add("Nike");
                set.add("Alex");
                set.add("Sara");
                for (String current : set) {
                      System.out.print(current + "  ");
                }
        }
}