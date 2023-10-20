package DesignPatterns.Mediator;

public class MediatorPatternDemo {
    private static Teacher Teacher;
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");

        Userinterface teacher1 = new Teacher("Alex");
        Userinterface teacher2 = new Teacher("JohnSmith");

        robert.sendMessage(john, "hi dear how are you");
        john.sendMessage(robert, "i am fine what about you");
        teacher1.sendMessage(john, "why are you late");
        teacher2.sendMessage(robert, "are you done with your homework");


    }
}