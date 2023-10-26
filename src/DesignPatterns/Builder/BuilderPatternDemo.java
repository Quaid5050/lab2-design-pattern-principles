package DesignPatterns.Builder;

import java.util.Scanner;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal customMeal = mealBuilder.createCustomMeal(); // Create a new custom meal

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our restaurant!");
        System.out.println("Choose your meal (Veg/Non-Veg): ");
        String mealType = scanner.nextLine();

        if (mealType.equalsIgnoreCase("Veg") || mealType.equalsIgnoreCase("Non-Veg")) {
            System.out.println("Select your main item (e.g., burger): ");
            System.out.println("1. Veg Burger");
            System.out.println("2. Chicken Burger");
            System.out.print("Enter your choice (1-2): ");
            int mainItemChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (mainItemChoice == 1) {
                if (mealType.equalsIgnoreCase("Veg")) {
                    customMeal.addItem(new VegBurger());
                } else {
                    System.out.println("Invalid choice for Veg meal.");
                }
            } else if (mainItemChoice == 2) {
                if (mealType.equalsIgnoreCase("Non-Veg")) {
                    customMeal.addItem(new ChickenBurger());
                } else {
                    System.out.println("Invalid choice for Non-Veg meal.");
                }
            } else {
                System.out.println("Invalid choice for main item.");
            }

            System.out.print("Do you want a beverage (yes/no)? ");
            String beverageChoice = scanner.nextLine();

            if (beverageChoice.equalsIgnoreCase("yes")) {
                System.out.println("Select your beverage:");
                System.out.println("1. Tea");
                System.out.println("2. Coke");
                System.out.println("3. Pepsi");
                System.out.println("4. Diet Coke");
                System.out.println("5. Diet Pepsi");
                System.out.print("Enter your choice (1-5): ");
                int beverageOption = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (beverageOption) {
                    case 1:
                        Tea tea = new Tea();
                        System.out.print("Sweetness Type (Regular/Sugar-Free): ");
                        String sweetnessType = scanner.nextLine();
                        tea.sweetnessType(sweetnessType);
                        System.out.print("With Cream (yes/no): ");
                        String creamChoice = scanner.nextLine();
                        if (creamChoice.equalsIgnoreCase("yes")) {
                            tea.withCream();
                        }
                        System.out.print("Amount of Sweetness (in spoons): ");
                        int sweetnessSpoons = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        tea.sweetnessSpoons(sweetnessSpoons);
                        customMeal.addItem(tea);
                        break;
                    case 2:
                        customMeal.addItem(new Coke());
                        break;
                    case 3:
                        customMeal.addItem(new Pepsi());
                        break;

                    default:
                        System.out.println("Invalid choice for beverage.");
                }
            }

            scanner.close();

            System.out.println("\nYour Customized Meal:");
            customMeal.showItems();
            System.out.println("Total Cost: " + customMeal.getCost());
        } else {
            System.out.println("Invalid meal type.");
        }
    }
}
