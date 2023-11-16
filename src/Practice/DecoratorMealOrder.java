package Practice;

// The base Meal class
interface Meal {
    String getDescription();
    double getPrice();
}

// Concrete implementation of a basic meal
class BasicMeal implements Meal {
    @Override
    public String getDescription() {
        return "Basic Meal";
    }

    @Override
    public double getPrice() {
        return 10.0;
    }
}

// Decorator abstract class
abstract class MealDecorator implements Meal {
    protected Meal decoratedMeal;

    public MealDecorator(Meal meal) {
        this.decoratedMeal = meal;
    }

    public String getDescription() {
        return decoratedMeal.getDescription();
    }

    public double getPrice() {
        return decoratedMeal.getPrice();
    }
}

// Concrete decorators for optional extras
class SaladDecorator extends MealDecorator {
    public SaladDecorator(Meal meal) {
        super(meal);
    }

    public String getDescription() {
        return decoratedMeal.getDescription() + ", Salad";
    }

    public double getPrice() {
        return decoratedMeal.getPrice() + 3.0;
    }
}

class DessertDecorator extends MealDecorator {
    public DessertDecorator(Meal meal) {
        super(meal);
    }

    public String getDescription() {
        return decoratedMeal.getDescription() + ", Dessert";
    }

    public double getPrice() {
        return decoratedMeal.getPrice() + 5.0;
    }
}

public class DecoratorMealOrder {
    public static void main(String[] args) {
        // Order a basic meal
        Meal basicMeal = new BasicMeal();
        System.out.println("Meal: " + basicMeal.getDescription());
        System.out.println("Price: $" + basicMeal.getPrice());

        // Add salad as a decorator
        Meal mealWithSalad = new SaladDecorator(basicMeal);
        System.out.println("\nMeal with Salad: " + mealWithSalad.getDescription());
        System.out.println("Price: $" + mealWithSalad.getPrice());

        // Add dessert as a decorator
        Meal mealWithDessert = new DessertDecorator(basicMeal);
        System.out.println("\nMeal with Dessert: " + mealWithDessert.getDescription());
        System.out.println("Price: $" + mealWithDessert.getPrice());

        // Add both salad and dessert as decorators
        Meal mealWithSaladAndDessert = new DessertDecorator(new SaladDecorator(basicMeal));
        System.out.println("\nMeal with Salad and Dessert: " + mealWithSaladAndDessert.getDescription());
        System.out.println("Price: $" + mealWithSaladAndDessert.getPrice());
    }
}

