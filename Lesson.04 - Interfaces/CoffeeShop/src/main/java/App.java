import java.util.Scanner;

import Menus.Menu;
import Orders.Receipt;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to 'Cafecito Lindo' Coffee Shop");

        Scanner input = new Scanner(System.in);

        Receipt o = new Receipt();
        Menu m = new Menus.Product();

        try {
            do {
                Products.Product product = m.selectProduct(input);
                if (product == null) {
                    break;
                }

                int quantity;
                do {
                    System.out.print("How many would you like? ");
                    quantity = input.nextInt();
                    if (quantity < 1) {
                        System.out.println("Invalid quantity, please enter a positive number.");
                    }
                } while (quantity < 1);

                o.addProduct(product, quantity);
            } while (true);

            System.out.println("\n--- Thank you for your order!\n\n");
            System.out.println(o.toString());
        } catch (Exception e) {
            System.out.println("SOFTWARE BUG!!!!!");
        } finally {
            input.close();
        }
    }
}