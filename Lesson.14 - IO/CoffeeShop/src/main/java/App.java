import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
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
                    /* Dummy code to test the deserialization */
                    try (FileInputStream fileIn = new FileInputStream("order.bin");
                        ObjectInputStream in = new ObjectInputStream(fileIn)) {

                        Receipt ro = (Receipt) in.readObject();
                        System.out.println("\n--- Thank you for your order!\n\n");
                        System.out.println(ro.toString());
                    } catch (IOException e) {
                        // cannot read the order.bin file, ignore that
                    }
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

            if (!o.isEmpty()) {
                System.out.println("\n--- Thank you for your order!\n\n");
                System.out.println(o.toString());

                try (FileOutputStream fileOut = new FileOutputStream("order.bin");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(o);
                    System.out.println("Serialized data is saved in order.bin");
                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("SOFTWARE BUG!!!!!");
        } finally {
            input.close();
        }
    }
}