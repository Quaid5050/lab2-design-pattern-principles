package DesignPatterns.Mediator;

public class User implements Userinterface{
    private String name;

    @Override
    public void sendMessage(Userinterface user, String message) {
//        ChatRoom.showMessage(this,message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
//        ChatRoom.showMessage(this,message);
    }
}