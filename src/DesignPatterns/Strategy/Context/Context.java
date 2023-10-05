package DesignPatterns.Strategy.Context;

import DesignPatterns.Strategy.abstractClasses.Computer;
import DesignPatterns.Strategy.classes.OperationAdd;
import DesignPatterns.Strategy.classes.OperationMultiply;
import DesignPatterns.Strategy.classes.OperationSubtract;
import DesignPatterns.Strategy.interfaces.Strategy;

public class Context {
    private Computer strategy;

    public Context(Computer strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
    public int computeInRange(int num1, int num2){
          Computer chainofResponsibility = new OperationAdd(new OperationSubtract( new OperationMultiply()));
          return chainofResponsibility.computeInRange(num1, num2);
    }
}
