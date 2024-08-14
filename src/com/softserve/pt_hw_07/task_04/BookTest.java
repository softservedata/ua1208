package com.softserve.pt_hw_07.task_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookTest {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        books.add(new Book("1984", "George Orwell", "Dystopian", 1949));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", "Adventure", 1851));

        // Print the list of all authors in the collection
        System.out.println("List of authors:");
        books.forEach(book ->
                System.out.println(book.getAuthor()));

        System.out.println("=".repeat(20));
        // Print the list of all authors by genre
        String genreToFilter = "Fiction";
        Book.printAuthorsByGenre(books, genreToFilter);

        System.out.println("=".repeat(20));
        // Find a book by a given year
        int yearToFilter = 1851;
        Book.printAuthorsByYear(books, yearToFilter);

        System.out.println("=".repeat(20));
        // Find a book by a given author
        String authorToFind = "Harper Lee";
        Book foundBook = Book.findBookByAuthor(books, authorToFind);
        System.out.println("Book by " + authorToFind + ": " + (foundBook != null ? foundBook.getTitle() : "Not found"));

        System.out.println("=".repeat(20));
        // Find all books by a given year
        List<Book> booksByYear = Book.findBooksByYear(books, yearToFilter);
        System.out.println("Books published in " + yearToFilter + ": " + booksByYear.size());

        System.out.println("=".repeat(20));
        // Find all books by a given genre
        String genreToFind = "Dystopian";
        List<Book> booksByGenre = Book.findBooksByGenre(books, genreToFind);
        System.out.println("Books in the genre '" + genreToFind + "': " + booksByGenre.size());

        System.out.println("=".repeat(20));
        // Remove all books by a given author
        String authorToRemove = "F.";
        Book.removeBooksByAuthor(books, authorToRemove);
        System.out.println("Books after removing those by " + authorToRemove + ": " + books.size());

        System.out.println("=".repeat(20));
        // Sort books by title
        Book.sortBooks(books, Comparator.comparing(Book::getTitle));
        System.out.println("Books sorted by title: ");
        books.forEach(book -> System.out.println(book.getTitle()));

        System.out.println("=".repeat(20));

        // Merge the two book collections
        List<Book> moreBooks = new ArrayList<>();
        moreBooks.add(new

                Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951));
        moreBooks.add(new

                Book("Lord of the Flies", "William Golding", "Fiction", 1954));

        List<Book> mergedBooks = Book.mergeBookCollections(books, moreBooks);
        System.out.println("Merged book collection: ");
        mergedBooks.forEach(book -> System.out.println(book.getTitle()));

        System.out.println("=".repeat(20));
        // Create a subCollection of books by genre
        List<Book> dystopianBooks = Book.subCollectionByGenre(mergedBooks, "Dystopian");
        System.out.println("Subcollection of Dystopian books: ");

        dystopianBooks.forEach(book -> System.out.println(book.getTitle()));
    }
}
