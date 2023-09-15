package DesignPrinciples.SingleResponsibility.with;

public class ShippingCalculator {
    public int calculateShippingCost(int price, double kilometer) {
        return (int) (price * kilometer);
    }
}
