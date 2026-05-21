package Menus;

import java.util.Scanner;

import Products.Product;

public interface Menu {
    Product selectProduct(Scanner scanner) throws Exception;
}

