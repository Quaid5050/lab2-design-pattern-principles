package DesignPatterns.ServiceLocator.source;

import DesignPatterns.ServiceLocator.source.Service;

public class SmsService implements Service {
    @Override
    public String getName() {
        return "SmsService";
    }

    @Override
    public void execute() {
        System.out.println("Executing SmsService");
    }
}
