package Task4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection {
    private List<Book> books = new ArrayList<>();

    // Add a book to the collection
    public void addBook(Book book) {
        books.add(book);
    }

    // Print list of authors
    public void printListOfAuthors() {
        books.stream()
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    // List authors by genre
    public void listAuthorsByGenre(String genre) {
        books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    // List authors by publication year
    public void listAuthorsByPublicationYear(int year) {
        books.stream()
                .filter(book -> book.getYear() == year)
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    // Find a book by author
    public void findBookByAuthor(String author) {
        books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    // Find books by publication year
    public void findBooksByPublicationYear(int year) {
        books.stream()
                .filter(book -> book.getYear() == year)
                .forEach(System.out::println);
    }

    // Find books by genre
    public void findBooksByGenre(String genre) {
        books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .forEach(System.out::println);
    }

    // Remove books by author
    public void removeBooksByAuthor(String author) {
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    // Sort collection by a given criterion
    public void sortCollectionBy(String criterion) {
        switch (criterion.toLowerCase()) {
            case "title":
                books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
                break;
            case "author":
                books.sort((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
                break;
            case "year":
                books.sort((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear()));
                break;
            default:
                System.out.println("Invalid sorting criterion.");
                return;
        }
        books.forEach(System.out::println);
    }

    // Merge two book collections
    public static BookCollection mergeCollections(BookCollection col1, BookCollection col2) {
        BookCollection merged = new BookCollection();
        merged.books.addAll(col1.books);
        merged.books.addAll(col2.books);
        return merged;
    }

    // Create a subcollection of books by genre
    public List<Book> subcollectionByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Print all books in the collection
    public void printAllBooks() {
        books.forEach(System.out::println);
    }
}

