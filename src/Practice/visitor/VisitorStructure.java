

/*
    Visitor Design Pattern : Behavioral Pattern

    Intent:
        Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new
        operation without changing the classes of the elements on which it operates.

    Participants:
        Visitor:
            this declares a Visit operation for each class of ConcreteElement in the object structure. The operation’s
            name and signature identifies the class that sends the Visit request to the visitor. That lets the visitor
            determine the concrete class of the element being visited. Then the visitor can access the elements directly
            through its particular interface.

            ConcreteVisitor:
                this implements each operation declared by Visitor. Each operation implements a fragment of the algorithm
                defined for the corresponding class or object in the structure. ConcreteVisitor provides the context for the
                algorithm and stores its local state. This state often accumulates results during the traversal of the
                structure.

        Element:
            this defines an Accept operation that takes a visitor as an argument.
            ConcreteElement:
                this implements an Accept operation that takes a visitor as an argument.

         Client:
            this creates ConcreteVisitor objects and passes each to Element objects by calling Accept.

 */
// Visitor
interface Visitor {
    void visitConcreteElementA(ConcreteElementA concreteElementA);
    void visitConcreteElementB(ConcreteElementB concreteElementB);
}

// ConcreteVisitorA
class ConcreteVisitorA implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorA: " + concreteElementA.getClass().getSimpleName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorA: " + concreteElementB.getClass().getSimpleName());
    }
}

// ConcreteVisitorB

class ConcreteVisitorB implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorB: " + concreteElementA.getClass().getSimpleName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorB: " + concreteElementB.getClass().getSimpleName());
    }
}

// Element
interface Element{
    void accept(Visitor visitor);
    void operation();
}

// ConcreteElementA
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteElementA");
    }
}

// ConcreteElementB
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    @Override
    public void operation() {
        System.out.println("ConcreteElementB");
    }
}

// ObjectStructure
class ObjectStructure {
    private Element[] elements;

    public ObjectStructure() {
        elements = new Element[]{new ConcreteElementA(), new ConcreteElementB()};
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

// Client
class VisitorClient {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.accept(new ConcreteVisitorA());
        objectStructure.accept(new ConcreteVisitorB());
    }
}

public class VisitorStructure {
    public static void main(String[] args) {
        System.out.println("Visitor Design Pattern");
        VisitorClient.main(args);
    }
}
