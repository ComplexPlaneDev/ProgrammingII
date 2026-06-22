package Menus;

import java.util.Scanner;

import Products.CinnamonRoll;
import Products.Croissant;
import Products.Schokobroetchen;

public class Product implements Menu {
    public enum CoffeeType {
        Espresso,
        LatteMacchiato,
        Cappuccino
    }

    public enum TeaType {
        EnglishBreakfast,
        Chai,
        Green
    }

    @Override
    public Products.Product selectProduct(Scanner scanner) throws Exception {
        System.out.println("\n--- MENU ---");
        System.out.println("Our Coffee:");
        System.out.println("  1. Espresso        2.00€");
        System.out.println("  2. Latte Macchiato 3.50€");
        System.out.println("  3. Cappuccino      3.00€");
        System.out.println("\nOur Tea:");
        System.out.println("  4. English Breakfast 2.50€");
        System.out.println("  5. Chai Tea          2.50€");
        System.out.println("  6. Green Tea         2.00€");
        System.out.println("\nOur Pastries:");
        System.out.println("  7. Croissant        1.00€");
        System.out.println("  8. Schokobrötchen   2.00€");
        System.out.println("  9. Cinnamon Roll    5.00€");
        System.out.println("\n  10. Exit / Checkout");
        System.out.println("------------");
        System.out.print("Your choice: ");

        do {
            switch (scanner.nextInt()) {
                case 1: return new Coffee(CoffeeType.Espresso).selectProduct(scanner);
                case 2: return new Coffee(CoffeeType.LatteMacchiato).selectProduct(scanner);
                case 3: return new Coffee(CoffeeType.Cappuccino).selectProduct(scanner);
                case 4: return new Tea(TeaType.EnglishBreakfast).selectProduct(scanner);
                case 5: return new Tea(TeaType.Chai).selectProduct(scanner);
                case 6: return new Tea(TeaType.Green).selectProduct(scanner);
                case 7: return new Croissant();
                case 8: return new Schokobroetchen();
                case 9: return new CinnamonRoll();
                case 10: return null;
                default: System.out.print("Invalid input, try again: ");
            }
        } while (true);
    }
}
