package DesignPatterns.Strategy.classes;

import DesignPatterns.Strategy.abstractClasses.Computer;
import DesignPatterns.Strategy.interfaces.Strategy;

public class OperationSubtract  extends Computer {

    public OperationSubtract() {
    }
    public OperationSubtract(OperationMultiply operationMultiply) {
        this.nextSuccessor = operationMultiply;
    }


    @Override
    public int doOperation(int num1, int num2){
        return num1 - num2;
    }
    @Override
    public int computeInRange(int num1, int num2) {
        if(num1 >= 100 && num1 <= 1000 && num2 >= 100 && num2 <= 1000 )
            return num1 - num2;
        if(nextSuccessor != null)
            return nextSuccessor.computeInRange(num1, num2);
        System.out.print("Support not available violating range.");
        return 0;
    }
}
