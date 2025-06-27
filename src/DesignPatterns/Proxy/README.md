# Proxy Pattern

## 📋 Overview

The **Proxy Pattern** provides a placeholder or surrogate for another object to control access to it. It acts as an intermediary between the client and the target object, adding a layer of control.

## 🎯 Intent

- Provide a surrogate or placeholder for another object
- Control access to the original object
- Add additional functionality without changing the original object
- Defer expensive operations until necessary

## 🏗️ Structure

### Key Components

1. **Subject Interface** (`Image.java`, `Exam.java`) - Common interface for RealSubject and Proxy
2. **RealSubject** (`RealImage.java`, `RealExam.java`) - The actual object that does the work
3. **Proxy** (`ProxyImage.java`, `VirtualProxyImage.java`) - Controls access to RealSubject
4. **Client** (`ProxyPatternDemo.java`) - Uses the proxy to access the real object

### Available Examples

The implementation includes multiple proxy examples:

- **Image Proxy** - Virtual proxy for lazy loading of images
- **Exam Proxy** - Protection proxy controlling access to exam results
- **Virtual Proxy** - Demonstrates virtual proxy pattern

## 💡 Key Features

- **Controlled Access** - Control when and how the real object is accessed
- **Lazy Initialization** - Create expensive objects only when needed
- **Access Control** - Add security or permission checks
- **Caching** - Cache results to improve performance
- **Logging** - Add logging without modifying original object

## 🚀 Usage Example

### Image Proxy (Virtual Proxy)

```java
// Virtual proxy - image loaded only when displayed
Image image1 = new ProxyImage("test_10mb.jpg");
Image image2 = new ProxyImage("test_20mb.jpg");

// Image not loaded yet
System.out.println("First display:");
image1.display(); // Now image gets loaded and displayed

System.out.println("\nSecond display:");
image1.display(); // Image already loaded, just displayed
```

### Exam Proxy (Protection Proxy)

```java
// Protection proxy - controls access based on user role
Student student = new Student("John", "12345");
Teacher teacher = new Teacher("Smith", "T001");

Exam examForStudent = new ExamResults(student);
Exam examForTeacher = new ExamResults(teacher);

// Student can only view their own results
examForStudent.showResults(student); // Allowed

// Teacher can view all results
examForTeacher.showResults(student); // Allowed
```

**Output:**

```
First display:
Loading image from disk: test_10mb.jpg
Displaying image: test_10mb.jpg

Second display:
Displaying image: test_10mb.jpg

Student John viewing exam results...
Results: Math: 85, Physics: 78, Chemistry: 92

Teacher Smith accessing exam results for student...
Results: Math: 85, Physics: 78, Chemistry: 92
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Proxy directory
cd src/DesignPatterns/Proxy/

# Compile all Java files
javac *.java

# Run the demo
java ProxyPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Controlled Access** - Fine-grained control over object access
- **Lazy Loading** - Expensive objects created only when needed
- **Performance** - Caching and optimization without changing original code
- **Security** - Add authentication and authorization
- **Transparency** - Client doesn't know it's using a proxy

### ❌ Disadvantages

- **Complexity** - Additional layer of abstraction
- **Response Time** - May introduce latency
- **Maintenance** - More code to maintain
- **Memory Usage** - Proxy objects consume additional memory

## 🎨 Real-World Applications

1. **Web Caching** - Proxy servers cache web content
2. **Database Connection Pooling** - Connection proxies manage database connections
3. **Security Firewalls** - Network proxies control access to resources
4. **ORM Frameworks** - Lazy loading of database entities
5. **Remote Object Access** - Remote proxies for distributed systems
6. **Image/Video Loading** - Virtual proxies for media content

## 🔄 Proxy Types

### 1. Virtual Proxy

- Controls access to expensive-to-create objects
- Implements lazy initialization
- Example: Image loading proxy

### 2. Protection Proxy

- Controls access based on permissions
- Implements access control
- Example: Exam results proxy

### 3. Remote Proxy

- Represents object in different address space
- Handles network communication
- Example: Web service proxies

### 4. Caching Proxy

- Caches results of expensive operations
- Improves performance through caching
- Example: Database query cache

## 📝 Implementation Details

### Image Interface (Subject)

```java
public interface Image {
    void display();
}
```

### RealImage Class (RealSubject)

```java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}
```

### ProxyImage Class (Proxy)

```java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

