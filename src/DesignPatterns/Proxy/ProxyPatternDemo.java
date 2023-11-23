package DesignPatterns.Proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        // Task 1 - VirtualProxyImage (formerly ProxyImage) demonstration
        Image image1 = new VirtualProxyImage("test_10mb.jpg");
        Image image2 = new VirtualProxyImage("test.bmp"); // Unsupported image type

        // Display images
        image1.display(); // Should load and display test_10mb.jpg
        image2.display(); // Should display a fake image for unsupported type

        System.out.println("\n-------------\n");

        // Task 2 - Exam and ExamResults demonstration
        RealExam realExam = new RealExam(); // Loading exam details
        ExamResults examResults = new ExamResults(realExam);

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Students attempting the exam
        examResults.showResults(student1); // Student 1 attempting the exam
        examResults.showResults(student2); // Student 2 attempting the exam

        System.out.println("\n-------------\n");

        // Simulating a teacher viewing the results
        Teacher teacher = new Teacher();
        examResults.showResults(teacher); // Teacher viewing all students' results
    }
}
