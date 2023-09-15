package InformationExpert.with;

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
        Book book1 = new Book();
        book1.addBook("Introduction to Java", 29.99, 10, "Programming", 1);

        Book book2 = new Book();
        book2.addBook("Data Structures and Algorithms", 39.99, 5, "Programming", 1);

        Book book3 = new Book();
        book3.addBook("History of Science", 19.99, 8, "History", 2);

        List<Book> booksList = Book.getBooksList();
        List<Library> librariesList = Library.getLibrariesList();

        // Print the list of books
        System.out.println("List of books:");
        Book.printBookList();

        //print the list of libraries
        System.out.println("List of libraries:");
        Library.printLibraryList();
    }
}
