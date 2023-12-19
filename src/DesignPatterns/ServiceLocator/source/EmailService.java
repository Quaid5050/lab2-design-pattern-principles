package DesignPatterns.ServiceLocator.source;

public class EmailService implements Service {
    @Override
    public String getName() {
        return "EmailService";
    }

    @Override
    public void execute() {
        System.out.println("Executing EmailService");
    }
}
