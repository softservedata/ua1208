package Task4;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;

    // Constructor
    public Book(String title, String author, String genre, int year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', genre='" + genre + "', year=" + year + "}";
    }
}


