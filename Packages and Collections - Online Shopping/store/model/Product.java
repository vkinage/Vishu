package store.model;

public class Product {

    public String productId, name, category;
    public double price;

    public Product(String productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return productId + " " + name + " " + price;
    }
}