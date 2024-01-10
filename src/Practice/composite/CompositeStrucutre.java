package Practice.composite;
/*
       Composite Design Pattern : Structural Pattern

         Intent:
            Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat
            individual objects and compositions of objects uniformly.

         Participants:
            Component
                ❍ declares the interface for objects in the composition.
                ❍ implements default behavior for the interface common to all classes, as appropriate.
                ❍ declares an interface for accessing and managing its child components.
                ❍ (optional) defines an interface for accessing a component’s parent in the recursive structure,
                and implements it if that’s appropriate.
            Leaf
                ❍ represents leaf objects in the composition. A leaf has no children.
                ❍ defines behavior for primitive objects in the composition.
            Composite
                ❍ defines behavior for components having children.
                ❍ stores child components.
                ❍ implements child-related operations in the Component interface.
            Client
                ❍ manipulates objects in the composition through the Component interface.

            Collaborations:
                Clients use the Component class interface to interact with objects in the composite structure.
                If the recipient is a Leaf, then the request is handled directly. If the recipient is a Composite,
                then it usually forwards requests to its child components, possibly performing additional operations
                before and/or after forwarding.

 */

import java.util.ArrayList;
import java.util.List;

// Component
interface Component {
    void operation();
}

// Leaf
class Leaf implements Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Composite
class Composite implements Component {
    private final String name;
    private final List<Component> children;
    public Composite(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    public void add(Component component) {
        children.add(component);
    }
    public void remove(Component component) {
        children.remove(component);
    }
    @Override
    public void operation() {
        System.out.println("Composite: " + name);
        for (Component component : children) {
            component.operation();
        }
    }
}
public class CompositeStrucutre{
    public static void main(String[] args) {
        System.out.println("Composite Design Pattern Example");
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        Component leaf3 = new Leaf("leaf3");
        Component leaf4 = new Leaf("leaf4");
        Component leaf5 = new Leaf("leaf5");

        // Creating a composite tree structure
        Composite composite1 = new Composite("composite1");
        composite1.add(leaf1);
        composite1.add(leaf2);

        Composite composite2 = new Composite("composite2");
        composite2.add(leaf3);
        composite2.add(leaf4);
        composite2.add(leaf5);

        // add the composite2 to composite1 as a child
        composite1.add(composite2);
        // Performing operation on composite tree structure
        composite1.operation();


    }
}
