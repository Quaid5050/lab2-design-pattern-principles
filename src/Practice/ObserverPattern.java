package Practice;


import java.util.ArrayList;
import java.util.List;



//template method patter
abstract class ComplaintTemplate {


    // Abstract method to be implemented by concrete subclasses
    public abstract void complain();

    // Common step for resolution
    public void resolve() {
        System.out.println("Complaint resolved");
    }

    @Override
    public String toString() {
        return "Complaint Template";
    }

    public void submitComplaint() {
        System.out.println("Submit complaint");



    }

}

class CookComplaint extends ComplaintTemplate {

    @Override
    public void complain() {
        System.out.println("Complain about the cook");
        submitComplaint();
    }


}

class WaiterComplaint extends ComplaintTemplate {

    @Override
    public void complain() {
        System.out.println("Complain about the waiter");
    }
}

class Customer{
    Customer(){
        System.out.println("Customer");
    }
    public void complaint() {
        System.out.println("Complaint from customer");
        ComplaintTemplate complaint = new CookComplaint();
        complaint.complain();
    }


}
interface RestaurantInterface {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
class Restaurant {
    private List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer o: observers) {
            o.update();
        }
    }
}



interface Observer {
    void update();
}

class Owner implements Observer {
    public void update() {
        System.out.println("Owner notified");
    }
}
class Cook implements Observer {
    public void update() {
        System.out.println("Cook notified");
    }
}
class Waiter implements Observer {
    public void update() {
        System.out.println("Waiter notified");
    }
}



public class ObserverPattern {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Observer owner = new Owner();
        Observer cook = new Cook();
        Observer waiter = new Waiter();

        restaurant.registerObserver(owner);
        restaurant.registerObserver(cook);
        restaurant.registerObserver(waiter);

        Customer customer = new Customer();
        customer.complaint();

    }
}