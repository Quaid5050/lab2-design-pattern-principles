package DesignPatterns.Observer.mainClass;

import DesignPatterns.Observer.concreteClasses.BinaryObserver;
import DesignPatterns.Observer.concreteClasses.HexaObserver;
import DesignPatterns.Observer.concreteClasses.OctalObserver;
import DesignPatterns.Observer.subjectClasses.Subject;

public class ObserverPatternDemo
{
    public static void main(String[] args)
    {
        System.out.println("Main Class: ObserverPatternDemo");
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);



    }
}
