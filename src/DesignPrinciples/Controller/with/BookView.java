package DesignPrinciples.Controller.with;

public class BookView {
 public static void main(String[] args) {
  BookController bookController = new BookController();

  //add book
  bookController.setBookName("Java Programming");
  bookController.setBookAuthor("James Gosling");
  bookController.setBookPrice(100.00);

  //display book
  System.out.println("Book Name: " + bookController.getBookName());
  System.out.println("Book Author: " + bookController.getBookAuthor());
  System.out.println("Book Price: " + bookController.getBookPrice());
 }
}
