package DesignPatterns.Strategy.classes;

import DesignPatterns.Strategy.abstractClasses.Computer;
import DesignPatterns.Strategy.interfaces.Strategy;

public class OperationMultiply extends Computer  {
    @Override
    public int doOperation(int num1, int num2){
        return num1 * num2;
    }

    @Override
    public int computeInRange(int num1, int num2) {
        if(num1 >= 1000 && num1 <= 5000 && num2 >= 1000 && num2 <= 5000 )
            return num1 * num2;
        if(nextSuccessor != null)
            return nextSuccessor.computeInRange(num1, num2);
        System.out.print("Support not available violating range.");
        return 0;
    }
}
