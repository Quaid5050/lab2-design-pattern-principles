package DesignPatterns.Builder;

public class Tea extends ColdDrink {
    private String sweetnessType;
    private boolean cream;
    private int sweetnessSpoons;

    public Tea() {
        // Set default values
        this.sweetnessType = "Regular";
        this.cream = false;
        this.sweetnessSpoons = 0;
    }

    public Tea sweetnessType(String sweetnessType) {
        this.sweetnessType = sweetnessType;
        return this;
    }

    public Tea withCream() {
        this.cream = true;
        return this;
    }

    public Tea sweetnessSpoons(int spoons) {
        this.sweetnessSpoons = spoons;
        return this;
    }

    @Override
    public String name() {
        return "Tea";
    }

    @Override
    public float price() {
        float basePrice = 15.0f; // Base price for Tea
        // Add additional cost for decorations
        float decorationCost = 0.0f;
        if (cream) {
            decorationCost += 2.0f; // Additional cost for cream
        }
        decorationCost += sweetnessSpoons * 0.5f; // Additional cost for sweetness
        return basePrice + decorationCost;
    }

    // Other methods to get decoration details
}
