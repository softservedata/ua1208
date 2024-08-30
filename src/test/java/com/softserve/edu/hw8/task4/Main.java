package com.softserve.edu.hw8.task4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("Book One", "Author One", "Fiction", 1999);
        Book book2 = new Book("Book Two", "Author Two", "Fantasy", 2005);
        Book book3 = new Book("Book Three", "Author One", "Fantasy", 2005);
        Book book4 = new Book("Book Four", "Author Three", "Science Fiction", 2010);

        // Create book collections
        List<Book> collection1 = Arrays.asList(book1, book2);
        List<Book> collection2 = Arrays.asList(book3, book4);

        // Create a BookCollection instance
        BookCollection bookCollection = new BookCollection();

        // Merge the collections
        List<Book> mergedCollection = bookCollection.mergeCollections(collection1, collection2);

        // Print the merged collection
        System.out.println("Merged Collection:");
        mergedCollection.forEach(System.out::println);
    }
}


