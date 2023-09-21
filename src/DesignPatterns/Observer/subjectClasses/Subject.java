package DesignPatterns.Observer.subjectClasses;

import DesignPatterns.Observer.abstractClasses.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
     private List<Observer> observers = new ArrayList<Observer>();
     private int state;

     public int getState() {
         return state;
     }

     public void setState(int state) {
         this.state = state;
         notifyAllObservers();
     }

     public void attach(Observer observer){
        observers.add(observer);
     }

     public void notifyAllObservers(){
         for (Observer observer : observers) {
           observer.update();
         }
     }

     public void detach(Observer observer){
         System.out.println("Subject: before detach()");
         System.out.println("Size: observer = " + observers.size());
         System.out.println("Subject: observers = " + observers);

         //Unsubscribe the observer
         observers.remove(observer);

         System.out.println("Subject: after detach()");
         System.out.println("Size: observer = " + observers.size());
         System.out.println("Subject: observers = " + observers);

     }

}
