package edu.softserve.edu.hw10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



public class BooksCollectionTest {

    private List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", "Fantasy", 1991));
        books.add(new Book("Title2", "Author2", "Romance", 2013));
        books.add(new Book("Title3", "Author3", "Science fiction", 2015));
        books.add(new Book("Title4", "Author4", "Romance", 2022));
    }

    @Test
    public void testPrintAuthors() {
        List<String> authors = BooksCollection.printAuthors(books);
        assertEquals(4, authors.size());
        assertTrue(authors.contains("Author1"));
        assertTrue(authors.contains("Author2"));

    }

    @Test
    public void testAuthorsByGenre() {
        List<String> authors = BooksCollection.listAuthorsByGenre(books, "Romance");
        assertEquals(2, authors.size());
        assertTrue(authors.contains("Author2"));
        assertTrue(authors.contains("Author4"));

    }

    @Test
    public void testAuthorsByPublicationYear() {
        List<String> authors = BooksCollection.listAuthorsByPublicationYear(books, 2022);

        assertEquals(1, authors.size());
        assertTrue(authors.contains("Author4"));

    }

    @Test

    public void testFindBookByAuthor() {

        List<Book> foundBooks = BooksCollection.findBookByAuthor(books, "Author2");

        assertEquals(1, foundBooks.size());
        assertEquals("Title2", foundBooks.get(0).getTitle());


    }

    @Test
    public void testFindBooksByPublicationYear() {
        List<Book> foundBooks = BooksCollection.findBooksByPublicationYear(books, 2015);
        assertEquals(1, foundBooks.size());
        assertEquals("Title3", foundBooks.get(0).getTitle());
    }

    @Test
    public void testFindBooksByGenre() {
        List<Book> foundBooks = BooksCollection.findBooksByGenre(books, "Romance");
        assertEquals(2, foundBooks.size());
        assertTrue(foundBooks.stream().anyMatch(b -> b.getTitle().equals("Title2")));
        assertTrue(foundBooks.stream().anyMatch(b -> b.getTitle().equals("Title4")));
    }

    @Test
    public void testRemoveBooksByAuthor() {
        BooksCollection.removeBooksByAuthor(books, "Author2");
        assertEquals(3, books.size());
        assertFalse(books.stream().anyMatch(b -> b.getAuthor().equalsIgnoreCase("Author2")));
    }

    @Test
    public void testSortBooksByTitle() {
        BooksCollection.sortBooks(books, "title");
        assertEquals("Title1", books.get(0).getTitle());
        assertEquals("Title4", books.get(books.size() - 1).getTitle());
    }

    @Test
    public void testMergeCollections() {
        List<Book> moreBooks = new ArrayList<>();
        moreBooks.add(new Book("Title5", "Author3", "Fantasy", 1979));

        BooksCollection.mergeCollections(books, moreBooks);

        assertEquals(5, books.size());
        assertTrue(books.stream().anyMatch(b -> b.getTitle().equals("Title5")));
    }

    @Test
    public void testSubcollectionByGenre() {
        List<Book> fantasyBooks = BooksCollection.subcollectionByGenre(books, "Fantasy");
        assertEquals(1, fantasyBooks.size());
        assertEquals("Title1", fantasyBooks.get(0).getTitle());
    }
}










    