package DesignPrinciples.Controller.with;

public class BookModel {
    private String bookName;
    private String bookAuthor;
    private double bookPrice;

    public BookModel() {
    }

    public BookModel(String bookName, String bookAuthor, double bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAuthor() {
        return this.bookAuthor;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookPrice() {
        return this.bookPrice;
    }
}
