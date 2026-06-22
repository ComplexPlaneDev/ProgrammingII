package Menus;

import java.util.Scanner;

import Products.ChaiTea;
import Products.ComposableProduct;
import Products.EnglishBreakfastTea;
import Products.GreenTea;
import Products.Product;
import Products.Addons.Honey;
import Products.Addons.Lemon;

public class Tea implements Menu {
    private ComposableProduct product = null;

    public Tea(Menus.Product.TeaType type) throws Exception {
        switch (type) {
            case Menus.Product.TeaType.EnglishBreakfast:
                product = new EnglishBreakfastTea();
                break;

            case Menus.Product.TeaType.Chai:
                product = new ChaiTea();
                break;

            case Menus.Product.TeaType.Green:
                product = new GreenTea();
                break;

            default:
                throw new Exception("Invalid Tea type");
        }
    }

    @Override
    public Product selectProduct(Scanner scanner) {
        do {
            System.out.println("Add a flavor?");
            System.out.println("  1. No");
            System.out.println("  2. Honey  +0.30€");
            System.out.println("  3. Lemon  +0.30€");
            System.out.print("Your choice: ");

            switch (scanner.nextInt()) {
                case 1:
                    return product;

                case 2:
                    product.addOnTop(new Honey());
                    break;

                case 3:
                    product.addOnTop(new Lemon());
                    break;

                default:
                    System.out.print("Invalid input, try again: ");
            }
        } while (true);
    }
}
