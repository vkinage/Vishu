// An academic analytics system uses Java Generics for type-safe grade 
// processing. Implement:    (a) Generic method compareRecords(T[] batch1, T[] 
// batch2): checks if two batches have       
// identical records in same order — test 
// with String[] (names), Integer[] (roll numbers), Double[] (marks)    (b) Generic 
// method analyseNumbers(List<? extends Number> marks):       
// compute and 
// return "Even-valued marks sum: X, Odd-valued marks sum: Y"    Real-world 
// extension:   (c) Generic class 'GradeBook<T extends Comparable<T>>': stores 
// grades;       
// methods: add(T), getMax(), getMin(), displayAll()   (d) Demonstrate 
// GradeBook<Integer> for marks and GradeBook<Double> for GPA values    (e) 
// Generic method swap(T[] arr, int i, int j): swaps two elements; test on Integer[] 
// and String[] 

import java.util.*;

class GradeBook<T extends Comparable<T>> {

    ArrayList<T> list = new ArrayList<>();

    void add(T x) {
        list.add(x);
    }

    void displayAll() {
        System.out.println(list);
    }

    T getMax() {
        return Collections.max(list);
    }

    T getMin() {
        return Collections.min(list);
    }
}

public class GenericGradeSystem {

    // Compare Arrays
    static <T> boolean compareRecords(T a[], T b[]) {

        return Arrays.equals(a, b);
    }

    // Sum Even/Odd
    static String analyseNumbers(List<? extends Number> marks) {

        int even = 0, odd = 0;

        for (Number n : marks) {

            int x = n.intValue();

            if (x % 2 == 0)
                even += x;
            else
                odd += x;
        }

        return "Even Sum = " + even +
               ", Odd Sum = " + odd;
    }

    // Swap Method
    static <T> void swap(T arr[], int i, int j) {

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        // Compare Records
        String s1[] = {"Asha", "Raj", "Priya"};
        String s2[] = {"Asha", "Raj", "Dev"};

        System.out.println(compareRecords(s1, s2));

        // Analyse Numbers
        List<Integer> marks =
                Arrays.asList(72, 85, 90, 63, 48, 76);

        System.out.println(analyseNumbers(marks));

        // GradeBook Integer
        GradeBook<Integer> g1 =
                new GradeBook<>();

        g1.add(85);
        g1.add(72);
        g1.add(91);
        g1.add(63);

        g1.displayAll();

        System.out.println("Max = " + g1.getMax());
        System.out.println("Min = " + g1.getMin());

        // GradeBook Double
        GradeBook<Double> g2 =
                new GradeBook<>();

        g2.add(8.2);
        g2.add(7.5);
        g2.add(9.1);

        g2.displayAll();

        // Swap Integer Array
        Integer a[] = {10, 20, 30};

        swap(a, 0, 2);

        System.out.println(Arrays.toString(a));

        // Swap String Array
        String str[] = {"Java", "Python"};

        swap(str, 0, 1);

        System.out.println(Arrays.toString(str));
    }
}