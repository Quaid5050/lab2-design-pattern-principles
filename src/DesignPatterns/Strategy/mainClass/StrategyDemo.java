package DesignPatterns.Strategy.mainClass;

import DesignPatterns.Strategy.Context.Context;
import DesignPatterns.Strategy.classes.OperationAdd;
import DesignPatterns.Strategy.classes.OperationMultiply;
import DesignPatterns.Strategy.classes.OperationSubtract;

public class StrategyDemo {
    public static void main(String[] args){
      Context context = new Context(new OperationAdd(new OperationSubtract(new OperationMultiply())));
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationSubtract());
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        System.out.println("Combination of Chain of Responsibility  and Strategy Pattern");
        System.out.println("Compute in range 10 and 5 = " + context.computeInRange(10, 5));
        System.out.println("Compute in range 1000 and 5000 = " + context.computeInRange(1000, 5000));
        System.out.println("Compute in range 10000 and  20000 = " + context.computeInRange(10000, 20000));
    }
}
