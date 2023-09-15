package HighCohesion.with;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String publisher;

    public Book(String title, String author, int year, int pages, String publisher) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }
}
