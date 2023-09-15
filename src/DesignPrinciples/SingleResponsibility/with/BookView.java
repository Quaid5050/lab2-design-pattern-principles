package DesignPrinciples.SingleResponsibility.with;

public class BookView {
    public static void main(String[] args) {
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1178);
        book.displayBookDetails();
    }
}
