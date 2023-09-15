package DesignPrinciples.SingleResponsibility.with;

public class PriceCalculator {
    public int calculatePriceWithTax(int price) {
        return price * 120 / 100;
    }
}
