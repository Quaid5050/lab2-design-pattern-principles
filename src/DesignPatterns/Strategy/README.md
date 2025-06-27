# Strategy Pattern

## 📋 Overview

The **Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

## 🎯 Intent

- Define a family of algorithms and make them interchangeable
- Encapsulate algorithms in separate classes
- Allow algorithm selection at runtime
- Eliminate conditional statements for algorithm selection

## 🏗️ Structure

### Key Components

1. **Strategy Interface** (`Strategy.java`) - Common interface for all algorithms
2. **Concrete Strategies** (`OperationAdd.java`, `OperationSubtract.java`, `OperationMultiply.java`) - Specific algorithm implementations
3. **Context** (`Context.java`) - Maintains reference to strategy and delegates work to it
4. **Client** (`StrategyDemo.java`) - Creates context and sets strategy

### Directory Structure

```
Strategy/
├── interfaces/
│   └── Strategy.java           # Strategy interface
├── classes/
│   ├── OperationAdd.java       # Addition strategy
│   ├── OperationSubtract.java  # Subtraction strategy
│   └── OperationMultiply.java  # Multiplication strategy
├── Context/
│   └── Context.java            # Context class
├── abstractClasses/
│   └── Computer.java           # Additional context example
└── mainClass/
    └── StrategyDemo.java       # Demo class
```

## 💡 Key Features

- **Algorithm Flexibility** - Switch algorithms at runtime
- **Encapsulation** - Each algorithm is encapsulated in its own class
- **Extensibility** - Easy to add new algorithms
- **Elimination of Conditionals** - No need for complex if-else or switch statements

## 🚀 Usage Example

```java
// Create context
Context context = new Context(new OperationAdd());

// Execute strategy
System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

// Change strategy at runtime
context = new Context(new OperationSubtract());
System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

// Another strategy
context = new Context(new OperationMultiply());
System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
```

**Output:**

```
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Strategy directory
cd src/DesignPatterns/Strategy/

# Compile all Java files
javac -cp . mainClass/*.java Context/*.java classes/*.java interfaces/*.java abstractClasses/*.java

# Run the demo
java mainClass.StrategyDemo
```

## 📊 Benefits

### ✅ Advantages

- **Runtime Algorithm Selection** - Choose algorithm at runtime
- **Open/Closed Principle** - Easy to add new strategies without modifying existing code
- **Eliminates Conditional Logic** - No complex if-else chains
- **Improved Testability** - Each algorithm can be tested independently
- **Code Reusability** - Strategies can be reused in different contexts

### ❌ Disadvantages

- **Increased Number of Classes** - More classes to maintain
- **Client Awareness** - Client must be aware of different strategies
- **Communication Overhead** - Context and strategy must share data
- **Strategy Selection Logic** - Still need logic to select appropriate strategy

## 🎨 Real-World Applications

1. **Payment Processing** - Different payment methods (Credit Card, PayPal, Bank Transfer)
2. **Sorting Algorithms** - QuickSort, MergeSort, BubbleSort
3. **Compression** - ZIP, RAR, GZIP compression algorithms
4. **Validation** - Different validation rules for different forms
5. **Pricing Strategies** - Regular, discount, seasonal pricing
6. **Database Access** - Different database engines with same interface

## 🔄 Related Patterns

- **State** - Both encapsulate behavior; Strategy focuses on algorithms, State on state-dependent behavior
- **Template Method** - Strategy uses composition; Template Method uses inheritance
- **Factory Method** - Often used together to create appropriate strategies
- **Command** - Strategy focuses on algorithms; Command focuses on encapsulating requests

## 📝 Implementation Details

### Strategy Interface

```java
public interface Strategy {
    public int doOperation(int num1, int num2);
}
```

### Concrete Strategy (Addition)

```java
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
```

### Context Class

```java
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
```

## 🔍 Advanced Usage Examples

### Strategy Factory

```java
public class StrategyFactory {
    public static Strategy createStrategy(String operation) {
        switch (operation.toLowerCase()) {
            case "add": return new OperationAdd();
            case "subtract": return new OperationSubtract();
            case "multiply": return new OperationMultiply();
            default: throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}
```

