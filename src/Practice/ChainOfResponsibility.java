package Practice;

interface SupportHandler {
    void handleRequest(String request);

    void setNextHandler(SupportHandler nextHandler);
}

class BaseSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(String request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("Request cannot be handled.");
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class LevelOneSupport extends BaseSupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Level One Request")) {
            System.out.println("Level One Support handles the request: " + request);
        } else {
            super.handleRequest(request);
        }
    }
}

class LevelTwoSupport extends BaseSupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Level Two Request")) {
            System.out.println("Level Two Support handles the request: " + request);
        } else {
            super.handleRequest(request);
        }
    }
}

class LevelThreeSupport extends BaseSupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Level Three Request")) {
            System.out.println("Level Three Support handles the request: " + request);
        } else {
            super.handleRequest(request);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        SupportHandler levelOne = new LevelOneSupport();
        SupportHandler levelTwo = new LevelTwoSupport();
        SupportHandler levelThree = new LevelThreeSupport();

        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(levelThree);

        levelOne.handleRequest("Level One Request");
        levelOne.handleRequest("Level Two Request");
        levelOne.handleRequest("Level Three Request");
        levelOne.handleRequest("Unknown Request");
    }
}
