package DesignPatterns.Proxy;

import java.util.ArrayList;
import java.util.List;

public class ExamResults implements Exam {
    private RealExam realExam;
    private List<String> studentResults = new ArrayList<>();

    public ExamResults(RealExam realExam) {
        this.realExam = realExam;
    }

    @Override
    public void showResults(Student student) {
        realExam.showResults(student); // Delegate to RealExam to add student's answers
    }

    @Override
    public void showResults(Teacher teacher) {
        realExam.showResults(teacher); // Delegate to RealExam to show all students' results
    }
}
