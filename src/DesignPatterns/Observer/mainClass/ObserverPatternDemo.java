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

        HexaObserver hexa =new HexaObserver(subject);
        OctalObserver octal = new OctalObserver(subject);
        BinaryObserver binary= new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        //Now here unsubscribe the observer using the detach method of the subject class
        subject.detach(hexa);

        //now change the state of the subject class and notify the 2 observers octal and binary which are still subscribed
        System.out.println("Second state change: 10");
        subject.setState(10);



    }
}
