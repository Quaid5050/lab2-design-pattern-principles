package DesignPatterns.Observer.concreteClasses;
import DesignPatterns.Observer.abstractClasses.Observer;
import DesignPatterns.Observer.subjectClasses.Subject;

public class HexaObserver extends Observer {
    public Subject subject;
    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
        System.out.println("HexaObserver: HexaObserver()");
    }
    @Override
    public void update() {
        System.out.println("HexaObserver: update() " + subject.getState());
    }

}