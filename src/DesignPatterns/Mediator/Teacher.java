package DesignPatterns.Mediator;

public class Teacher implements Userinterface {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {

    }

    public void sendMessage(Userinterface user, String message) {
        ChatRoom.showMessage(this, message);
    }
}
