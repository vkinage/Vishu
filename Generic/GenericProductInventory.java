// A product inventory system uses Java Generics for type-safe operations. 
// Implement:    (a) Generic method checkIdentical(T[] arr1, T[] arr2): compares two 
// arrays of same type element-by-element       and returns true if identical in order 
// — use this with Integer[], String[], and Double[] arrays    (b) Generic method 
// sumByParity(List<? extends Number> numbers):       returns a String "Even 
// Sum: X, Odd Sum: Y" (treat even/odd by int value of each number)    Real-world 
// scenario:   (c) Generic class 'Inventory<T>': holds a list of items; methods add(T 
// item), remove(T item),       display(), contains(T item)   (d) Instantiate 
// Inventory<String> for product names, Inventory<Integer> for product codes,       
// Inventory<Double> for prices — demonstrate type safety    (e) Show that 
// Inventory<String> cannot hold an Integer (compile-time error — comment it) 

import java.util.*;

class Inventory<T> {

    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    void remove(T item) {
        list.remove(item);
    }

    void display() {
        System.out.println(list);
    }

    boolean contains(T item) {
        return list.contains(item);
    }
}

public class GenericProductInventory {

    // Generic Method
    static <T> boolean checkIdentical(T arr1[], T arr2[]) {

        return Arrays.equals(arr1, arr2);
    }

    // Wildcard Method
    static String sumByParity(List<? extends Number> nums) {

        int even = 0, odd = 0;

        for (Number n : nums) {

            int x = n.intValue();

            if (x % 2 == 0)
                even += x;
            else
                odd += x;
        }

        return "Even Sum: " + even + ", Odd Sum: " + odd;
    }

    public static void main(String[] args) {

        // Generic Array Compare
        Integer a1[] = {10, 20, 30};
        Integer a2[] = {10, 20, 30};

        System.out.println(checkIdentical(a1, a2));

        // Sum By Parity
        List<Integer> list =
                Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(sumByParity(list));

        // Inventory<String>
        Inventory<String> p =
                new Inventory<>();

        p.add("Laptop");
        p.add("Mouse");

        p.display();

        // Inventory<Integer>
        Inventory<Integer> code =
                new Inventory<>();

        code.add(101);
        code.add(102);

        code.display();

        // Inventory<Double>
        Inventory<Double> price =
                new Inventory<>();

        price.add(50000.0);
        price.add(1200.0);

        price.display();

        // Compile Time Error
        // p.add(100);
    }
}