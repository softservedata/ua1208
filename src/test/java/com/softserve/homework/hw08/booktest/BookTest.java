package test.java.com.softserve.homework.hw08.booktest;

import main.java.com.softserve.homework.hw08.book.Book;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {
    @BeforeAll
    static void startTest() {
        System.out.println("Start test");
    }

    List<Book> books;
    private List<Book> emptyBooks;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>(Arrays.asList(
                new Book("Book A", "Author X", "Fiction", 2020),
                new Book("Book B", "Author Y", "Non-Fiction", 2021),
                new Book("Book C", "Author X", "Fiction", 2020),
                new Book("Book D", "Author Z", "Fantasy", 2022)
        ));
    }

    @ParameterizedTest
    @DisplayName("Test for finding a book by author")
    @Order(2)
    @MethodSource("authorProvider")
    void testFindBookByAuthor(String author, String expectedTitle) {
        Book foundBook = Book.findBookByAuthor(books, author);
        if (expectedTitle == null) {
            assertNull(foundBook);
        } else {
            assertNotNull(foundBook);
            assertEquals(expectedTitle, foundBook.getTitle());
        }
    }

    static Stream<Arguments> authorProvider() {
        return Stream.of(
                Arguments.of("Author X", "Book A"),
                Arguments.of("Author Y", "Book B"),
                Arguments.of("Non-Existent Author", null) // Negative case
        );
    }

    @ParameterizedTest
    @DisplayName("Test for finding books by year")
    @Order(1)
    @MethodSource("yearProvider")
    void testFindBooksByYear(int year, int expectedCount) {
        List<Book> booksByYear = Book.findBooksByYear(books, year);
        assertEquals(expectedCount, booksByYear.size());
    }

    static Stream<Arguments> yearProvider() {
        return Stream.of(
                Arguments.of(2020, 2),
                Arguments.of(2021, 1)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for finding books by genre")
    @Order(3)
    @MethodSource("genreProvider")
    void testFindBooksByGenre(String genre, int expectedCount) {
        List<Book> genreBooks = Book.findBooksByGenre(books, genre);
        assertEquals(expectedCount, genreBooks.size());
    }

    static Stream<Arguments> genreProvider() {
        return Stream.of(
                Arguments.of("Fiction", 2),
                Arguments.of("Non-Fiction", 1),
                Arguments.of("Non-Existent Genre", 0) // Negative case
        );
    }

    @ParameterizedTest
    @DisplayName("Test for Removing book from list")
    @Order(7)
    @MethodSource("removeBookProvider")
    void removeBookFromList(String authorBook, int expectedSizeAfterRemoval) {
        Book.removeBooksByAuthor(books, authorBook);
        assertEquals(expectedSizeAfterRemoval, books.size());
    }

    static Stream<Arguments> removeBookProvider() {
        return Stream.of(
                Arguments.of("Author X", 2),
                Arguments.of("Author Y", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for sorting books by year")
    @Order(6)
    @MethodSource("sortProvider")
    void testSortBooks(Comparator<Book> comparator, int firstYear, int lastYear) {
        Book.sortBooks(books, comparator);
        assertEquals(firstYear, books.getFirst().getYear());
        assertEquals(lastYear, books.getLast().getYear());
    }

    static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(Comparator.comparing(Book::getYear), 2020, 2022)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for merging book collections")
    @Order(4)
    @MethodSource("mergeCollectionProvider")
    void testMergeBookCollections(List<Book> newBooks, int expectedSize) {
        List<Book> mergedBooks = Book.mergeBookCollections(books, newBooks);
        assertEquals(expectedSize, mergedBooks.size());
    }

    static Stream<Arguments> mergeCollectionProvider() {
        List<Book> newBooks = Arrays.asList(
                new Book("Book E", "Author M", "Fiction", 2021),
                new Book("Book F", "Author N", "Non-Fiction", 2022)
        );
        return Stream.of(
                Arguments.of(newBooks, 6)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for sub-collection by genre")
    @Order(5)
    @MethodSource("subCollectionGenreProvider")
    void testSubCollectionByGenre(String genre, int expectedCount) {
        List<Book> genreBooks = Book.subCollectionByGenre(books, genre);
        assertEquals(expectedCount, genreBooks.size());
    }

    static Stream<Arguments> subCollectionGenreProvider() {
        return Stream.of(
                Arguments.of("Fiction", 2),
                Arguments.of("Fantasy", 1)
        );
    }

    @AfterAll
    static void completeTest() {
        System.out.println("Complete test");
    }
}
