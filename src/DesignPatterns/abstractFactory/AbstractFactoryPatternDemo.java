package DesignPatterns.abstractFactory;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Get shape factory for normal shapes
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        // Get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        // Call draw method of Shape Rectangle
        shape1.draw();

        // Get an object of Shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        // Call draw method of Shape Square
        shape2.draw();

        // Get shape factory for rounded shapes
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

        // Get an object of Shape Rectangle
        Shape shape3 = shapeFactory1.getShape("RECTANGLE");
        // Call draw method of Shape Rectangle
        shape3.draw();

        // Get an object of Shape Square
        Shape shape4 = shapeFactory1.getShape("SQUARE");
        // Call draw method of Shape Square
        shape4.draw();

        // Create and display the new products: Double Bordered Rectangle and Double Bordered Triangle
        AbstractFactory doubleBorderFactory = FactoryProducer.getDoubleBorderFactory();

        Shape shape5 = doubleBorderFactory.getShape("DOUBLERECTANGLE");
        shape5.draw();
        Shape shape6 = doubleBorderFactory.getShape("DOUBLETRIANGLE");
        shape6.draw();
    }
}
