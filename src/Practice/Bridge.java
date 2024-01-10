
//Bridge design pattern
/*
Intent:
The Bridge design pattern aims to decouple an abstraction from its implementation, allowing both to vary
independently.

Participants:
Abstraction:
    Defines the abstraction's interface and maintains a reference to the implementor.
RefinedAbstraction:
    Extends the abstraction, providing specific implementations using the Implementor interface.
Implementor:
    Declares the interface for implementation classes.
ConcreteImplementorA/B:
    Implements the Implementor interface, providing concrete implementations.

Explanation:
The code illustrates the Bridge pattern:
Abstraction serves as an abstract class defining an interface and holding a reference to an Implementor.
RefinedAbstraction extends Abstraction and implements the operation() method by forwarding the call to the Implementor.
Implementor declares the interface for concrete implementations (ConcreteImplementorA and ConcreteImplementorB).
ConcreteImplementorA/B implement the operation() method according to their specific behaviors.
 */
abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor){
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor){
        super(implementor);
    }

    @Override
    public void operation(){
        implementor.operation();
    }
}

interface Implementor {
    void operation();
}

class ConcreteImplementorA implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorA operation");
    }
}

class ConcreteImplementorB implements Implementor {
    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB operation");
    }
}


class Client {
    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction(new ConcreteImplementorA());
        abstraction.operation();

        abstraction = new RefinedAbstraction(new ConcreteImplementorB());
        abstraction.operation();
    }
}


