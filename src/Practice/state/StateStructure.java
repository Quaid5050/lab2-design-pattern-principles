package Practice.state;/*
    State Design Pattern : Behavioral Pattern

    Intent:
    Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

    Participants:
        Context
            ❍ defines the interface of interest to clients.
            ❍ maintains an instance of a ConcreteState subclass that defines the current state.
        State
            ❍ defines an interface for encapsulating the behavior associated with a particular state of the Context.
        ConcreteState subclasses
            ❍ each subclass implements a behavior associated with a state of Context.

    Collaborations:
        Context delegates state-specific requests to the current ConcreteState object.
        A context may pass itself as an argument to the State object handling the request. This lets the State object
        access the context if necessary.
 */


// Context
class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

// State
interface State {
    void handle();
}

// ConcreteStateA
class ConcreteStateA implements State {
    @Override
    public void handle() {
        System.out.println("ConcreteStateA");
    }
}

// ConcreteStateB
class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("ConcreteStateB");
    }
}

// Client
class StateClient {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request();

        context.setState(new ConcreteStateB());
        context.request();

        context.setState(new ConcreteStateA());
        context.request();

    }
}
public class StateStructure {
    public static void main(String[] args) {
        StateClient.main(args);

    }
}