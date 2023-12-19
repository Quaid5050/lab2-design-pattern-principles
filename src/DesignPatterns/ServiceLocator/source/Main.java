package DesignPatterns.ServiceLocator.source;

public class Main {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EmailService");
        service.execute();
        service = ServiceLocator.getService("SmsService");
        service.execute();
        service = ServiceLocator.getService("EmailService");
        service.execute();
        service = ServiceLocator.getService("SmsService");
        service.execute();

    }
}
