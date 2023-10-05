package DesignPatterns.ChainOfResponsibility.Loggers.classes;

import DesignPatterns.ChainOfResponsibility.Loggers.abstractClasses.AbstractLogger;

public class DatabaseLogger extends AbstractLogger {

    public DatabaseLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Database::Logger: " + message);
    }
}
