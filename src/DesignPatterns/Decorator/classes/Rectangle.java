package DesignPatterns.Decorator.classes;

import DesignPatterns.Decorator.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}