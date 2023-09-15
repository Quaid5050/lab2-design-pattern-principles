package DesignPrinciples.HighCohesion.without;

public class BookMain {
public static void main(String[] args) {
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1178, "George Allen & Unwin");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Year published: " + book.getYearPublished());
        System.out.println("Pages: " + book.getPages());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Price with tax: " + book.calculatePriceWithTax());
        book.printCoverImage();

    }
}
