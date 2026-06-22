package Menus;

import java.util.Scanner;

import Products.Cappuccino;
import Products.ComposableProduct;
import Products.Espresso;
import Products.LatteMacchiato;
import Products.Product;
import Products.Addons.Chocolate;
import Products.Addons.Hazelnut;
import Products.Addons.Vanilla;

public class Coffee implements Menu {
    private ComposableProduct product = null;

    public Coffee(Menus.Product.CoffeeType type) throws Exception {
        switch (type) {
            case Menus.Product.CoffeeType.Espresso:
                product = new Espresso();
                break;

            case Menus.Product.CoffeeType.Cappuccino:
                product = new Cappuccino();
                break;

            case Menus.Product.CoffeeType.LatteMacchiato:
                product = new LatteMacchiato();
                break;

            default:
                throw new Exception("Invalid Coffee type");
        }
    }

    @Override
    public Product selectProduct(Scanner scanner) {
        do {
            System.out.println("Add a flavor?");
            System.out.println("  1. No");
            System.out.println("  2. Chocolate  +0.30€");
            System.out.println("  3. Hazelnut   +0.30€");
            System.out.println("  4. Vanilla    +0.30€");
            System.out.print("Your choice: ");

            switch (scanner.nextInt()) {
                case 1:
                    return product;

                case 2:
                    product.addOnTop(new Chocolate());
                    break;

                case 3:
                    product.addOnTop(new Hazelnut());
                    break;

                case 4:
                    product.addOnTop(new Vanilla());
                    break;

                default:
                    System.out.print("Invalid input, try again: ");
            }
        } while (true);
    }
}
