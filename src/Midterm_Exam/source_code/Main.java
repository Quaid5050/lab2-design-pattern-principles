package Midterm_Exam.source_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "Computer Science", 2));
        students.add(new Student(2, "Bob", "Electrical Engineering", 3));
        students.add(new Student(3, "Charlie", "Mechanical Engineering", 1));
        students.add(new Student(4, "Diana", "Physics", 2));

        Map<Integer, Computer> computers = new HashMap<>();
        computers.put(1, new Computer(1, "Linux", "Programming Tools"));
        computers.put(2, new Computer(2, "Windows", "Office Suite"));
        computers.put(3, new Computer(3, "Linux", "Engineering Software"));
        computers.put(4, new Computer(4, "Windows", "Data Analysis Tools"));


        OddRegAllocationStrategy oddRegStrategy = new OddRegAllocationStrategy();
        EvenRegAllocationStrategy evenRegStrategy = new EvenRegAllocationStrategy();


        oddRegStrategy.allocateComputers(students, computers);
        evenRegStrategy.allocateComputers(students, computers);


        Container oddContainer = new OddRegContainer(oddRegStrategy);
        Container evenContainer = new EvenRegContainer(evenRegStrategy);

        System.out.println("Details for Odd Registration:");
        printDetails(oddContainer.getIterator());

        System.out.println("\nDetails for Even Registration:");
        printDetails(evenContainer.getIterator());
    }

    private static void printDetails(DetailsIterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
