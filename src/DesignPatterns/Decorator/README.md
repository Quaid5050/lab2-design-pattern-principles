# Decorator Pattern

## 📋 Overview

The **Decorator Pattern** allows behavior to be added to objects dynamically without altering their structure. It provides a flexible alternative to subclassing for extending functionality.

## 🎯 Intent

- Add new functionality to objects dynamically
- Provide flexible alternative to subclassing
- Wrap objects with additional behavior
- Combine multiple decorators for complex functionality

## 🏗️ Structure

### Key Components

1. **Component Interface** (`Shape.java`) - Common interface for objects and decorators
2. **Concrete Component** (`Circle.java`, `Rectangle.java`) - Basic objects that can be decorated
3. **Base Decorator** (`ShapeDecorator.java`) - Abstract decorator class
4. **Concrete Decorators** (`RedShapeDecorator.java`) - Specific decorators that add behavior
5. **Client** (`DecoratorPatternDemo.java`) - Uses decorated objects

### Directory Structure

```
Decorator/
├── interfaces/
│   └── Shape.java                 # Component interface
├── classes/
│   ├── Circle.java               # Concrete component
│   ├── Rectangle.java            # Concrete component
│   └── RedShapeDecorator.java    # Concrete decorator
├── abstractClasses/
│   └── ShapeDecorator.java       # Base decorator
└── mainClass/
    └── DecoratorPatternDemo.java # Demo class
```

## 💡 Key Features

- **Dynamic Behavior Addition** - Add functionality at runtime
- **Transparent Wrapping** - Decorators implement same interface as components
- **Multiple Decorations** - Stack multiple decorators
- **Single Responsibility** - Each decorator has one specific responsibility

## 🚀 Usage Example

```java
// Create basic shapes
Shape circle = new Circle();
Shape rectangle = new Rectangle();

// Decorate shapes with red color
Shape redCircle = new RedShapeDecorator(new Circle());
Shape redRectangle = new RedShapeDecorator(new Rectangle());

// Draw shapes
System.out.println("Circle with normal border");
circle.draw();

System.out.println("\nCircle of red border");
redCircle.draw();

System.out.println("\nRectangle of red border");
redRectangle.draw();
```

**Output:**

```
Circle with normal border
Shape: Circle

Circle of red border
Shape: Circle
Border Color: Red

Rectangle of red border
Shape: Rectangle
Border Color: Red
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Decorator directory
cd src/DesignPatterns/Decorator/

# Compile all Java files
javac -cp . mainClass/*.java abstractClasses/*.java classes/*.java interfaces/*.java

# Run the demo
java mainClass.DecoratorPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Runtime Flexibility** - Add/remove behavior at runtime
- **Single Responsibility** - Each decorator has one responsibility
- **Open/Closed Principle** - Open for extension, closed for modification
- **Multiple Combinations** - Combine decorators in different ways
- **Alternative to Inheritance** - More flexible than subclassing

### ❌ Disadvantages

- **Complexity** - Can create many small objects
- **Debugging Difficulty** - Hard to debug wrapped objects
- **Performance Overhead** - Additional method calls through decorators
- **Identity Issues** - Decorated object != original object

## 🎨 Real-World Applications

1. **Java I/O Streams** - BufferedInputStream, DataInputStream
2. **UI Components** - Scrollable, bordered, or titled components
3. **Web Requests** - Authentication, logging, compression decorators
4. **Coffee Shop** - Basic coffee + milk, sugar, whip cream decorators
5. **Text Processing** - Bold, italic, underline decorators
6. **Caching** - Cache decorators for database operations

## 🔄 Related Patterns

- **Adapter** - Changes interface; Decorator adds behavior
- **Composite** - Represents part-whole hierarchies; Decorator adds responsibilities
- **Strategy** - Changes algorithm; Decorator changes behavior
- **Proxy** - Controls access; Decorator adds functionality

## 📝 Implementation Details

### Shape Interface (Component)

```java
public interface Shape {
    void draw();
}
```

### Circle Class (Concrete Component)

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
```

### ShapeDecorator Class (Base Decorator)

```java
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
```

### RedShapeDecorator Class (Concrete Decorator)

```java
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
```

## 🔍 Advanced Usage

### Multiple Decorators

```java
// Stack multiple decorators
Shape decoratedShape = new RedShapeDecorator(
    new BorderDecorator(
        new ShadowDecorator(
            new Circle()
        )
    )
);
decoratedShape.draw();
```

### Decorator Chaining

```java
Shape shape = new Circle();
shape = new RedShapeDecorator(shape);
shape = new BorderDecorator(shape);
shape = new ShadowDecorator(shape);
shape.draw();
```

## 🎯 When to Use

- **Runtime Behavior Addition** - Need to add behavior at runtime
- **Multiple Combinations** - Need different combinations of features
- **Avoiding Inheritance Explosion** - Too many subclasses for all combinations
- **Transparent Enhancement** - Add features without changing client code

## 🚨 Common Pitfalls

- **Over-decoration** - Too many decorators can be confusing
- **Order Dependency** - Decorator order might matter
- **Interface Compatibility** - All decorators must implement same interface
- **Performance** - Each decorator adds method call overhead

## 🔧 Best Practices

1. **Keep Decorators Simple** - Each decorator should add one feature
2. **Maintain Interface Consistency** - All decorators implement same interface
3. **Document Decorator Order** - If order matters, document it clearly
4. **Consider Performance** - Be aware of method call overhead
5. **Use Composition** - Prefer composition over inheritance

## 🎪 Pattern Variations

### Function Decorators (Python-style)

```java
@LoggedDecorator
@TimedDecorator
public void someMethod() {
    // Method implementation
}
```

### Fluent Decorators

```java
Shape decoratedShape = new Circle()
    .withRedBorder()
    .withShadow()
    .withBorder();
```

### Decorator Factory

```java
public class ShapeDecoratorFactory {
    public static Shape createDecoratedShape(Shape base, String... decorators) {
        Shape result = base;
        for (String decorator : decorators) {
            result = createDecorator(decorator, result);
        }
        return result;
    }
}
```

## 💼 Business Benefits

- **Customization** - Easy customization of products/services
- **Modularity** - Modular features that can be combined
- **Scalability** - Easy to add new features without changing existing code
- **User Experience** - Users can choose which features they want

## 🔍 Java I/O Example

The Java I/O system is a perfect example of Decorator pattern:

```java
// Base stream
FileInputStream fis = new FileInputStream("file.txt");

// Add buffering
BufferedInputStream bis = new BufferedInputStream(fis);

// Add data interpretation
DataInputStream dis = new DataInputStream(bis);
```

---

**Category**: Structural Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
