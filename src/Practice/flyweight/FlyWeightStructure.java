package Practice.flyweight;
/*
   Flyweight Pattern - Structural Pattern

    Intent:
    Use sharing to support large numbers of fine-grained objects efficiently.

    Participants:
        Flyweight
            ❍ declares an interface through which flyweights can receive and act on extrinsic state.
        ConcreteFlyweight
            ❍ implements the Flyweight interface and adds storage for intrinsic state, if any. A ConcreteFlyweight
            object must be sharable. Any state it stores must be intrinsic; that is, it must be independent of the
            ConcreteFlyweight object’s context.
        UnsharedConcreteFlyweight
            ❍ not all Flyweight subclasses need to be shared. The Flyweight interface enables sharing, but it
            doesn’t enforce it. It is common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight
            objects as children at some level in the flyweight object structure (as the Row and Column classes
            have).
        FlyweightFactory
            ❍ creates and manages flyweight objects.
            ❍ ensures that flyweights are shared properly. When a client requests a flyweight, the FlyweightFactory
            object supplies an existing instance or creates one, if none exists.
        Client
            ❍ maintains a reference to flyweight(s).
            ❍ computes or stores the extrinsic state of flyweight(s).


    Collaborations:
        Clients should not instantiate ConcreteFlyweights directly. Clients must obtain ConcreteFlyweight
        objects exclusively from the FlyweightFactory object to ensure they are shared properly.
        When a client requests a ConcreteFlyweight, the FlyweightFactory object supplies an existing instance
        or creates one, if none exists.

 */
import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Flyweight {
    // Extrinsic state : state is independent of the flyweight's context
    void operation(int extrinsicState);
}

// ConcreteFlyweight
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState; // Shared intrinsic state

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(int extrinsicState) {
        System.out.println("Concrete Flyweight: Intrinsic State: " + intrinsicState + ", Extrinsic State: " + extrinsicState);
    }
}

// UnsharedConcreteFlyweight
class UnsharedConcreteFlyweight implements Flyweight {
    private String intrinsicState; // Unshared intrinsic state

    public UnsharedConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(int extrinsicState) {
        System.out.println("Unshared Concrete Flyweight: Intrinsic State: " + intrinsicState + ", Extrinsic State: " + extrinsicState);
    }
}

// Flyweight Factory
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        return flyweights.computeIfAbsent(key, k -> {
            // Create and manage flyweight objects
            if (k.equals("shared")) {
                return new ConcreteFlyweight("Shared");
            } else {
                return new UnsharedConcreteFlyweight("Unshared");
            }
        });
    }
}

// Client
class FlyWeightStructure {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        // Shared flyweight used by multiple clients
        Flyweight sharedFlyweight = factory.getFlyweight("shared");
        sharedFlyweight.operation(10);

        // Unshared flyweight used by a single client
        Flyweight unsharedFlyweight = factory.getFlyweight("unshared");
        unsharedFlyweight.operation(20);
    }
}