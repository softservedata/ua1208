package com.softserve.edu.hw08.task04;

import java.util.ArrayList;
import java.util.List;


public class BooksCollection {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", "Fantasy", 1991));
        books.add(new Book("Title2", "Author2", "Romance", 2013));
        books.add(new Book("Title3", "Author3", "Science fiction", 2015));
        books.add(new Book("Title4", "Author4", "Romance", 2022));

        printAuthors(books);

        listAuthorsByGenre(books, "Romance");

        listAuthorsByPublicationYear(books, 2022);

        findBookByAuthor(books, "Author2");

        findBooksByPublicationYear(books, 2015);

        findBooksByGenre(books, "Romance");

        removeBooksByAuthor(books, "Author2");
        System.out.println("Books after removal: " + books);

        sortBooks(books, "title");
        System.out.println("Books sorted by title: " + books);

        List<Book> moreBooks = new ArrayList<>();
        moreBooks.add(new Book("Title5", "Author3", "Fantasy", 1979));
        mergeCollections(books, moreBooks);
        System.out.println("Merged book collection: " + books);

        List<Book> fictionBooks = subcollectionByGenre(books, "Fantasy");
        System.out.println("Subcollection of Fantasy books: " + fictionBooks);
    }

    // Друкуємо список авторів
    private static void printAuthors(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.getAuthor());
        }
    }

    // Друкуємо авторів за жанром
    private static void listAuthorsByGenre(List<Book> books, String genre) {
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book.getAuthor());
            }
        }
    }

    // Друкуємо авторів за роком публікації
    private static void listAuthorsByPublicationYear(List<Book> books, int year) {
        for (Book book : books) {
            if (book.getYear() == year) {
                System.out.println(book.getAuthor());
            }
        }
    }

    // Знаходимо книгу за автором
    private static void findBookByAuthor(List<Book> books, String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    // Знаходимо книги за роком публікації
    private static void findBooksByPublicationYear(List<Book> books, int year) {
        for (Book book : books) {
            if (book.getYear() == year) {
                System.out.println(book);
            }
        }
    }

    // Знаходимо книги за жанром
    private static void findBooksByGenre(List<Book> books, String genre) {
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book);
            }
        }
    }

    // Видаляємо книги за автором
    private static void removeBooksByAuthor(List<Book> books, String author) {
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    // Сортуємо колекцію за критерієм
    private static void sortBooks(List<Book> books, String criterion) {
        switch (criterion.toLowerCase()) {
            case "title":
                books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
                break;
            case "author":
                books.sort((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
                break;
            case "year":
                books.sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
                break;
            default:
                System.out.println("Unknown criterion: " + criterion);
                break;
        }
    }

    // Об'єднуємо дві колекції
    private static void mergeCollections(List<Book> target, List<Book> source) {
        target.addAll(source);
    }

    // Підколекція книг за жанром
    private static List<Book> subcollectionByGenre(List<Book> books, String genre) {
        List<Book> subcollection = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                subcollection.add(book);
            }
        }
        return subcollection;
    }
}