package Practice;

/*
  Memento Design Pattern : Behavioral Pattern
  Intent :
    Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.
    Participants :
    Originator
        ❍ creates a memento containing a snapshot of its current internal state.
        ❍ uses the memento to restore its internal state.
    Memento
        The Memento interface provides a way of retrieving the memento's metadata,
        such as creation date or name (to facilitate debugging).
    ConcreteMemento
        ❍ implements the Memento interface.
        ❍ stores internal state of the Originator object. The memento may store as much or as little of the originator's internal state as necessary at its originator's discretion.
     Caretaker
        ❍ is responsible for the memento's safekeeping.
        ❍ never operates on or examines the contents of a memento.

 */

import java.util.ArrayList;
import java.util.List;

class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
// Memento
class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
// Caretaker
class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
class MementoStructure {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}