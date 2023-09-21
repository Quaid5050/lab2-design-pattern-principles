package DesignPatterns.Observer.abstractClasses;

import DesignPatterns.Observer.subjectClasses.Subject;

abstract public class Observer {
    private Subject subject;
    public abstract void update();

}
