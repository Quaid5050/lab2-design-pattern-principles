package DesignPrinciples.SingleResponsibility.with;

public class Book {
    private String title;
    private String author;
    private int price;
    private double kiloMeter;
    private ShippingCalculator shippingCalculator;
    private PriceCalculator priceCalculator;


    public Book(String title, String author, int price, double kiloMeter) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.kiloMeter = kiloMeter;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);

        shippingCalculator = new ShippingCalculator();
        int shippingCost = shippingCalculator.calculateShippingCost(price, kiloMeter);
        System.out.println("Shipping Cost: $" + shippingCost);

        priceCalculator = new PriceCalculator();
        int priceWithTax = priceCalculator.calculatePriceWithTax(price);
        System.out.println("Price with Tax: $" + priceWithTax);

        int totalPrice = priceWithTax + shippingCost;
        System.out.println("Total Price: $" + totalPrice);
    }
}
