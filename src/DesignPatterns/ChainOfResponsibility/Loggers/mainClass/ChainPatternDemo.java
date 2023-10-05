package DesignPatterns.ChainOfResponsibility.Loggers.mainClass;

import DesignPatterns.ChainOfResponsibility.Loggers.abstractClasses.AbstractLogger;
import DesignPatterns.ChainOfResponsibility.Loggers.classes.ConsoleLogger;
import DesignPatterns.ChainOfResponsibility.Loggers.classes.DatabaseLogger;
import DesignPatterns.ChainOfResponsibility.Loggers.classes.ErrorLogger;
import DesignPatterns.ChainOfResponsibility.Loggers.classes.FileLogger;

public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

            AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
            AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
            AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
            AbstractLogger databaseLogger = new DatabaseLogger(AbstractLogger.WARNING);
            errorLogger.setNextLogger(fileLogger);
            fileLogger.setNextLogger(consoleLogger);
            consoleLogger.setNextLogger(databaseLogger);
            return errorLogger;
    }

    public static AbstractLogger getActiveChainLogger(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
//        AbstractLogger databaseLogger = new DatabaseLogger(AbstractLogger.WARNING);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
//        consoleLogger.setNextLogger(databaseLogger);
        return errorLogger;
    }



    public static void main(String[] args) {
//        AbstractLogger loggerChain = getChainOfLoggers();
//
//        loggerChain.logMessage(AbstractLogger.INFO,
//                "This is an information.");
//
//        loggerChain.logMessage(AbstractLogger.DEBUG,
//                "This is an debug level information.");
//
//        loggerChain.logMessage(AbstractLogger.ERROR,
//                "This is an error information.");
//
//        loggerChain.logMessage(AbstractLogger.WARNING,
//                "This is an warning information");

        AbstractLogger loggerChain = getActiveChainLogger();
        loggerChain.activeLogger(AbstractLogger.INFO,"This is an information.");
        loggerChain.activeLogger(AbstractLogger.DEBUG,"This is an debug level information.");
        loggerChain.activeLogger(AbstractLogger.ERROR,"This is an error information.");
        loggerChain.activeLogger(AbstractLogger.WARNING,"This is an warning information");
    }
}