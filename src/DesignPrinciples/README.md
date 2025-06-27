# Design Principles

## 📋 Overview

This section demonstrates fundamental **Object-Oriented Design Principles** that form the foundation of good software design. These principles help create code that is maintainable, flexible, and robust.

## 🎯 Principles Covered

### SOLID Principles

1. **[Single Responsibility Principle (SRP)](SingleResponsibility/)** - A class should have only one reason to change
2. **Open/Closed Principle (OCP)** - Open for extension, closed for modification
3. **Liskov Substitution Principle (LSP)** - Subtypes must be substitutable for their base types
4. **Interface Segregation Principle (ISP)** - Clients shouldn't depend on interfaces they don't use
5. **Dependency Inversion Principle (DIP)** - Depend on abstractions, not concretions

### GRASP Principles

1. **[Information Expert](InformationExpert/)** - Assign responsibility to the class that has the information needed
2. **Creator** - Assign creation responsibility to appropriate classes
3. **[Controller](Controller/)** - Handle system events through controller objects
4. **Low Coupling** - Minimize dependencies between classes
5. **[High Cohesion](HighCohesion/)** - Keep related functionality together

## 🏗️ Directory Structure

```
DesignPrinciples/
├── SingleResponsibility/     # SRP examples
│   ├── with/                 # Good SRP implementation
│   └── without/              # Poor SRP implementation
├── InformationExpert/        # Information Expert examples
│   ├── with/                 # Good Information Expert implementation
│   └── without/              # Poor Information Expert implementation
├── Controller/               # Controller principle examples
│   ├── with/                 # MVC pattern implementation
│   └── without/              # Monolithic approach
├── HighCohesion/            # High Cohesion examples
│   ├── with/                 # High cohesion implementation
│   └── without/              # Low cohesion implementation
└── README.md                 # This file
```

## 💡 Key Benefits

- **Maintainability** - Easier to maintain and modify code
- **Flexibility** - Code adapts to changing requirements
- **Reusability** - Components can be reused in different contexts
- **Testability** - Easier to write unit tests
- **Readability** - Code is easier to understand

## 🚀 Getting Started

Each principle folder contains:

- **`with/`** - Demonstrates correct implementation of the principle
- **`without/`** - Shows what happens when principle is violated
- **`ReadMe`** - Explains the principle and examples

### Running Examples

```bash
# Navigate to specific principle
cd src/DesignPrinciples/SingleResponsibility/

# Run "without" example (shows problems)
cd without/
javac *.java
java Book

# Run "with" example (shows solution)
cd ../with/
javac *.java
java Book
```

## 📊 Principle Comparisons

### Single Responsibility vs High Cohesion

- **SRP**: One reason to change (external perspective)
- **High Cohesion**: Related functionality together (internal perspective)

### Information Expert vs Controller

- **Information Expert**: Who has the data should do the work
- **Controller**: Centralize system event handling

### Low Coupling vs Dependency Inversion

- **Low Coupling**: Minimize dependencies generally
- **Dependency Inversion**: Depend on abstractions specifically

## 🎨 Real-World Applications

### Single Responsibility Principle

- **Separation of Concerns** - UI, Business Logic, Data Access
- **Microservices** - Each service has single responsibility
- **Class Design** - Each class has one job

### Information Expert

- **Domain Driven Design** - Rich domain objects
- **Data Encapsulation** - Keep data and operations together
- **ORM Patterns** - Active Record pattern

### Controller Pattern

- **MVC Architecture** - Model-View-Controller separation
- **Web Applications** - Request handling controllers
- **GUI Applications** - Event handling controllers

### High Cohesion

- **Module Design** - Related functions in same module
- **Package Organization** - Cohesive packages
- **Component Architecture** - Focused components

## 🔄 Relationship Between Principles

```
High Cohesion ←→ Single Responsibility
       ↕              ↕
Low Coupling ←→ Dependency Inversion
       ↕              ↕
Information Expert ←→ Controller
```

## 🎯 When to Apply

### Always Apply

- **Single Responsibility** - Every class, method, module
- **High Cohesion** - All components
- **Information Expert** - When assigning responsibilities

### Contextual Application

- **Controller** - In interactive systems
- **Low Coupling** - Balance with other concerns
- **Dependency Inversion** - When abstractions make sense

## 🚨 Common Violations

### Single Responsibility Violations

- **God Classes** - Classes that do everything
- **Mixed Concerns** - UI logic in business classes
- **Multiple Reasons to Change** - Class changes for different reasons

### Information Expert Violations

- **Anemic Domain Model** - Objects with no behavior
- **Feature Envy** - Methods using data from other classes
- **Data Transfer Objects** - Doing business logic

### Controller Violations

- **Fat Controllers** - Controllers with business logic
- **No Controllers** - Direct UI to business coupling
- **Multiple Controllers** - Conflicting control logic

### High Cohesion Violations

- **Utility Classes** - Grab bag of unrelated functions
- **Large Classes** - Classes doing many unrelated things
- **Scattered Functionality** - Related code in different places

## 🔧 Best Practices

1. **Start with SRP** - Foundation for all other principles
2. **Identify Information Experts** - Find who has the data
3. **Keep Controllers Thin** - Delegate to business objects
4. **Measure Cohesion** - Related code should be together
5. **Monitor Coupling** - Watch dependencies between modules

## 📝 Design Principle Metrics

### Measuring SRP

- **Lines of Code** - Smaller classes often better SRP
- **Number of Methods** - Fewer methods per class
- **Change Frequency** - How often class changes

### Measuring Cohesion

- **LCOM (Lack of Cohesion of Methods)** - Lower is better
- **Method Interactions** - How methods work together
- **Attribute Usage** - How methods use class attributes

### Measuring Coupling

- **Afferent Coupling** - Dependencies coming in
- **Efferent Coupling** - Dependencies going out
- **Instability** - Ratio of outgoing to total dependencies

## 💼 Business Benefits

- **Reduced Development Time** - Easier to understand and modify
- **Lower Maintenance Costs** - Fewer bugs, easier fixes
- **Better Team Productivity** - Clear responsibilities
- **Higher Code Quality** - More reliable software
- **Faster Feature Development** - Reusable components

## 🌟 Modern Applications

### Microservices Architecture

- **SRP**: Each service has single business capability
- **Low Coupling**: Services communicate through APIs
- **High Cohesion**: Related functionality in same service

### Domain Driven Design

- **Information Expert**: Rich domain objects
- **SRP**: Bounded contexts
- **High Cohesion**: Domain model cohesion

### Clean Architecture

- **Dependency Inversion**: Dependencies point inward
- **SRP**: Separation of concerns by layers
- **Interface Segregation**: Focused interfaces

---

**Importance**: ⭐⭐⭐⭐⭐  
**Difficulty**: ⭐⭐⭐  
**Impact on Code Quality**: ⭐⭐⭐⭐⭐
