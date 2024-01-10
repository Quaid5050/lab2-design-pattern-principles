package Practice.state;
//State Design Pattern

// Context
class TCPConnection {
    private TCPState state;

    public TCPConnection(TCPState state) {
        this.state = state;
    }

    public void setState(TCPState state) {
        this.state = state;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void acknowledge() {
        state.acknowledge();
    }
}

// State
interface TCPState {
    void open();
    void close();
    void acknowledge();
}

// ConcreteStateA
class TCPEstablished implements TCPState {
    @Override
    public void open() {
        System.out.println("TCP Connection is already established");
    }

    @Override
    public void close() {
        System.out.println("Closing TCP Connection");
    }

    @Override
    public void acknowledge() {
        System.out.println("Acknowledging TCP Connection");
    }
}

// ConcreteStateB
class TCPListen implements TCPState {
    @Override
    public void open() {
        System.out.println("Opening TCP Connection");
    }

    @Override
    public void close() {
        System.out.println("TCP Connection is already closed");
    }

    @Override
    public void acknowledge() {
        System.out.println("TCP Connection is not established yet");
    }
}

// ConcreteStateC
class TCPClosed implements TCPState {
    @Override
    public void open() {
        System.out.println("Opening TCP Connection");
    }

    @Override
    public void close() {
        System.out.println("TCP Connection is already closed");
    }

    @Override
    public void acknowledge() {
        System.out.println("TCP Connection is not established yet");
    }
}
public class TCPConnectionClient {
    public static void main(String[] args) {
        TCPConnection connection = new TCPConnection(new TCPClosed());
        connection.open();
        connection.acknowledge();
        connection.close();

        connection.setState(new TCPListen());
        connection.open();
        connection.acknowledge();
        connection.close();

        connection.setState(new TCPEstablished());
        connection.open();
        connection.acknowledge();
        connection.close();
    }
}
