package Controller.without;

public class BookView {
    public static void main(String[] args) {
        Book book = new Book();

        // Set book details
        book.setBookName("Java Programming");
        book.setBookAuthor("James Gosling");
        book.setBookPrice(100.00);

        // Display book details
        System.out.println("Book Name: " + book.getBookName());
        System.out.println("Book Author: " + book.getBookAuthor());
        System.out.println("Book Price: " + book.getBookPrice());
    }
}