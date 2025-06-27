# Singleton Pattern

## 📋 Overview

The **Singleton Pattern** ensures a class has only one instance and provides a global access point to that instance. It's one of the most commonly used and sometimes controversial design patterns.

## 🎯 Intent

- Ensure a class has only one instance
- Provide global access point to that instance
- Control instantiation of a class
- Lazy initialization when needed

## 🏗️ Structure

### Key Components

1. **Singleton Class** - The class that implements singleton behavior
2. **Private Constructor** - Prevents external instantiation
3. **Static Instance** - Holds the single instance
4. **Static Access Method** - Provides access to the instance

### Implementation Variations

This project demonstrates both approaches:

- **Without Singleton** (`without/` folder) - Shows problems of multiple instances
- **With Singleton** (`with/` folder) - Proper singleton implementation

## 💡 Key Features

- **Single Instance** - Only one object exists throughout application lifecycle
- **Global Access** - Accessible from anywhere in the application
- **Lazy Initialization** - Instance created only when first needed
- **Thread Safety** - Safe to use in multi-threaded environments

## 🚀 Usage Example

### Without Singleton (Problems)

```java
// Multiple instances can be created
DocumentProcessing doc1 = new DocumentProcessing();
DocumentProcessing doc2 = new DocumentProcessing();
// doc1 != doc2 (Different instances, potential inconsistency)
```

### With Singleton (Solution)

```java
// Only one instance regardless of calls
DocumentProcessing doc1 = DocumentProcessing.getInstance();
DocumentProcessing doc2 = DocumentProcessing.getInstance();
// doc1 == doc2 (Same instance, consistency guaranteed)

// Use the singleton
doc1.processDocument("sample.pdf");
```

## 🏃‍♂️ How to Run

```bash
# Run without singleton (shows problems)
cd without/
javac *.java
java DocumentProcessing

# Run with singleton (shows solution)
cd with/
javac *.java
java DocumentProcessing
```

## 📊 Benefits

### ✅ Advantages

- **Controlled Access** - Controlled access to sole instance
- **Reduced Memory** - Only one instance in memory
- **Global State** - Maintains global state across application
- **Lazy Initialization** - Created only when needed
- **Namespace Pollution** - Reduces global namespace pollution

### ❌ Disadvantages

- **Global State** - Can create hidden dependencies
- **Testing Difficulty** - Hard to unit test and mock
- **Thread Safety** - Requires careful implementation
- **Tight Coupling** - Can increase coupling between classes
- **Single Responsibility** - Violates SRP (manages instance + business logic)

## 🎨 Real-World Applications

1. **Database Connections** - Single connection pool manager
2. **Logging** - Centralized logging service
3. **Configuration Settings** - Application configuration manager
4. **Caching** - Single cache manager
5. **Thread Pools** - Single thread pool manager
6. **Device Drivers** - Single driver instance for hardware

## 🔄 Implementation Patterns

### 1. Eager Initialization

```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return INSTANCE; }
}
```

### 2. Lazy Initialization

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 3. Thread-Safe Lazy Initialization

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 4. Double-Checked Locking

```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### 5. Bill Pugh Solution (Recommended)

```java
public class Singleton {
    private Singleton() {}
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

### 6. Enum Singleton (Best Practice)

```java
public enum Singleton {
    INSTANCE;
    public void doSomething() {
        // Implementation
    }
}
```

## 🔍 Document Processing Example

The implementation shows document processing systems:

**Without Singleton Issues:**

- Multiple processing instances
- Inconsistent state management
- Resource wastage
- Configuration conflicts

**With Singleton Benefits:**

- Single processing manager
- Consistent state
- Resource optimization
- Centralized configuration

## 🎯 When to Use

- **Resource Management** - When you need to manage shared resources
- **Configuration** - For application-wide configuration
- **Logging** - Centralized logging mechanism
- **Database Connections** - Connection pool management
- **Caching** - Single cache instance

## 🚨 Common Pitfalls

- **Thread Safety** - Not handling concurrent access
- **Reflection** - Singleton can be broken using reflection
- **Serialization** - Issues with serialization/deserialization
- **Classloader** - Problems in multi-classloader environments
- **Testing** - Difficulty in unit testing

## 🔧 Best Practices

1. **Use Enum** - Preferred implementation for most cases
2. **Bill Pugh Pattern** - For non-enum implementations
3. **Avoid Synchronized** - Use double-checked locking if needed
4. **Handle Serialization** - Implement readResolve() method
5. **Consider Alternatives** - Dependency injection, factory patterns

## 🎪 Modern Alternatives

- **Dependency Injection** - IoC containers manage instances
- **Factory Pattern** - More flexible object creation
- **Registry Pattern** - Multiple named instances
- **Monostate Pattern** - All instances share same state

## ⚠️ Controversy

Singleton is often considered an anti-pattern because:

- Creates global state
- Violates Single Responsibility Principle
- Makes testing difficult
- Creates tight coupling

**Modern Approach**: Use dependency injection frameworks instead of singletons.

---

**Category**: Creational Pattern  
**Complexity**: ⭐⭐  
**Popularity**: ⭐⭐⭐⭐⭐  
**Controversy**: ⚠️ High
