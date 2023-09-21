package DesignPatterns.Observer.concreteClasses;

import DesignPatterns.Observer.abstractClasses.Observer;
import DesignPatterns.Observer.subjectClasses.Subject;

public class OctalObserver extends Observer {
    public Subject subject;
    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
        System.out.println("OctalObserver: OctalObserver()");
    }
    @Override
    public void update() {
     System.out.println("OctalObserver: update() " + subject.getState());
    }
}
