package DesignPatterns.Observer.concreteClasses;
import DesignPatterns.Observer.abstractClasses.Observer;
import DesignPatterns.Observer.subjectClasses.Subject;

public class BinaryObserver extends Observer {
    public Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
        System.out.println("BinaryObserver: BinaryObserver()");
    }
    @Override
    public void update() {
     System.out.println("BinaryObserver: update() " + subject.getState());
    }

}
