# Abstract Factory Pattern

## 📋 Overview

The **Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without specifying their concrete classes. It's also known as the "Factory of Factories" pattern.

## 🎯 Intent

- Create families of related objects without specifying their concrete classes
- Ensure that products from the same family are used together
- Provide a way to encapsulate a group of individual factories with a common theme

## 🏗️ Structure

### Key Components

1. **AbstractFactory** (`AbstractFactory.java`) - Declares interface for creating abstract products
2. **ConcreteFactory** (`ShapeFactory.java`, `RoundedShapeFactory.java`, `DoubleBorderFactory.java`) - Implements operations to create concrete products
3. **AbstractProduct** (`Shape.java`) - Declares interface for product objects
4. **ConcreteProduct** (Various shape classes) - Defines product objects to be created by corresponding concrete factory
5. **Client** (`AbstractFactoryPatternDemo.java`) - Uses only interfaces declared by AbstractFactory and AbstractProduct

### Class Hierarchy

```
AbstractFactory
├── ShapeFactory (Normal shapes)
├── RoundedShapeFactory (Rounded shapes)
└── DoubleBorderFactory (Double bordered shapes)

Shape
├── Rectangle, Square, Triangle (Normal)
├── RoundedRectangle, RoundedSquare (Rounded)
└── DoubleBorderedRectangle, DoubleBorderedTriangle (Double bordered)
```

## 💡 Key Features

- **Family Creation**: Creates families of related objects (normal, rounded, double-bordered shapes)
- **Consistency**: Ensures products from same family are used together
- **Flexibility**: Easy to add new product families
- **Encapsulation**: Hides concrete classes from client

## 🚀 Usage Example

```java
// Get factory for normal shapes
AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
Shape rectangle = shapeFactory.getShape("RECTANGLE");
rectangle.draw(); // Output: Inside Rectangle::draw() method

// Get factory for rounded shapes
AbstractFactory roundedFactory = FactoryProducer.getFactory("ROUNDED");
Shape roundedRectangle = roundedFactory.getShape("RECTANGLE");
roundedRectangle.draw(); // Output: Inside RoundedRectangle::draw() method
```

## 🏃‍♂️ How to Run

```bash
# Compile all Java files
javac *.java

# Run the demo
java AbstractFactoryPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Product Family Consistency** - Guarantees related products work together
- **Separation of Concerns** - Isolates concrete classes from client
- **Easy Product Family Addition** - Can add new families without changing existing code
- **Code Reusability** - Common interface for all product families

### ❌ Disadvantages

- **Complexity** - Adds extra abstraction layer
- **Code Overhead** - More classes and interfaces to maintain
- **Rigid Structure** - Hard to add new products to existing families

## 🎨 Real-World Applications

1. **UI Component Libraries** - Different themes (Material, Flat, Classic)
2. **Database Drivers** - Different database families (MySQL, Oracle, PostgreSQL)
3. **Operating System APIs** - Cross-platform GUI components
4. **Game Development** - Different enemy types for different levels/worlds

## 🔄 Related Patterns

- **Factory Method** - Abstract Factory uses Factory Method to create products
- **Singleton** - Concrete factories are often singletons
- **Prototype** - Can use prototype pattern to create products

## 📝 Implementation Notes

- The `FactoryProducer` class acts as a super factory that returns other factories
- Each concrete factory creates products of a specific family
- Client code works with abstract interfaces only
- Adding new product types requires modification of all factory classes

## 🔍 Pattern Variations

1. **Registry-based** - Factories registered in a registry
2. **Parameterized** - Factory methods take parameters to determine product type
3. **Extensible** - Support for plugin architectures

---

**Category**: Creational Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐⭐
