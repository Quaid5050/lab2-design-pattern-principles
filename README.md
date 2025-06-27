# Design Pattern Principles Lab

A comprehensive Java implementation of various **Design Patterns** and **Design Principles** following object-oriented programming best practices.

## 📁 Project Structure

```
lab-design-pattern-principles/
├── src/
│   ├── DesignPatterns/          # 23 Gang of Four Design Patterns
│   ├── DesignPrinciples/        # SOLID and GRASP Principles
│   ├── Practice/                # Practice implementations
│   ├── FinalExam/               # Final exam materials
│   └── Midterm_Exam/            # Midterm exam materials
├── README.md                    # This file
└── design-pattern-principles.iml
```

## 🎯 Design Patterns Implemented

### Creational Patterns (5)

- **Abstract Factory** - Creates families of related objects
- **Builder** - Constructs complex objects step by step
- **Factory Method** - Creates objects without specifying exact classes
- **Prototype** - Creates objects by cloning existing instances
- **Singleton** - Ensures only one instance of a class exists

### Structural Patterns (7)

- **Adapter** - Allows incompatible interfaces to work together
- **Bridge** - Separates abstraction from implementation
- **Composite** - Composes objects into tree structures
- **Decorator** - Adds behavior to objects dynamically
- **Facade** - Provides simplified interface to complex subsystem
- **Flyweight** - Reduces memory usage by sharing common data
- **Proxy** - Provides placeholder/surrogate for another object

### Behavioral Patterns (11)

- **Chain of Responsibility** - Passes requests along handler chain
- **Command** - Encapsulates requests as objects
- **Interpreter** - Defines grammar and interprets sentences
- **Iterator** - Provides way to access elements sequentially
- **Mediator** - Defines object interaction protocols
- **Memento** - Captures and restores object state
- **Observer** - Notifies multiple objects about state changes
- **State** - Changes object behavior based on internal state
- **Strategy** - Defines family of algorithms and makes them interchangeable
- **Template Method** - Defines skeleton of algorithm in base class
- **Visitor** - Separates algorithms from object structure

## 🔧 Design Principles Implemented

### SOLID Principles

- **Single Responsibility Principle** - Each class has one reason to change
- **Open/Closed Principle** - Open for extension, closed for modification
- **Liskov Substitution Principle** - Subtypes must be substitutable for base types
- **Interface Segregation Principle** - Clients shouldn't depend on unused interfaces
- **Dependency Inversion Principle** - Depend on abstractions, not concretions

### GRASP Principles

- **Information Expert** - Assign responsibility to class with most information
- **Creator** - Assign creation responsibility appropriately
- **Controller** - Handle system events through controller objects
- **Low Coupling** - Minimize dependencies between classes
- **High Cohesion** - Keep related functionality together

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running the Examples

1. **Clone or download the project**
2. **Open in your preferred IDE**
3. **Navigate to specific pattern folder**
4. **Run the main demo class** (usually named `*PatternDemo.java` or `*Main.java`)

Example:

```bash
# For Abstract Factory Pattern
cd src/DesignPatterns/abstractFactory/
javac *.java
java AbstractFactoryPatternDemo
```

### Project Navigation

Each design pattern folder contains:

- **README.md** - Pattern explanation and usage
- **Interface/Abstract classes** - Core abstractions
- **Concrete implementations** - Specific implementations
- **Demo/Main class** - Example usage and testing

## 📚 Learning Resources

### Reference Websites

- [Tutorials Point](https://www.tutorialspoint.com/) - Pattern tutorials
- [Refactoring Guru](https://refactoring.guru/) - Comprehensive pattern guide
- [SubjectExpert](https://subexpert.com/) - Problem statements and examples

### Reference Books

- **Design Patterns: Elements of Reusable Object-Oriented Software** (Gang of Four)
- **Head First Design Patterns** by Eric Freeman
- **Clean Code** by Robert C. Martin

## 🎓 Academic Context

This project is part of a software design course covering:

- Object-Oriented Design principles
- Design pattern implementation
- Code quality and maintainability
- Software architecture best practices

## 📝 Usage Examples

### Quick Start with Builder Pattern

```java
MealBuilder mealBuilder = new MealBuilder();
Meal vegMeal = mealBuilder.prepareVegMeal();
vegMeal.showItems();
System.out.println("Total Cost: " + vegMeal.getCost());
```

### Quick Start with Observer Pattern

```java
Subject subject = new Subject();
new HexaObserver(subject);
new OctalObserver(subject);
new BinaryObserver(subject);

subject.setState(15);  // Notifies all observers
```

## 🤝 Contributing

This is a learning project. Feel free to:

- Add new pattern implementations
- Improve existing code
- Add more comprehensive examples
- Enhance documentation

## ⚠️ Disclaimer

This code is for educational purposes only. Examples are modified from various sources for learning and understanding design patterns. Original credits go to respective authors and websites mentioned in references.

## 📧 Contact

For questions or suggestions regarding this educational project, please refer to the course materials or contact the instructor.

---

**Happy Learning! 🎓**
