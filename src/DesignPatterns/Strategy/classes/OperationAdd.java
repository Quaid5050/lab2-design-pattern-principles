package DesignPatterns.Strategy.classes;

import DesignPatterns.Strategy.abstractClasses.Computer;

public class OperationAdd  extends Computer {
    public OperationAdd(OperationSubtract operationSubtract){
       this.nextSuccessor = operationSubtract;
    }

    @Override
    public int doOperation(int num1, int num2){
        return num1 + num2;
    }


    @Override
    public int computeInRange(int num1, int num2) {
        if(num1 >= 0 && num1 <= 100 && num2 >= 0 && num2 <= 100 )
            return num1 + num2;
        if(nextSuccessor != null)
            return nextSuccessor.computeInRange(num1, num2);
        System.out.print("Support not available violating range.");
        return 0;
    }


}
