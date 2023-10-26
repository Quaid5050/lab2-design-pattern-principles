package DesignPatterns.abstractFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory();
        }
    }

    public static AbstractFactory getDoubleBorderFactory(boolean doubleBorder) {
        if (doubleBorder) {
            return new DoubleBorderFactory();
        }
        //any other factory in future can be added here
        return null;
    }
}