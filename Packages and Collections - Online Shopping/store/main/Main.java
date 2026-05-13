package store.main;

import store.model.Product;
import store.cart.ShoppingCart;

public class Main {

    public static void main(String[] args) {
        ShoppingCart s =new ShoppingCart();

        // Add Products
        s.addProduct(new Product("P1", "Phone", 25000, "Electronics"));

        s.addProduct(new Product("P2", "Laptop", 65000, "Electronics"));

        s.addProduct(new Product("P3", "Earphones", 2000, "Electronics"));

        s.addProduct(new Product("P4", "Mouse", 800, "Electronics"));

        s.addProduct(new Product("P5", "Keyboard", 1500, "Electronics"));

        s.addProduct(new Product("P6", "Monitor", 12000, "Electronics"));

        // Add to Cart
        s.addToCart("P1", 1);
        s.addToCart("P3", 2);
        s.addToCart("P4", 1);
        s.addToCart("P5", 1);

        // Display Cart
        System.out.println("Cart:");
        s.displayCart();

        // Undo
        System.out.println("\nUndo:");
        s.undoLast();

        // Sorted Products
        System.out.println("\nSorted Products:");
        s.displaySorted();

        // Search
        System.out.println("\nSearch:");
        s.search("P1");
    }
}