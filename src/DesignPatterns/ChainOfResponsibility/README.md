# Chain of Responsibility Pattern

## 📋 Overview

The **Chain of Responsibility Pattern** passes requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## 🎯 Intent

- Avoid coupling sender of request to its receiver
- Give multiple objects a chance to handle the request
- Chain receiving objects and pass request along chain until handled
- Decide at runtime which objects in the chain handle the request

## 🏗️ Structure

### Key Components

1. **Abstract Handler** (`AbstractLogger.java`) - Defines interface for handling requests and optional link to next handler
2. **Concrete Handlers** (`ConsoleLogger.java`, `FileLogger.java`, `ErrorLogger.java`) - Handle requests they're responsible for
3. **Client** (`ChainPatternDemo.java`) - Initiates requests to chain
4. **Logger Chain** - Demonstrates logging at different levels

### Directory Structure

```
ChainOfResponsibility/
└── Loggers/
    ├── abstractClasses/
    │   └── AbstractLogger.java     # Abstract handler
    ├── classes/
    │   ├── ConsoleLogger.java      # Console logging handler
    │   ├── FileLogger.java         # File logging handler
    │   ├── ErrorLogger.java        # Error logging handler
    │   └── DatabaseLogger.java     # Database logging handler
    └── mainClass/
        └── ChainPatternDemo.java   # Demo class
```

## 💡 Key Features

- **Decoupled Request Handling** - Sender doesn't know which handler will process request
- **Dynamic Chain Configuration** - Chain can be configured at runtime
- **Flexible Request Processing** - Multiple handlers can process same request
- **Automatic Fallback** - Request automatically passes to next handler if current can't handle

## 🚀 Usage Example

```java
// Build the chain of loggers
AbstractLogger loggerChain = getChainOfLoggers();

// Send requests of different levels
loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
```

**Output:**

```
Standard Console::Logger: This is an information.

File::Logger: This is a debug level information.
Standard Console::Logger: This is a debug level information.

Error Console::Logger: This is an error information.
File::Logger: This is an error information.
Standard Console::Logger: This is an error information.
```

## 🏃‍♂️ How to Run

```bash
# Navigate to the Chain of Responsibility directory
cd src/DesignPatterns/ChainOfResponsibility/Loggers/

# Compile all Java files
javac -cp . mainClass/*.java abstractClasses/*.java classes/*.java

# Run the demo
java mainClass.ChainPatternDemo
```

## 📊 Benefits

### ✅ Advantages

- **Reduced Coupling** - Sender and receiver are decoupled
- **Flexible Chain** - Chain can be modified at runtime
- **Single Responsibility** - Each handler has single responsibility
- **Open/Closed Principle** - Easy to add new handlers without modifying existing code
- **Request Processing Control** - Fine control over request processing order

### ❌ Disadvantages

- **No Guarantee of Handling** - Request might not be handled by any handler
- **Performance** - Long chains can impact performance
- **Debugging Difficulty** - Hard to debug request flow through chain
- **Runtime Configuration** - Chain structure not obvious from code

## 🎨 Real-World Applications

1. **Logging Systems** - Different log levels (DEBUG, INFO, WARN, ERROR)
2. **Authentication** - Multiple authentication methods (LDAP, Database, Social)
3. **HTTP Request Processing** - Web server middleware/filters
4. **Event Handling** - GUI event propagation through widget hierarchy
5. **Approval Workflows** - Manager → Director → VP approval chain
6. **Exception Handling** - Different exception handlers for different exception types

## 🔄 Related Patterns

- **Command** - Both decouple sender and receiver; Chain focuses on passing through chain
- **Composite** - Chain uses similar recursive structure
- **Decorator** - Both use recursive composition; Decorator adds behavior, Chain delegates responsibility

## 📝 Implementation Details

### AbstractLogger (Abstract Handler)

```java
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
```

### ConsoleLogger (Concrete Handler)

```java
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
```

### Chain Builder Method

```java
private static AbstractLogger getChainOfLoggers() {
    AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
    AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
    AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

    errorLogger.setNextLogger(fileLogger);
    fileLogger.setNextLogger(consoleLogger);

    return errorLogger;
}
```

## 🔍 Key Implementation Features

- **Level-Based Processing** - Each logger handles messages at or above its level
- **Cascading Notifications** - Messages cascade through entire chain
- **Flexible Chain Building** - Chain built programmatically with different configurations
- **Multiple Output Destinations** - Console, file, database, error console

## 🎯 When to Use

