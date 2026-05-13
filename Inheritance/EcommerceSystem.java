// An e-commerce platform sells different product categories. Model this with Java 
// Inheritance:   • Base class 'Product': productId, name, price; method 
// displayProduct()   • Class 'Electronics' extends Product: brand, warrantyYears; 
// method displayElectronics()   • Class 'Clothing' extends Product: size, material; 
// method displayClothing()   • Class 'Grocery' extends Product: expiryDate, 
// weightKg; method displayGrocery()  Tasks:   (a) Demonstrate Hierarchical 
// inheritance (Electronics, Clothing, Grocery all extend Product)   (b) Create 2 
// objects of each subclass with different details   (c) Override the displayProduct() 
// method in each subclass to show category-specific info   (d) Call the parent 
// version using 'super.displayProduct()' within each override

// Base Class
class Product {
    String productId;
    String name;
    double price;

    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics Class
class Electronics extends Product {
    String brand;
    int warrantyYears;

    Electronics(String productId, String name, double price,
                String brand, int warrantyYears) {
        super(productId, name, price);
        this.brand = brand;
        this.warrantyYears = warrantyYears;
    }

    @Override
    void displayProduct() {
        super.displayProduct(); // calling parent method
        System.out.println("Category: Electronics");
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyYears + " years");
        System.out.println();
    }
}

// Clothing Class
class Clothing extends Product {
    String size;
    String material;

    Clothing(String productId, String name, double price,
             String size, String material) {
        super(productId, name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    void displayProduct() {
        super.displayProduct();
        System.out.println("Category: Clothing");
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.println();
    }
}

// Grocery Class
class Grocery extends Product {
    String expiryDate;
    double weightKg;

    Grocery(String productId, String name, double price,
            String expiryDate, double weightKg) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
        this.weightKg = weightKg;
    }

    @Override
    void displayProduct() {
        super.displayProduct();
        System.out.println("Category: Grocery");
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println();
    }
}

// Main Class
public class EcommerceSystem {
    public static void main(String[] args) {

        // 2 Electronics objects
        Electronics e1 = new Electronics("P001", "Samsung Phone", 25000, "Samsung", 2);
        Electronics e2 = new Electronics("P002", "Laptop", 55000, "Dell", 3);

        // 2 Clothing objects
        Clothing c1 = new Clothing("C001", "Blue Shirt", 799, "M", "Cotton");
        Clothing c2 = new Clothing("C002", "Jeans", 1499, "L", "Denim");

        // 2 Grocery objects
        Grocery g1 = new Grocery("G001", "Rice Bag", 1200, "2026-12-10", 10);
        Grocery g2 = new Grocery("G002", "Wheat Flour", 600, "2026-08-05", 5);

        System.out.println("----- ELECTRONICS -----");
        e1.displayProduct();
        e2.displayProduct();

        System.out.println("----- CLOTHING -----");
        c1.displayProduct();
        c2.displayProduct();

        System.out.println("----- GROCERY -----");
        g1.displayProduct();
        g2.displayProduct();
    }
}