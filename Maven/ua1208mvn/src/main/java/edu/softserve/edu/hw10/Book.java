package edu.softserve.edu.hw10;

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

        public int getYear() {
            return year;
        }

        public String getGenre() {
            return genre;
        }

        public String getAuthor() {
            return author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book:" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    ", year=" + year ;
        }
    }