### Enum-based Strategy

```java
public enum MathOperation implements Strategy {
    ADD {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBTRACT {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }
}
```

### Lambda-based Strategy (Java 8+)

```java
public class LambdaContext {
    private BinaryOperator<Integer> strategy;

    public LambdaContext(BinaryOperator<Integer> strategy) {
        this.strategy = strategy;
    }

    public int execute(int a, int b) {
        return strategy.apply(a, b);
    }
}

// Usage
LambdaContext context = new LambdaContext((a, b) -> a + b);
System.out.println(context.execute(10, 5)); // 15

context = new LambdaContext(Integer::sum);
System.out.println(context.execute(10, 5)); // 15
```

## 🎯 When to Use

- **Multiple Algorithms** - When you have multiple ways to perform a task
- **Runtime Selection** - When algorithm selection should happen at runtime
- **Avoiding Conditionals** - When you want to eliminate complex conditional logic
- **Algorithm Isolation** - When you want to isolate algorithm implementation details

## 🚨 Common Pitfalls

- **Strategy Proliferation** - Creating too many strategies for simple operations
- **Context Coupling** - Making context too dependent on specific strategies
- **Performance Overhead** - Extra indirection through strategy interface
- **Strategy Selection** - Complex logic for choosing appropriate strategy

## 🔧 Best Practices

1. **Keep Strategies Simple** - Each strategy should focus on one algorithm
2. **Consistent Interface** - All strategies should have consistent interface
3. **Immutable Strategies** - Make strategies stateless and immutable when possible
4. **Strategy Validation** - Validate strategy compatibility with context
5. **Documentation** - Document when to use each strategy

## 🎪 Pattern Variations

### Parameterized Strategy

```java
public interface ParameterizedStrategy<T> {
    T execute(T input, Object... parameters);
}
```

### Composite Strategy

```java
public class CompositeStrategy implements Strategy {
    private List<Strategy> strategies;

    @Override
    public int doOperation(int num1, int num2) {
        return strategies.stream()
            .mapToInt(strategy -> strategy.doOperation(num1, num2))
            .sum();
    }
}
```

### Cached Strategy

```java
public class CachedContext {
    private Map<String, Strategy> strategyCache = new HashMap<>();
    private Strategy currentStrategy;

    public void setStrategy(String strategyName) {
        currentStrategy = strategyCache.computeIfAbsent(strategyName,
            name -> StrategyFactory.createStrategy(name));
    }
}
```

## 💼 Business Benefits

- **Flexibility** - Easy to change business rules and algorithms
- **Maintainability** - Each algorithm is isolated and easier to maintain
- **Scalability** - Easy to add new algorithms as business grows
- **Testability** - Algorithms can be tested independently

## 🚀 Real-World Example: Payment Processing

```java
// Strategy interface
public interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

public class PayPalPayment implements PaymentStrategy {
    private String email;

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

// Context
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Usage
ShoppingCart cart = new ShoppingCart();
cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
cart.checkout(100.0);

cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
cart.checkout(75.0);
```

## 🔍 Strategy vs State Pattern

| Strategy                   | State                              |
| -------------------------- | ---------------------------------- |
| Algorithm selection        | State-dependent behavior           |
| Client chooses strategy    | Context manages state transitions  |
| Strategies are independent | States may know about other states |
| Focus on computation       | Focus on state management          |

## 🌟 Modern Java Features

### Using Java 8+ Functional Interfaces

```java
public class ModernCalculator {
    public int calculate(int a, int b, BinaryOperator<Integer> operation) {
        return operation.apply(a, b);
    }
}

// Usage
ModernCalculator calc = new ModernCalculator();
System.out.println(calc.calculate(10, 5, Integer::sum));        // Addition
System.out.println(calc.calculate(10, 5, (x, y) -> x - y));     // Subtraction
System.out.println(calc.calculate(10, 5, (x, y) -> x * y));     // Multiplication
```

---

**Category**: Behavioral Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐
