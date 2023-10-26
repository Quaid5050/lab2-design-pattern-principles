package DesignPatterns.Builder;

public class MealBuilder {

    public Meal createCustomMeal() {
        return new Meal();
    }

    public Meal addBurger(Meal meal, Burger burger) {
        meal.addItem(burger);
        return meal;
    }

    public Meal addBeverage(Meal meal, ColdDrink beverage) {
        meal.addItem(beverage);
        return meal;
    }


}
