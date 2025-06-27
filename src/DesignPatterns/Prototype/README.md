# Prototype Pattern

## 📋 Overview

The **Prototype Pattern** creates new objects by cloning existing instances (prototypes) rather than creating them from scratch. It's useful when object creation is expensive or complex.

## 🎯 Intent

- Create objects by cloning existing prototypes
- Avoid expensive object creation operations
- Specify kinds of objects to create using prototypical instances
- Hide complexities of object creation from client

## 🏗️ Structure

### Key Components

1. **Prototype** (`Shape.java`) - Abstract class/interface declaring clone method
2. **ConcretePrototype** (`Circle.java`, `Rectangle.java`, `Square.java`) - Implements clone operation
3. **Client** (`PrototypePatternDemo.java`) - Creates objects by cloning prototypes
4. **PrototypeRegistry** (`ShapeCache.java`) - Maintains cache of prototype instances

### Class Hierarchy

```
Shape (abstract)
├── Circle
├── Rectangle
└── Square

ShapeCache
└── Manages cloned instances
```

## 💡 Key Features

- **Object Cloning** - Create new objects by copying existing ones
- **Performance Optimization** - Avoid expensive object creation
- **Runtime Configuration** - Create objects based on runtime parameters
- **Prototype Registry** - Cache and reuse prototype instances

## 🚀 Usage Example

```java
// Load prototypes into cache
ShapeCache.loadCache();

// Clone objects from cache
Shape clonedShape1 = ShapeCache.getShape("1"); // Circle
clonedShape1.draw(); // Output: Inside Circle::draw() method

Shape clonedShape2 = ShapeCache.getShape("2"); // Square
clonedShape2.draw(); // Output: Inside Square::draw() method

Shape clonedShape3 = ShapeCache.getShape("3"); // Rectangle
clonedShape3.draw(); // Output: Inside Rectangle::draw() method
```

## 🏃‍♂️ How to Run

```bash
# Compile all Java files
javac *.java

# Run the demo
java PrototypePatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Performance** - Faster than creating objects from scratch
- **Simplified Creation** - No need to know concrete classes
- **Dynamic Configuration** - Add/remove prototypes at runtime
- **Reduced Subclassing** - Alternative to factory hierarchies
- **State Preservation** - Clone objects with specific states

### ❌ Disadvantages

- **Complex Cloning** - Deep vs shallow copy issues
- **Circular References** - Problems with circular object references
- **Clone Implementation** - Each class must implement clone correctly
- **Memory Usage** - Prototype registry consumes memory

## 🎨 Real-World Applications

1. **Game Development** - Cloning game objects (enemies, items)
2. **Document Processing** - Template documents with predefined content
3. **Configuration Objects** - Default configuration templates
4. **Database Records** - Cloning database entities
5. **UI Components** - Reusable UI component templates

## 🔄 Related Patterns

- **Factory Method** - Alternative to factory hierarchies
- **Abstract Factory** - Often used together with prototype
- **Singleton** - Prototype registry can be singleton
- **Composite** - Prototypes often work with composite structures

## 📝 Implementation Details

### Clone Types

1. **Shallow Copy** - Copies object references

```java
@Override
public Object clone() {
    Object clone = null;
    try {
        clone = super.clone();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }
    return clone;
}
```

2. **Deep Copy** - Copies entire object graph

```java
@Override
public Object clone() {
    // Deep copy implementation
    return new Circle(this.radius, this.color);
}
```

### Registry Pattern

The `ShapeCache` class implements a registry pattern:

- Stores prototype instances
- Provides access to cloned objects
- Manages prototype lifecycle

## 🔍 Key Implementation Features

- **Abstract Shape Class** - Defines common properties and clone method
- **Concrete Shapes** - Implement specific drawing behavior
- **Prototype Cache** - Centralized prototype management
- **Unique IDs** - Each prototype has unique identifier

## 🎯 When to Use

- **Expensive Object Creation** - When creating objects is costly
- **Similar Objects** - When you need many similar objects
- **Runtime Configuration** - When object types are determined at runtime
- **Avoiding Subclasses** - Alternative to complex factory hierarchies

## 🚨 Common Pitfalls

- **Shallow vs Deep Copy** - Incorrect cloning implementation
- **Cloneable Interface** - Not implementing Cloneable properly
- **Exception Handling** - Not handling CloneNotSupportedException
- **State Management** - Cloned objects sharing mutable state

## 🔧 Best Practices

1. **Implement Cloneable** - Always implement Cloneable interface
2. **Handle Exceptions** - Properly handle CloneNotSupportedException
3. **Choose Copy Type** - Decide between shallow and deep copy
4. **Prototype Registry** - Use registry for prototype management
5. **Documentation** - Document cloning behavior clearly

## 🎪 Advanced Features

- **Prototype Factory** - Combine with factory pattern
- **Serialization Cloning** - Use serialization for deep copying
- **Copy Constructor** - Alternative to clone method
- **Builder with Prototype** - Combine with builder pattern

---

**Category**: Creational Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐
