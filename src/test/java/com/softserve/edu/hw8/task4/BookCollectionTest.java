package com.softserve.edu.hw8.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookCollectionTest {

    @Test
    void testMergeCollections() {
        // Create books
        Book book1 = new Book("Book One", "Author One", "Fiction", 1999);
        Book book2 = new Book("Book Two", "Author Two", "Fantasy", 2005);
        Book book3 = new Book("Book Three", "Author One", "Fantasy", 2005);
        Book book4 = new Book("Book Four", "Author Three", "Science Fiction", 2010);

        // Create book collections
        List<Book> collection1 = new ArrayList<>(Arrays.asList(book1, book2));
        List<Book> collection2 = new ArrayList<>(Arrays.asList(book3, book4));

        // Create a BookCollection instance
        BookCollection bookCollection = new BookCollection();

        // Merge the collections
        List<Book> mergedCollection = bookCollection.mergeCollections(collection1, collection2);

        // Print the merged collection for debugging
        System.out.println("Merged Collection:");
        mergedCollection.forEach(System.out::println);

        // Assertions to verify the merged collection
        assertEquals(4, mergedCollection.size(), "The merged collection should have 4 books");
        assertTrue(mergedCollection.containsAll(Arrays.asList(book1, book2, book3, book4)),
                "The merged collection should contain all books from both collections");
    }
}


