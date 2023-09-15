package InformationExpert.without;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create a new library
        Library library1 = new Library();
        library1.addLibrary("Central Library", "123 Main St", 1);

        // Create another library
        Library library2 = new Library();
        library2.addLibrary("Community Library", "456 Elm St", 2);

        // Add books to the libraries
        library1.addBook("Introduction to Java", 29.99, 10, "Programming");
        library1.addBook("Data Structures and Algorithms", 39.99, 5, "Programming");
        library2.addBook("History of Science", 19.99, 8, "History");

        // Print the list of books
        System.out.println("List of books:");
        library1.printBooks();
        library2.printBooks();

        // Print the list of libraries
        System.out.println("List of libraries:");
        library1.printLibrary();
        library2.printLibrary();
    }
}