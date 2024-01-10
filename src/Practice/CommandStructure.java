
/*
    * Command Pattern - Behavioral Pattern
    * Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

   * Participants
    ● Command
         ❍ declares an interface for executing an operation.
    ● ConcreteCommand (PasteCommand, OpenCommand)
        ❍ defines a binding between a Receiver object and an action.
        ❍ implements Execute by invoking the corresponding operation(s) on Receiver.
    ● Client (Application)
        ❍ creates a ConcreteCommand object and sets its receiver.
    ● Invoker (MenuItem)
        ❍ asks the command to carry out the request.
    ● Receiver (Document, Application)
        ❍ knows how to perform the operations associated with carrying out a request. Any class may
        serve as a Receiver.
 */



// Command Interface
interface Command {
    void execute();
}

// Concrete Command Implementations
// Paste Command
class PasteCommand implements Command {
    private final Receiver receiver;

    public PasteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performPaste();
    }
}

// Open Command
class OpenCommand implements Command {
    private final Receiver receiver;

    public OpenCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.performOpen();
    }
}

// Receiver Interface
interface Receiver {
    void performPaste();
    void performOpen();
}

// Concrete Receiver Implementations
// Document Receiver
class Document implements Receiver {
    @Override
    public void performPaste() {
        System.out.println("Paste operation in document");
    }

    @Override
    public void performOpen() {
        System.out.println("Open operation in document");
    }
}

// Application Receiver
class Application implements Receiver {
    @Override
    public void performPaste() {
        System.out.println("Paste operation in application");
    }

    @Override
    public void performOpen() {
        System.out.println("Open operation in application");
    }
}

// Client (Application)
class CommandClient {
    public static void main(String[] args) {
        // Create Receivers
        Receiver document = new Document();
        Receiver application = new Application();

        // Create Commands and associate with respective Receivers
        Command pasteDocumentCommand = new PasteCommand(document);
        Command openApplicationCommand = new OpenCommand(application);

        // Invoker (MenuItem) - Simulating Invoker behavior
        // Issue requests by calling execute on commands
        pasteDocumentCommand.execute(); // Paste operation in document
        openApplicationCommand.execute(); // Open operation in application
    }
}

public class CommandStructure {
    public static void main(String[] args) {
        CommandClient.main(args);
    }
}
