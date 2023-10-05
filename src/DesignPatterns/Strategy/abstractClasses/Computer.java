package DesignPatterns.Strategy.abstractClasses;

import DesignPatterns.Strategy.interfaces.Strategy;

public abstract class Computer implements Strategy {

    protected Computer  nextSuccessor;
    public abstract int computeInRange(int num1, int num2);
}
