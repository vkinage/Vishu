// A college admission office tracks the number of students admitted. Design a 
// Java program:   • Class 'Student': name, rollNo, branch; static variable 
// totalAdmitted (auto-incremented in constructor)   • final variable 
// MAX_CAPACITY = 60 (cannot change once set)   • Constructor uses 'this' 
// keyword to assign values; calls super() if Student extends Person   • Static 
// method getTotalAdmitted() returns current count   • Method displayStudent() 
// shows all details  Tasks:   (a) Create 5 Student objects and verify totalAdmitted 
// increments correctly   (b) Try reassigning MAX_CAPACITY — show and explain 
// the compile error (comment it)   (c) Show use of 'this()' constructor chaining for a 
// default constructor   (d) Show 'super' calling parent class (Person) constructor 

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

// Student extends Person
class Student extends Person {

    String rollNo;
    String branch;

    // static variable (shared by all objects)
    static int totalAdmitted = 0;

    // final variable (constant)
    final int MAX_CAPACITY = 60;

    // Default constructor using this()
    Student() {
        this("Unknown", "NA", "NA");
    }

    // Parameterized constructor
    Student(String name, String rollNo, String branch) {
        super(name); // calling parent constructor using super
        this.rollNo = rollNo;
        this.branch = branch;

        totalAdmitted++; // auto-increment count
    }

    // static method
    static int getTotalAdmitted() {
        return totalAdmitted;
    }

    void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Branch: " + branch);
        System.out.println("MAX_CAPACITY: 60");
        System.out.println();
    }
}

// Main Class
public class AdmissionSystem {
    public static void main(String[] args) {

        // Creating 5 students
        Student s1 = new Student("Asha", "CS01", "CS");
        Student s2 = new Student("Raj", "IT01", "IT");
        Student s3 = new Student("Priya", "CS02", "CS");
        Student s4 = new Student("Dev", "EN01", "ENTC");
        Student s5 = new Student("Neha", "IT02", "IT");

        // Display details
        s1.displayStudent();
        s2.displayStudent();
        s3.displayStudent();
        s4.displayStudent();
        s5.displayStudent();

        // Total admitted students
        System.out.println("Total Admitted = " + Student.getTotalAdmitted());

        /*
        (b) MAX_CAPACITY reassign attempt:

        s1.MAX_CAPACITY = 100;

        ❌ ERROR:
        cannot assign a value to final variable MAX_CAPACITY

        Explanation:
        final variables are constants and cannot be modified after initialization.
        */

        // (c) Default constructor using this()
        Student s6 = new Student();
        s6.displayStudent();
    }
}