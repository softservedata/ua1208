package com.softserve.pt_hw_07.task_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }


    public static void printAuthorsByGenre(List<Book> books, String genre) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                authors.add(book.getAuthor());
            }
        }

        System.out.println("Authors who have written books in the genre \"" + genre + "\":");
        for (String author : authors) {
            System.out.println(author);
        }
    }

    public static void printAuthorsByYear(List<Book> books, int year) {
        Set<String> authors = books.stream()
                .filter(book -> book.getYear() == year)
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

        System.out.println("Authors who have written books in the '" + year + "':");
        for (String author : authors) {
            System.out.println(author);
        }
    }

    public static Book findBookByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .findFirst()
                .orElse(null);
    }

    public static List<Book> findBooksByYear(List<Book> books, int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public static List<Book> findBooksByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public static void removeBooksByAuthor(List<Book> books, String author) {
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    public static void sortBooks(List<Book> books, Comparator<Book> criterion) {
        books.sort(criterion);
    }

    public static List<Book> mergeBookCollections(List<Book> collection1, List<Book> collection2) {
        List<Book> mergedCollection = new ArrayList<>(collection1);
        mergedCollection.addAll(collection2);
        return mergedCollection;
    }

    public static List<Book> subCollectionByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
