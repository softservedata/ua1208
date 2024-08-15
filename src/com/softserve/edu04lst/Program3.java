package com.softserve.edu04lst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("second", "third", "fourth", "first", "first");
        System.out.println("Original: " + list);
        Collections.reverse(list);
        System.out.println("reverse: " + list);

        // sorting
        Collections.sort(list);
        System.out.println("sorted: " + list);

        // uses a binary search algorithm to find a specific element;
        // returns the element number or a negative number
        System.out.println("second binarySearch: " + Collections.binarySearch(list, "second"));

        //reverse sort order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("sorted; reverseOrder: " + list);

        //randomly reorders elements
        Collections.shuffle(list);
        System.out.println("shuffle: " + list);

         // max value, min value,
        System.out.println("max: " + Collections.max(list));
        System.out.println("min: " + Collections.min(list));

        // cyclically shifts the elements passed to it by distance
        // positions forward (+) or backward (-)
        Collections.rotate(list, -1);
        System.out.println("rotate: " + list);
       
        // copy collection
        List<String> listDestination = Arrays.asList("green", "black");
        Collections.copy(list, listDestination);
        System.out.println("copy: " + list);

        // returns the total number of occurrences of the
        // specified element in the list
        System.out.println("first frequency: " + Collections.frequency(list, "first"));
    }
}
