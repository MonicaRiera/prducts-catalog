package tech.bts.books;

public class Book {

    String title;
    String author;
    int numPages;

    public Book (String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    public String toString () {
        return this.title + " - " + this.author + " - " + this.numPages + " pages.";
    }
}
