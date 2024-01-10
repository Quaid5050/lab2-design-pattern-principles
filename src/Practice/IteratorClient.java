package Practice;
/*
        Iterator design pattern : Behavioral design pattern

        Intent:
            Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

        Participants:
            Iterator :
                This defines an interface for accessing and traversing elements.

                ConcreteIterator :
                This implements the Iterator interface. Keeps track of the current position in
                the traversal of the aggregate.

            IterableCollection :
                This defines an interface for creating an Iterator object.
                ConcreteIterableCollection :
                This implements the IterableCollection interface. This is the class that creates
                the ConcreteIterator object.

             Client :
                This is the class that uses the Iterator interface.
 */

import java.util.ArrayList;
import java.util.List;

//Iterator
interface Iterator<T> {
    boolean hasNext();
    T next();
}


// Student class
class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

// Iterable Collection Interface
interface IterableCollection {
    Iterator<Student> createIterator();
}

// Concrete Student List Collection
class StudentList implements IterableCollection {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Iterator<Student> createIterator() {
        return new StudentIterator(students);
    }
}



// Concrete Iterator for Student List
class StudentIterator implements Iterator<Student> {
    private List<Student> students;
    private int position;

    public StudentIterator(List<Student> students) {
        this.students = students;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        if (hasNext()) {
            Student student = students.get(position);
            position++;
            return student;
        }
        return null;
    }
}

public class IteratorClient {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        studentList.addStudent(new Student("Alice", 101));
        studentList.addStudent(new Student("Bob", 102));
        studentList.addStudent(new Student("Charlie", 103));



        Iterator<Student> iterator = studentList.createIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("Student Name: " + student.getName() + ", ID: " + student.getId());
        }
    }
}
