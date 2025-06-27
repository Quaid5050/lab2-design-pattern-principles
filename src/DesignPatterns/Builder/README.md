# Builder Pattern

## 📋 Overview

The **Builder Pattern** constructs complex objects step by step. It allows you to produce different types and representations of an object using the same construction code.

## 🎯 Intent

- Construct complex objects step by step
- Create different representations of the same object
- Separate the construction process from the representation
- Provide fine control over the construction process

## 🏗️ Structure

### Key Components

1. **Product** (`Meal.java`) - Complex object being constructed
2. **Builder** (`MealBuilder.java`) - Interface for constructing parts of Product
3. **ConcreteBuilder** (`MealBuilder.java`) - Implements Builder interface
4. **Director** (Optional) - Constructs object using Builder interface
5. **Items** (`Item.java`, `Burger.java`, `ColdDrink.java`, etc.) - Parts of the complex object

### Class Hierarchy

```
Item (interface)
├── Burger (abstract)
│   ├── VegBurger
│   └── ChickenBurger
└── ColdDrink (abstract)
    ├── Coke
    ├── Pepsi
    └── Tea

Packing (interface)
├── Wrapper
└── Bottle
```

## 💡 Key Features

- **Step-by-step Construction**: Build complex objects incrementally
- **Fluent Interface**: Chain method calls for readable code
- **Flexible Representation**: Same construction process, different representations
- **Validation**: Validate object state during construction

## 🚀 Usage Example

```java
MealBuilder mealBuilder = new MealBuilder();

// Build a vegetarian meal
Meal vegMeal = mealBuilder.prepareVegMeal();
System.out.println("Veg Meal");
vegMeal.showItems();
System.out.println("Total Cost: " + vegMeal.getCost());

// Build a non-vegetarian meal
Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
System.out.println("\nNon-Veg Meal");
nonVegMeal.showItems();
System.out.println("Total Cost: " + nonVegMeal.getCost());

// Build custom meal
Meal customMeal = new Meal();
customMeal.addItem(new VegBurger());
customMeal.addItem(new Tea());
```

## 🏃‍♂️ How to Run

```bash
# Compile all Java files
javac *.java

# Run the demo
java BuilderPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Readable Code** - Clear step-by-step construction
- **Reusable Construction Logic** - Same builder for different representations
- **Parameter Validation** - Validate during construction process
- **Immutable Objects** - Can create immutable objects
- **Optional Parameters** - Handle many optional parameters elegantly

### ❌ Disadvantages

- **Code Complexity** - More classes and complexity
- **Memory Overhead** - Additional builder objects
- **Overkill for Simple Objects** - Unnecessary for simple objects

## 🎨 Real-World Applications

1. **SQL Query Builders** - Building complex SQL queries
2. **Configuration Objects** - Building complex configuration objects
3. **Document Builders** - Creating complex document structures
4. **Test Data Builders** - Creating test objects with varying data
5. **UI Builders** - Building complex UI components

## 🔄 Related Patterns

- **Abstract Factory** - Builder focuses on step-by-step construction
- **Composite** - Builder can construct composite objects
- **Factory Method** - Builder can use factory methods

## 📝 Implementation Variants

### 1. Fluent Builder (Method Chaining)

```java
Meal meal = new MealBuilder()
    .addBurger(new VegBurger())
    .addDrink(new Coke())
    .build();
```

### 2. Telescoping Constructor Problem Solution

```java
// Instead of multiple constructors
Tea tea = new TeaBuilder()
    .sweetnessType("Sugar-Free")
    .withCream()
    .sweetnessSpoons(2)
    .build();
```

### 3. Static Builder

```java
public class Meal {
    public static MealBuilder builder() {
        return new MealBuilder();
    }
}
```

## 🔍 Key Implementation Details

- **Item Interface** - Common interface for all meal items
- **Packing Interface** - Different packaging types (Wrapper, Bottle)
- **Abstract Classes** - Burger and ColdDrink provide common functionality
- **Cost Calculation** - Automatic total cost calculation
- **Display Functionality** - Pretty printing of meal contents

## 🎯 When to Use

- **Complex Object Creation** - Objects with many parameters
- **Immutable Objects** - When you need immutable objects
- **Step-by-step Construction** - When construction process is complex
- **Multiple Representations** - Same construction, different results

## 🚨 Common Pitfalls

- **Overuse** - Don't use for simple objects
- **Partial Construction** - Ensure object is complete before use
- **Thread Safety** - Builder instances should not be shared

---

**Category**: Creational Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
