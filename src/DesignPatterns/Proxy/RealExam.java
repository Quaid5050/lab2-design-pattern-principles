package DesignPatterns.Proxy;


import java.util.ArrayList;
import java.util.List;

public class RealExam implements Exam {
    private List<String> examResults = new ArrayList<>();

    public RealExam() {
        // Simulate loading exam details (questions, etc.) from a database or file
        // For example:
        examResults.add("Question 1: ____");
        examResults.add("Question 2: ____");
        // Loading more exam details...
    }

    @Override
    public void showResults(Student student) {
        // Simulate student adding their answers to the exam
        // For example:
        examResults.add("Student " + student.getName() + "'s Answers: ");
        // Student adds their answers...
        System.out.println("Showing results for student: " + student.getName());
        System.out.println("Results: " + examResults);
    }

    @Override
    public void showResults(Teacher teacher) {
        // For a teacher, display all students' exam results
        System.out.println("Showing results for teacher:");
        System.out.println("Results: " + examResults);
    }
}

