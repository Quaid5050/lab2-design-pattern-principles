package DesignPatterns.Iterator.main;

import DesignPatterns.Iterator.classes.NameRepository;
import DesignPatterns.Iterator.classes.Student;
import DesignPatterns.Iterator.interfaces.Iterator;

public class IteratorPatternDemo {
    public static void main(String[] args) {
     //new workarounds
        System.out.println("New workarounds");

        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        printAllStudents(iterator);
        System.out.println();
        iterator = nameRepository.getIterator();
        printStudentsWithNameStartingFrom(iterator, "Q");
        System.out.println();

        iterator = nameRepository.getIterator();
        printStudentsWithNameStartingFrom(iterator, "G");
        System.out.println();

    }
    public static void printStudentsWithNameStartingFrom(Iterator iterator, String startingValue) {
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            if (student.getName().startsWith(startingValue)) {
                System.out.println("Name: " + student.getName());

            }
        }
    }

    public static void printAllStudents(Iterator iterator) {
        while (iterator.hasNext()) {
            Student student = (Student) iterator.next();
            System.out.println("Name: " + student.getName());
            System.out.println("RegNo: " + student.getRegNo());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Phone Number: " + student.getPhoneNumber());
            System.out.println();

        }
    }

}
