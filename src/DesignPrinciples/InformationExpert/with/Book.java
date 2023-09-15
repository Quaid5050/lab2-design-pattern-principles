package DesignPrinciples.InformationExpert.with;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String bookName;
    private double bookPrice;
    private int bookQuantity;
    private String bookCategory;
    private int librariesId;

    private static List<Book> bookList = new ArrayList<>();

    public Book() {
    }

    // Method to add a new book to the list
    public void addBook(String bookName, double bookPrice, int bookQuantity, String bookCategory, int librariesId) {
        Book book = new Book();
        book.bookName = bookName;
        book.bookPrice = bookPrice;
        book.bookQuantity = bookQuantity;
        book.bookCategory = bookCategory;
        book.librariesId = librariesId;
        bookList.add(book);
    }

    // Getter method to retrieve the list of books
    public static List<Book> getBooksList() {
        return bookList;
    }

    //print the arrayliost of booklist
    public static void printBookList() {
        for (Book book : bookList) {
            System.out.println(book.bookName + " " + book.bookPrice + " " + book.bookQuantity + " " + book.bookCategory + " " + book.librariesId);
        }
    }

}
