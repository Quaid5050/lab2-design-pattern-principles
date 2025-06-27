# Iterator Pattern

## 📋 Overview

The **Iterator Pattern** provides a way to access elements of a collection sequentially without exposing its underlying representation. It separates the traversal logic from the collection itself.

## 🎯 Intent

- Provide a way to traverse a collection without exposing its internal structure
- Support multiple traversals of the same collection
- Provide a uniform interface for traversing different collections
- Separate iteration logic from the collection

## 🏗️ Structure

### Key Components

1. **Iterator Interface** (`Iterator.java`) - Defines methods for traversing collection
2. **Container Interface** (`Container.java`) - Defines method to get iterator
3. **Concrete Container** (`NameRepository.java`) - Implements container and provides iterator
4. **Student** (`Student.java`) - Data object stored in collection
5. **Client** (`IteratorPatternDemo.java`) - Uses iterator to traverse collection

### Directory Structure

```
Iterator/
├── interfaces/
│   ├── Iterator.java           # Iterator interface
│   └── Container.java          # Container interface
├── classes/
│   ├── NameRepository.java     # Concrete container
│   └── Student.java            # Data object
└── main/
    └── IteratorPatternDemo.java # Demo class
```

## 💡 Key Features

- **Sequential Access** - Access elements one by one in order
- **Encapsulation** - Hide internal collection structure
- **Multiple Traversals** - Support multiple simultaneous traversals
- **Uniform Interface** - Same interface for different collection types

## 🚀 Usage Example

```java
NameRepository nameRepository = new NameRepository();

// Get iterator and traverse
for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
    String name = (String) iter.next();
    System.out.println("Name : " + name);
}

// Or using enhanced for loop (if implemented)
for (String name : nameRepository) {
    System.out.println("Name : " + name);
}
```

**Output:**

```
Name : Robert
Name : John
Name : Julie
Name : Lora
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Iterator directory
cd src/DesignPatterns/Iterator/

# Compile all Java files
javac -cp . main/*.java classes/*.java interfaces/*.java

# Run the demo
java main.IteratorPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Encapsulation** - Collection internals are hidden
- **Uniform Interface** - Same interface for different collections
- **Multiple Traversals** - Support concurrent iterations
- **Simplified Client Code** - Client doesn't need to know collection details
- **Lazy Evaluation** - Elements loaded only when accessed

### ❌ Disadvantages

- **Memory Overhead** - Additional iterator objects
- **Performance** - Indirection through iterator interface
- **Thread Safety** - Concurrent modifications can cause issues

## 🎨 Real-World Applications

1. **Java Collections** - ArrayList, LinkedList, HashSet iterators
2. **Database Result Sets** - Traversing query results
3. **File System** - Directory traversal
4. **Tree Structures** - Tree traversal algorithms
5. **Menu Systems** - Navigating menu hierarchies
6. **Playlist Management** - Music/video playlist iteration

## 🔄 Related Patterns

- **Composite** - Iterator often used to traverse composite structures
- **Factory Method** - Iterator creation often uses factory method
- **Memento** - Iterator can save/restore traversal state
- **Visitor** - Iterator provides access, Visitor performs operations

## 📝 Implementation Details

### Iterator Interface

```java
public interface Iterator {
    public boolean hasNext();
    public Object next();
}
```

### Container Interface

```java
public interface Container {
    public Iterator getIterator();
}
```

### NameRepository (Concrete Container)

```java
public class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
```

## 🎯 When to Use

- **Collection Traversal** - When you need to traverse collections
- **Hiding Internal Structure** - When you want to hide collection implementation
- **Multiple Traversal Strategies** - Different ways to traverse same collection
- **Uniform Access** - Common interface for different collection types

## 🚨 Common Pitfalls

- **Concurrent Modification** - Modifying collection during iteration
- **Memory Leaks** - Long-lived iterators holding references
- **Performance** - Overhead of iterator pattern
- **Thread Safety** - Not handling concurrent access properly

---

**Category**: Behavioral Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
