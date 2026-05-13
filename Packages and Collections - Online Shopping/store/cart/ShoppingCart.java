package store.cart;

import store.model.Product;
import java.util.*;

public class ShoppingCart {

    ArrayList<Product> products = new ArrayList<>();

    HashMap<String, Integer> cart = new HashMap<>();

    Stack<String> undo = new Stack<>();

    TreeMap<Double, String> sorted = new TreeMap<>();

    // Add Product
    public void addProduct(Product p) {
        products.add(p);
        sorted.put(p.price, p.name);
    }

    // Add to Cart
    public void addToCart(String id, int qty) {
        cart.put(id, qty);
        undo.push(id);
    }

    // Undo
    public void undoLast() {
        String id = undo.pop();
        cart.remove(id);
        System.out.println("Removed: " + id);
    }

    // Display Cart
    public void displayCart() {
        double total = 0;
        for (Product p : products) {

            if (cart.containsKey(p.productId)) {
                int q = cart.get(p.productId);
                double bill = q * p.price;
                total += bill;
                System.out.println(p.name + " Qty=" + q + " Bill=" + bill);
            }
        }

        System.out.println("Total = " + total);
    }

    // Sorted Products
    public void displaySorted() {
        System.out.println(sorted);
    }

    // Search Product
    public void search(String id) {
        if (cart.containsKey(id))
            System.out.println("Found in Cart");

        else
            System.out.println("Not Found");
    }
}