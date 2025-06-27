# Single Responsibility Principle (SRP)

## 📋 Overview

The **Single Responsibility Principle** states that a class should have only one reason to change. It's the first principle of SOLID and forms the foundation of good object-oriented design.

## 🎯 Definition

> "A class should have only one reason to change."  
> — Robert C. Martin

This means each class should have only one job or responsibility, making it focused and cohesive.

## 🏗️ Structure

### Directory Structure

```
SingleResponsibility/
├── with/                    # Good SRP implementation
│   ├── Book.java           # Book data model
│   ├── BookView.java       # Book presentation logic
│   ├── PriceCalculator.java # Price calculation logic
│   └── ShippingCalculator.java # Shipping calculation logic
├── without/                 # Poor SRP implementation
│   ├── Book.java           # God class with multiple responsibilities
│   └── BookView.java       # Simple view class
└── README.md               # This file
```

## 💡 Key Concepts

### Single Responsibility

- Each class has **one job**
- Each class has **one reason to change**
- **High cohesion** within the class
- **Clear purpose** and focused functionality

### Responsibility Definition

A responsibility is a **reason to change**. If you can think of more than one motive for changing a class, it has multiple responsibilities.

## 🚀 Examples

### ❌ Without SRP (Violation)

```java
public class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    // Book data methods
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Price calculation responsibility
    public double calculateTotalPrice() {
        return price * quantity * 1.1; // Including tax
    }

    // Shipping calculation responsibility
    public double calculateShippingCost() {
        if (price > 50) return 0; // Free shipping
        return 5.99;
    }

    // Display responsibility
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Total: $" + calculateTotalPrice());
    }

    // Persistence responsibility
    public void saveToDatabase() {
        // Database saving logic
    }
}
```

**Problems:**

- **Multiple responsibilities** in one class
- **High coupling** between different concerns
- **Hard to maintain** - changes to tax rate affect the Book class
- **Hard to test** - must test all responsibilities together
- **Violates Open/Closed Principle** - class changes for multiple reasons

### ✅ With SRP (Good Design)

```java
// Book.java - Data model responsibility only
public class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    // Constructor and getters/setters only
    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Simple getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

// PriceCalculator.java - Price calculation responsibility
public class PriceCalculator {
    private static final double TAX_RATE = 0.1;

    public double calculateTotalPrice(Book book) {
        return book.getPrice() * book.getQuantity() * (1 + TAX_RATE);
    }
}

// ShippingCalculator.java - Shipping calculation responsibility
public class ShippingCalculator {
    private static final double FREE_SHIPPING_THRESHOLD = 50.0;
    private static final double SHIPPING_COST = 5.99;

    public double calculateShippingCost(Book book) {
        return book.getPrice() >= FREE_SHIPPING_THRESHOLD ? 0 : SHIPPING_COST;
    }
}

// BookView.java - Display responsibility
public class BookView {
    private PriceCalculator priceCalculator;
    private ShippingCalculator shippingCalculator;

    public BookView() {
        this.priceCalculator = new PriceCalculator();
        this.shippingCalculator = new ShippingCalculator();
    }

    public void displayBookInfo(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Total: $" + priceCalculator.calculateTotalPrice(book));
        System.out.println("Shipping: $" + shippingCalculator.calculateShippingCost(book));
    }
}
```

## 🏃‍♂️ How to Run

```bash
# Navigate to SingleResponsibility directory
cd src/DesignPrinciples/SingleResponsibility/

# Run without SRP example (shows problems)
cd without/
javac *.java
java Book

# Run with SRP example (shows solution)
cd ../with/
javac *.java
java BookView
```

## 📊 Benefits

### ✅ Advantages

- **Easier Maintenance** - Changes affect only one class
- **Better Testability** - Each responsibility can be tested independently
- **Higher Reusability** - Focused classes can be reused elsewhere
- **Reduced Coupling** - Classes have fewer dependencies
- **Clearer Code** - Purpose of each class is obvious

### ❌ When Violated

