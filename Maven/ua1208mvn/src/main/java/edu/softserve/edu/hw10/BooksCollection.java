package edu.softserve.edu.hw10;

import java.util.ArrayList;
import java.util.List;

public class BooksCollection {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", "Fantasy", 1991));
        books.add(new Book("Title2", "Author2", "Romance", 2013));
        books.add(new Book("Title3", "Author3", "Science fiction", 2015));
        books.add(new Book("Title4", "Author4", "Romance", 2022));

        // Example usage
        System.out.println(printAuthors(books));
        System.out.println(listAuthorsByGenre(books, "Romance"));
        System.out.println(listAuthorsByPublicationYear(books, 2022));
        System.out.println(findBookByAuthor(books, "Author2"));
        System.out.println(findBooksByPublicationYear(books, 2015));
        System.out.println(findBooksByGenre(books, "Romance"));

        List<Book> moreBooks = new ArrayList<>();
        moreBooks.add(new Book("Title5", "Author3", "Fantasy", 1979));
        mergeCollections(books, moreBooks);
        System.out.println("Merged book collection: " + books);

        List<Book> fictionBooks = subcollectionByGenre(books, "Fantasy");
        System.out.println("Subcollection of Fantasy books: " + fictionBooks);
    }

    // Return list of authors
    public static List<String> printAuthors(List<Book> books) {
        List<String> authors = new ArrayList<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    // Return list of authors by genre
    public static List<String> listAuthorsByGenre(List<Book> books, String genre) {
        List<String> authors = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                authors.add(book.getAuthor());
            }
        }
        return authors;
    }

    // Return list of authors by publication year
    public static List<String> listAuthorsByPublicationYear(List<Book> books, int year) {
        List<String> authors = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                authors.add(book.getAuthor());
            }
        }
        return authors;
    }

    // Return book by author
    public static List<Book> findBookByAuthor(List<Book> books, String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Return books by publication year
    public static List<Book> findBooksByPublicationYear(List<Book> books, int year) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Return books by genre
    public static List<Book> findBooksByGenre(List<Book> books, String genre) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Remove books by author
    public static void removeBooksByAuthor(List<Book> books, String author) {
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    // Sort collection by criterion
    public static void sortBooks(List<Book> books, String criterion) {
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

    // Merge two collections
    public static void mergeCollections(List<Book> target, List<Book> source) {
        target.addAll(source);
    }

    // Return subcollection of books by genre
    public static List<Book> subcollectionByGenre(List<Book> books, String genre) {
        List<Book> subcollection = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                subcollection.add(book);
            }
        }
        return subcollection;
    }

   }
