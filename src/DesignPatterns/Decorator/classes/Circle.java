package DesignPatterns.Decorator.classes;

import DesignPatterns.Decorator.interfaces.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}