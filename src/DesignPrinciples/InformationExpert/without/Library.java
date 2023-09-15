package DesignPrinciples.InformationExpert.without;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private String libraryAddress;
    private int libraryId;
    private List<Book> booksList = new ArrayList<>();

    public Library() {
    }

    // Method to add a new library to the list
    public void addLibrary(String libraryName, String libraryAddress, int libraryId) {
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.libraryId = libraryId;
    }

    // Method to add a book to the library
    public void addBook(String bookName, double bookPrice, int bookQuantity, String bookCategory) {
        Book book = new Book(bookName, bookPrice, bookQuantity, bookCategory);
        booksList.add(book);
    }

    //print library information
    public void printLibrary() {
        System.out.println(libraryName + " " + libraryAddress + " " + libraryId);
    }

    //print the books in the library
    public void printBooks() {
        for (Book book : booksList) {
            System.out.println(book.getBookName() + " " + book.getBookPrice() + " " + book.getBookQuantity() + " " + book.getBookCategory());
        }
    }
}