## 🔍 Advanced Features

### Caching Proxy

```java
public class CachingImageProxy implements Image {
    private static Map<String, RealImage> cache = new HashMap<>();
    private String fileName;

    @Override
    public void display() {
        RealImage image = cache.get(fileName);
        if (image == null) {
            image = new RealImage(fileName);
            cache.put(fileName, image);
        }
        image.display();
    }
}
```

### Logging Proxy

```java
public class LoggingImageProxy implements Image {
    private RealImage realImage;
    private String fileName;

    @Override
    public void display() {
        System.out.println("Accessing image: " + fileName);
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
        System.out.println("Image access completed: " + fileName);
    }
}
```

## 🎯 When to Use

- **Expensive Object Creation** - When object creation is costly
- **Access Control** - When you need to control access to an object
- **Lazy Loading** - When you want to defer object creation
- **Caching** - When you want to cache expensive operations
- **Remote Access** - When accessing remote objects

## 🚨 Common Pitfalls

- **Overuse** - Don't use proxy when simple delegation would suffice
- **Performance Overhead** - Be aware of additional method calls
- **Memory Leaks** - Proxies might hold references longer than needed
- **Complexity** - Don't make proxy logic too complex

## 🔧 Best Practices

1. **Keep Interface Simple** - Proxy should implement same interface as real object
2. **Lazy Initialization** - Use lazy initialization for expensive operations
3. **Error Handling** - Handle errors gracefully in proxy
4. **Thread Safety** - Consider thread safety for shared proxies
5. **Documentation** - Document proxy behavior clearly

## 🎪 Pattern Variations

### Smart Proxy

```java
public class SmartImageProxy implements Image {
    private RealImage realImage;
    private int accessCount = 0;

    @Override
    public void display() {
        accessCount++;
        System.out.println("Access count: " + accessCount);

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

### Synchronized Proxy

```java
public class SynchronizedImageProxy implements Image {
    private RealImage realImage;
    private final Object lock = new Object();

    @Override
    public void display() {
        synchronized (lock) {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }
}
```

### Dynamic Proxy (Java)

```java
public class DynamicImageProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        // Add proxy behavior here
        System.out.println("Method called: " + method.getName());
        return method.invoke(target, args);
    }
}
```

## 🔄 Related Patterns

- **Adapter** - Changes interface; Proxy keeps same interface
- **Decorator** - Adds behavior; Proxy controls access
- **Facade** - Simplifies interface; Proxy controls access to single object

## 💼 Business Benefits

- **Performance Optimization** - Lazy loading improves application startup time
- **Security Enhancement** - Access control protects sensitive resources
- **Resource Management** - Better management of expensive resources
- **Scalability** - Caching proxies improve system scalability

## 🚀 Advanced Concepts

### Proxy Chaining

```java
Image image = new LoggingImageProxy(
    new CachingImageProxy(
        new SecurityImageProxy(
            new RealImage("sensitive_image.jpg")
        )
    )
);
```

### Proxy Factory

```java
public class ProxyFactory {
    public static Image createImageProxy(String fileName, ProxyType type) {
        switch (type) {
            case VIRTUAL: return new VirtualImageProxy(fileName);
            case PROTECTION: return new ProtectionImageProxy(fileName);
            case CACHING: return new CachingImageProxy(fileName);
            default: return new ProxyImage(fileName);
        }
    }
}
```

---

**Category**: Structural Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐⭐
