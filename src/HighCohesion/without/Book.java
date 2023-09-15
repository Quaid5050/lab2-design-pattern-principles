package HighCohesion.without;

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

    // Low Cohesion: Unrelated responsibilities in the same class
    public double calculatePriceWithTax() {
        // This operation is unrelated to the book's basic information
        return 1.1 * calculateShippingCost(); // Just for illustration
    }

    public void printCoverImage() {
        // This operation is unrelated to the book's basic information
        // and doesn't belong in the Book class
        System.out.println("Printing cover image...");
    }

    private double calculateShippingCost() {
        // This operation is unrelated to the book's basic information
        // and shouldn't be part of the Book class
        return 5.0; // Just for illustration
    }

    // More unrelated methods can be added here

    // Getters for basic book information
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
