package Task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookCollection myCollection = new BookCollection();
        myCollection.addBook(new Book("Title1", "Author1", "Genre1", 2001));
        myCollection.addBook(new Book("Title2", "Author2", "Genre2", 2002));
        myCollection.addBook(new Book("Title3", "Author1", "Genre1", 2001));

        // Print list of authors
        myCollection.printListOfAuthors();

        // List authors by genre
        myCollection.listAuthorsByGenre("Genre1");

        // Find books by publication year
        myCollection.findBooksByPublicationYear(2001);

        // Remove books by author
        myCollection.removeBooksByAuthor("Author1");

        // Sort by title
        myCollection.sortCollectionBy("title");

        // Merge two collections
        BookCollection anotherCollection = new BookCollection();
        anotherCollection.addBook(new Book("Title4", "Author3", "Genre3", 2003));
        BookCollection mergedCollection = BookCollection.mergeCollections(myCollection, anotherCollection);

        // Create subcollection by genre
        List<Book> genreSubcollection = myCollection.subcollectionByGenre("Genre2");
        genreSubcollection.forEach(System.out::println);
    }
}


