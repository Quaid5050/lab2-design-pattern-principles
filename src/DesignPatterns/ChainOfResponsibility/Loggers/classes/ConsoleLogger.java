package DesignPatterns.ChainOfResponsibility.Loggers.classes;

import DesignPatterns.ChainOfResponsibility.Loggers.abstractClasses.AbstractLogger;

public class ConsoleLogger  extends AbstractLogger {

        public ConsoleLogger(int level){
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("Standard Console::Logger: " + message);
        }


}
