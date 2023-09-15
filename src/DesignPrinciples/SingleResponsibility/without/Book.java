package DesignPrinciples.SingleResponsibility.without;

public class Book {
    private String title;
    private String author;
    private int price;
    private double kilometer;

    public Book(String title, String author, int price, double kilometer) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.kilometer = kilometer;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);

        int shippingCost = calculateShippingCost(price, kilometer);
        System.out.println("Shipping Cost: $" + shippingCost);

        int priceWithTax = calculatePriceWithTax(price);
        System.out.println("Price with Tax: $" + priceWithTax);

        int totalPrice = priceWithTax + shippingCost;
        System.out.println("Total Price: $" + totalPrice);

    }

    public int calculateShippingCost(int price, double kilometer) {
        return (int) (price * kilometer);
    }

    public int calculatePriceWithTax(int price) {
        return price * 120 / 100;
    }

}