import java.util.*;

interface Discountable {
    double applyDiscount(double percent);
}

interface Trackable {
    String trackOrder();
}

// Abstract Class
abstract class FoodItem {

    String itemName;
    double price;

    FoodItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    abstract void prepareItem();

    void displayItem() {

        System.out.println(this.itemName + " " + this.price);
    }
}

// Veg Item
class VegItem extends FoodItem implements Discountable, Trackable {

    VegItem(String itemName, double price) {
        super(itemName, price);
    }

    void prepareItem() {
        System.out.println("Preparing Veg: " + this.itemName);
    }

    public double applyDiscount(double percent) {
        return this.price - (this.price * percent / 100);
    }

    public String trackOrder() {
        return "Delivery in 20 mins";
    }
}

// NonVeg Item
class NonVegItem extends FoodItem implements Discountable, Trackable {

    NonVegItem(String itemName, double price) {
        super(itemName, price);
    }

    void prepareItem() {
        System.out.println("Preparing Non-Veg: " + this.itemName);
    }

    public double applyDiscount(double percent) {
        return this.price - (this.price * percent / 100);
    }

    public String trackOrder() {
        return "Delivery in 30 mins";
    }
}

public class FoodDeliveryApp {

    public static void main(String[] args) {

        ArrayList<FoodItem> list = new ArrayList<>();

        list.add(new VegItem("Paneer Butter Masala", 320));

        list.add(new NonVegItem("Chicken Biryani", 280));

        list.add(new VegItem("Dal Tadka", 180));

        list.add(new NonVegItem("Mutton Curry", 380));

        // Prepare + Discount + Track
        for (FoodItem f : list) {

            f.prepareItem();

            double finalPrice = ((Discountable) f).applyDiscount(10);

            System.out.println("Final Price = " + finalPrice);

            System.out.println(((Trackable) f).trackOrder());
        }

        // Sort by Price using Lambda
        list.sort((a, b) -> Double.compare(a.price, b.price));

        // Final Menu using forEach Lambda
        System.out.println("\nSorted Menu:\n");

        list.forEach(f -> {

            double p = ((Discountable) f).applyDiscount(10);

            System.out.println(f.itemName + " : " + p);
        });
    }
}