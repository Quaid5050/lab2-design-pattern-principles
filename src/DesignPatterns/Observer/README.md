# Observer Pattern

## 📋 Overview

The **Observer Pattern** defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It's also known as the Publish-Subscribe pattern.

## 🎯 Intent

- Define a one-to-many dependency between objects
- Notify multiple objects about state changes in another object
- Maintain consistency between related objects
- Promote loose coupling between subject and observers

## 🏗️ Structure

### Key Components

1. **Subject** (`Subject.java`) - Maintains list of observers and notifies them of changes
2. **Observer** (`Observer.java`) - Abstract class defining update interface
3. **ConcreteObservers** (`BinaryObserver.java`, `OctalObserver.java`, `HexaObserver.java`) - Specific implementations that react to changes
4. **Client** (`ObserverPatternDemo.java`) - Creates and manages the observer relationships

### Directory Structure

```
Observer/
├── subjectClasses/
│   └── Subject.java              # Subject that notifies observers
├── abstractClasses/
│   └── Observer.java             # Abstract observer interface
├── concreteClasses/
│   ├── BinaryObserver.java       # Binary representation observer
│   ├── OctalObserver.java        # Octal representation observer
│   └── HexaObserver.java         # Hexadecimal representation observer
└── mainClass/
    └── ObserverPatternDemo.java  # Demo class
```

## 💡 Key Features

- **Automatic Notification** - Observers automatically notified of changes
- **Loose Coupling** - Subject doesn't know concrete observer classes
- **Dynamic Relationships** - Observers can be added/removed at runtime
- **Broadcast Communication** - One-to-many communication pattern

## 🚀 Usage Example

```java
// Create subject
Subject subject = new Subject();

// Create and attach observers
new HexaObserver(subject);
new OctalObserver(subject);
new BinaryObserver(subject);

// Change state - all observers will be notified
System.out.println("First state change: 15");
subject.setState(15);

System.out.println("Second state change: 10");
subject.setState(10);
```

**Output:**

```
First state change: 15
Hex String: F
Octal String: 17
Binary String: 1111

Second state change: 10
Hex String: A
Octal String: 12
Binary String: 1010
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Observer directory
cd src/DesignPatterns/Observer/

# Compile all Java files
javac -cp . mainClass/*.java abstractClasses/*.java concreteClasses/*.java subjectClasses/*.java

# Run the demo
java mainClass.ObserverPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Loose Coupling** - Subject and observers are loosely coupled
- **Dynamic Relationships** - Add/remove observers at runtime
- **Open/Closed Principle** - Add new observers without modifying subject
- **Broadcast Communication** - Efficient one-to-many communication
- **Separation of Concerns** - Subject focuses on state, observers on reactions

### ❌ Disadvantages

- **Memory Leaks** - Observers might not be garbage collected
- **Performance** - Notifying many observers can be slow
- **Unexpected Updates** - Cascade of updates can be unpredictable
- **Complex Dependencies** - Can create complex dependency chains

## 🎨 Real-World Applications

1. **GUI Systems** - Model-View architectures (MVC, MVP, MVVM)
2. **Event Handling** - Button clicks, mouse movements
3. **Data Binding** - UI elements automatically update with data changes
4. **Stock Market** - Price change notifications to multiple traders
5. **News Systems** - Subscribers notified of new articles
6. **Social Media** - Followers notified of new posts

## 🔄 Related Patterns

- **Mediator** - Both coordinate communication; Mediator centralizes, Observer distributes
- **Singleton** - Subject often implemented as Singleton
- **MVC** - Observer is core to Model-View-Controller pattern
- **Publisher-Subscriber** - Observer is the foundation of Pub-Sub pattern

## 📝 Implementation Details

### Subject Class

```java
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

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
```

### Observer Abstract Class

```java
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
```

### BinaryObserver (Concrete Observer)

```java
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " +
            Integer.toBinaryString(subject.getState()));
    }
}
```

## 🔍 Key Implementation Features

- **Auto-Registration** - Observers register themselves with subject in constructor
- **State Access** - Observers can access subject's state
- **Multiple Representations** - Different observers show different views of same data
- **Immediate Notification** - Changes are propagated immediately

## 🎯 When to Use

- **Model-View Separation** - When you need to separate data from presentation
- **Event Systems** - When implementing event-driven architectures
- **Data Consistency** - When multiple objects need to stay synchronized
- **Dynamic Dependencies** - When object relationships change at runtime

## 🚨 Common Pitfalls

- **Memory Leaks** - Forgetting to remove observers
- **Performance Issues** - Too many observers or expensive update operations
- **Circular Dependencies** - Observers modifying subject state
- **Order Dependencies** - Assuming specific notification order

## 🔧 Best Practices

1. **Weak References** - Use weak references to prevent memory leaks
2. **Unsubscribe Mechanism** - Provide way to remove observers
3. **Exception Handling** - Handle exceptions in observer updates
4. **Asynchronous Updates** - Consider async notifications for performance
5. **State Validation** - Validate state before notifying observers

## 🎪 Pattern Variations

### Push Model (Current Implementation)

```java
// Subject pushes data to observers
public void update() {
    // Observer gets data from subject
    int state = subject.getState();
}
```

### Pull Model

```java
// Subject just notifies, observers pull data
public void update(Object data) {
    // Observer receives data directly
    this.data = data;
}
```

### Event-Based Observer

```java
public interface EventObserver {
    void onEvent(Event event);
}

public class Subject {
    public void fireEvent(Event event) {
        observers.forEach(observer -> observer.onEvent(event));
    }
}
```

### Generic Observer

```java
public interface Observer<T> {
    void update(T data);
}

public class Subject<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void notifyObservers(T data) {
        observers.forEach(observer -> observer.update(data));
    }
}
```

## 💼 Business Benefits

- **Real-time Updates** - Users see changes immediately
- **Modular Architecture** - Easy to add new features as observers
- **Scalability** - Can handle multiple simultaneous users/views
- **Maintainability** - Changes to observers don't affect subject

## 🚀 Advanced Features

### Filtered Observer

```java
public abstract class FilteredObserver extends Observer {
    protected Predicate<Integer> filter;

    @Override
    public void update() {
        if (filter.test(subject.getState())) {
            doUpdate();
        }
    }

    protected abstract void doUpdate();
}
```

### Prioritized Observer

```java
public class PrioritySubject {
    private Map<Integer, List<Observer>> priorityObservers = new TreeMap<>();

    public void notifyObservers() {
        priorityObservers.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> entry.getValue().forEach(Observer::update));
    }
}
```

### Asynchronous Observer

```java
public class AsyncSubject {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void notifyObservers() {
        observers.forEach(observer ->
            executor.submit(() -> observer.update())
        );
    }
}
```

## 🔍 Modern Implementations

### Java 8+ with Lambda

```java
public class LambdaSubject {
    private List<Consumer<Integer>> observers = new ArrayList<>();

    public void addObserver(Consumer<Integer> observer) {
        observers.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        observers.forEach(observer -> observer.accept(state));
    }
}

// Usage
subject.addObserver(state -> System.out.println("Binary: " + Integer.toBinaryString(state)));
```

### Reactive Streams

```java
// Using RxJava or similar
Observable<Integer> stateChanges = subject.stateChanges();
stateChanges.subscribe(state -> System.out.println("Binary: " + Integer.toBinaryString(state)));
```

---

**Category**: Behavioral Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
