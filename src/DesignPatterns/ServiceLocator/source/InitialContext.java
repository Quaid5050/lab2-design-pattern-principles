package DesignPatterns.ServiceLocator.source;

public class InitialContext {
    public Object lookup(String name) {
        if (name.equalsIgnoreCase("EmailService")) {
            System.out.println("Looking up and creating a new EmailService object");
            return new EmailService();
        } else if (name.equalsIgnoreCase("SmsService")) {
            System.out.println("Looking up and creating a new SmsService object");
            return new SmsService();
        }
        return null;
    }
}

