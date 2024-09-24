package Home_work_08.Task04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAllAuthors() {
        books.forEach(book -> System.out.println(book.getAuthor()));
    }

    public void printAuthorsByGenre(String genre) {
        books.stream().filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .forEach(book -> System.out.println(book.getAuthor()));
    }

    public void printAuthorsByYear(int year) {
        books.stream().filter(book -> book.getYear() == year)
                .forEach(book -> System.out.println(book.getAuthor()));
    }

    public void findBookByAuthor(String author) {
        books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    public void sortBooksByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
        books.forEach(System.out::println);
    }

    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("1984", "George Orwell", "Dystopia", 1949));
        collection.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 1925));
        collection.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopia", 1932));

        System.out.println("All authors:");
        collection.printAllAuthors();

        System.out.println("\nAuthors in Dystopia genre:");
        collection.printAuthorsByGenre("Dystopia");

        System.out.println("\nAuthors published in 1949:");
        collection.printAuthorsByYear(1949);

        System.out.println("\nBooks by George Orwell:");
        collection.findBookByAuthor("George Orwell");

        System.out.println("\nBooks sorted by title:");
        collection.sortBooksByTitle();
    }
}