- **Multiple Request Processors** - When multiple objects can handle a request
- **Runtime Handler Selection** - When handler should be selected at runtime
- **Decoupled Processing** - When sender shouldn't know about specific handlers
- **Configurable Processing Chain** - When processing chain needs to be configurable

## 🚨 Common Pitfalls

- **Unhandled Requests** - No guarantee that request will be handled
- **Performance Issues** - Long chains with expensive operations
- **Chain Cycles** - Circular references in chain
- **Complex Chain Logic** - Overly complex decision logic in handlers

## 🔧 Best Practices

1. **Default Handler** - Always provide a default handler at end of chain
2. **Keep Handlers Simple** - Each handler should have single responsibility
3. **Chain Validation** - Validate chain configuration
4. **Performance Monitoring** - Monitor chain performance
5. **Clear Documentation** - Document chain structure and handler responsibilities

## 🎪 Pattern Variations

### Pure Chain of Responsibility

```java
// Request handled by exactly one handler
public void handleRequest(Request request) {
    if (canHandle(request)) {
        doHandle(request);
    } else if (nextHandler != null) {
        nextHandler.handleRequest(request);
    }
}
```

### Impure Chain of Responsibility (Current Implementation)

```java
// Request can be handled by multiple handlers
public void handleRequest(Request request) {
    if (canHandle(request)) {
        doHandle(request);
    }
    if (nextHandler != null) {
        nextHandler.handleRequest(request);
    }
}
```

### Dynamic Chain Building

```java
public class ChainBuilder {
    private List<Handler> handlers = new ArrayList<>();

    public ChainBuilder addHandler(Handler handler) {
        handlers.add(handler);
        return this;
    }

    public Handler build() {
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        return handlers.isEmpty() ? null : handlers.get(0);
    }
}
```

### Generic Chain

```java
public abstract class Handler<T> {
    protected Handler<T> nextHandler;

    public void setNext(Handler<T> handler) {
        this.nextHandler = handler;
    }

    public void handle(T request) {
        if (canHandle(request)) {
            doHandle(request);
        }
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    protected abstract boolean canHandle(T request);
    protected abstract void doHandle(T request);
}
```

## 💼 Business Benefits

- **Flexible Processing** - Easy to modify processing logic
- **Scalability** - Easy to add new processors
- **Maintainability** - Each processor is independent
- **Configurability** - Processing chain can be configured per business needs

## 🚀 Advanced Examples

### HTTP Request Processing Chain

```java
public abstract class RequestHandler {
    protected RequestHandler next;

    public void setNext(RequestHandler handler) {
        this.next = handler;
    }

    public void handle(HttpRequest request) {
        if (canHandle(request)) {
            doHandle(request);
        }
        if (next != null) {
            next.handle(request);
        }
    }

    protected abstract boolean canHandle(HttpRequest request);
    protected abstract void doHandle(HttpRequest request);
}

public class AuthenticationHandler extends RequestHandler {
    @Override
    protected boolean canHandle(HttpRequest request) {
        return !request.isAuthenticated();
    }

    @Override
    protected void doHandle(HttpRequest request) {
        // Perform authentication
        System.out.println("Authenticating request...");
    }
}

public class AuthorizationHandler extends RequestHandler {
    @Override
    protected boolean canHandle(HttpRequest request) {
        return request.isAuthenticated() && !request.isAuthorized();
    }

    @Override
    protected void doHandle(HttpRequest request) {
        // Perform authorization
        System.out.println("Authorizing request...");
    }
}
```

### Approval Workflow Chain

```java
public class ApprovalHandler {
    protected ApprovalHandler superior;
    protected double approvalLimit;

    public void setApprovalLimit(double limit) {
        this.approvalLimit = limit;
    }

    public void setSuperior(ApprovalHandler superior) {
        this.superior = superior;
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= approvalLimit) {
            approve(request);
        } else if (superior != null) {
            superior.processRequest(request);
        } else {
            System.out.println("Request cannot be approved - exceeds all limits");
        }
    }

    protected abstract void approve(PurchaseRequest request);
}
```

## 🔍 Comparison with Other Patterns

| Pattern                 | Purpose                    | Structure                |
| ----------------------- | -------------------------- | ------------------------ |
| Chain of Responsibility | Pass request through chain | Linear chain             |
| Command                 | Encapsulate requests       | Single command object    |
| Observer                | Notify multiple objects    | Star/broadcast structure |
| Mediator                | Centralize communication   | Hub-and-spoke            |

---

**Category**: Behavioral Pattern  
**Complexity**: ⭐⭐⭐  
**Popularity**: ⭐⭐⭐⭐
