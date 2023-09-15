package InformationExpert.with;

//use of information expert class Book here

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String libraryName;
    private String libraryAddress;
    private int libraryId;

    private static List<Library>  librariesList = new ArrayList<>();

    public Library() {
    }

    // Method to add a new library to the list
    public void addLibrary(String libraryName, String libraryAddress, int libraryId) {
        Library library = new Library();
        library.libraryName = libraryName;
        library.libraryAddress = libraryAddress;
        library.libraryId = libraryId;
        Library.getLibrariesList().add(library);
    }

    // Getter method to retrieve the list of libraries
    public static List<Library> getLibrariesList() {
        return librariesList;
    }

    //print library list
    public static void printLibraryList() {
        for (Library library : librariesList) {
            System.out.println(library.libraryName + " " + library.libraryAddress + " " + library.libraryId);
        }
    }

}