- **God Classes** - Classes that do everything
- **High Coupling** - Classes depend on many other classes
- **Hard to Test** - Must test multiple responsibilities together
- **Fragile Code** - Changes break unexpected parts

## 🎨 Real-World Applications

### Good SRP Examples

1. **MVC Pattern** - Model, View, Controller have separate responsibilities
2. **Repository Pattern** - Data access responsibility only
3. **Service Classes** - Business logic responsibility only
4. **Value Objects** - Data holding responsibility only

### SRP Violations to Avoid

1. **Utility Classes** - Grab bag of unrelated methods
2. **Manager Classes** - Classes that "manage" everything
3. **Mixed Concerns** - UI logic in business classes
4. **Data + Behavior Mixing** - DTOs with business logic

## 🔍 Identifying Violations

### Warning Signs

- **Large Classes** - Usually doing too much
- **Many Dependencies** - Class needs many other classes
- **Frequent Changes** - Class changes often for different reasons
- **Hard to Name** - Can't describe class purpose in one sentence
- **"And" in Description** - "This class handles orders AND inventory AND notifications"

### Questions to Ask

1. **What is this class responsible for?**
2. **Why would this class change?**
3. **Can I describe this class in one sentence without using "and"?**
4. **Are the methods in this class all related?**
5. **Do the methods use the same instance variables?**

## 🔧 Refactoring Techniques

### Extract Class

```java
// Before: God class
public class Employee {
    private String name;
    private double salary;
    private String address;

    public void calculatePay() { /* payment logic */ }
    public void saveToDatabase() { /* persistence logic */ }
    public String formatAddress() { /* formatting logic */ }
}

// After: Separate responsibilities
public class Employee {
    private String name;
    private double salary;
    // Only employee data
}

public class PayrollService {
    public void calculatePay(Employee employee) { /* payment logic */ }
}

public class EmployeeRepository {
    public void save(Employee employee) { /* persistence logic */ }
}
```

### Move Method

Move methods to classes that have the required data.

### Extract Interface

Create interfaces for different responsibilities.

## 🎯 Best Practices

1. **Start Small** - Begin with focused, single-purpose classes
2. **Regular Refactoring** - Split classes when they grow too large
3. **Clear Naming** - Class names should clearly indicate their purpose
4. **Measure Complexity** - Monitor class size and dependencies
5. **Code Reviews** - Check for SRP violations during reviews

## 📝 Metrics for SRP

### Class-Level Metrics

- **Lines of Code** - Smaller classes often have better SRP
- **Number of Dependencies** - Fewer dependencies usually better
- **Cyclomatic Complexity** - Lower complexity indicates focused purpose
- **Number of Public Methods** - Fewer methods often mean single purpose

### Method-Level Metrics

- **Method Length** - Shorter methods are more focused
- **Parameter Count** - Fewer parameters often indicate better design
- **Method Cohesion** - Methods should work with same data

## 💼 Business Benefits

- **Faster Development** - Easier to understand and modify code
- **Reduced Bugs** - Changes are isolated and predictable
- **Better Team Collaboration** - Clear ownership of responsibilities
- **Easier Onboarding** - New developers can understand focused classes
- **Lower Maintenance Costs** - Less time spent understanding complex code

## 🌟 Advanced Concepts

### Cohesion Types

1. **Functional Cohesion** - Methods work together toward single task (best)
2. **Sequential Cohesion** - Output of one method is input to another
3. **Communicational Cohesion** - Methods work on same data
4. **Temporal Cohesion** - Methods executed at same time
5. **Logical Cohesion** - Methods do similar things
6. **Coincidental Cohesion** - No logical relationship (worst)

### Granularity Balance

- **Too Fine-Grained** - Too many small classes
- **Too Coarse-Grained** - Classes doing too much
- **Right Balance** - Classes with clear, single purpose

---

**Category**: SOLID Principle  
**Importance**: ⭐⭐⭐⭐⭐  
**Difficulty**: ⭐⭐  
**Foundation**: All other principles build on SRP
