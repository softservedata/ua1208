package com.softserve.edu.hw8.task4;
import java.util.*;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    // Method to merge two book collections
    public List<Book> mergeCollections(List<Book> collection1, List<Book> collection2) {
        List<Book> mergedList = new ArrayList<>(collection1);
        mergedList.addAll(collection2);
        return mergedList;
    }
}




