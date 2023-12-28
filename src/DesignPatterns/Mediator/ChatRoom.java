package DesignPatterns.Mediator;

import java.util.Date;
public class ChatRoom {
    public static void showMessage(Teacher user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}