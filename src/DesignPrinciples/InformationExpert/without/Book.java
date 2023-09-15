package DesignPrinciples.InformationExpert.without;
public class Book {
    private String bookName;
    private double bookPrice;
    private int bookQuantity;
    private String bookCategory;

    public Book(String bookName, double bookPrice, int bookQuantity, String bookCategory) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookCategory = bookCategory;
    }

    public String getBookName() {
        return bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public String getBookCategory() {
        return bookCategory;
    }
}