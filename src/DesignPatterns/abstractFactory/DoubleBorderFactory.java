package DesignPatterns.abstractFactory;

public class DoubleBorderFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("DOUBLERECTANGLE")) {
            return new DoubleBorderedRectangle();
        } else if (shapeType.equalsIgnoreCase("DOUBLETRIANGLE")) {
            return new DoubleBorderedTriangle();
        }
        return null;
    }
}
