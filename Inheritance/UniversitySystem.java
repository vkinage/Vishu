// A university maintains different categories of staff. Model the hierarchy using 
// Java Inheritance:   • Base class 'Person': name, age, contactNo; method 
// displayInfo()   • Class 'Employee' extends Person: empId, department; method 
// displayEmployeeDetails()   • Class 'Faculty' extends Employee: designation, 
// subjectsTaught[]; method displayFacultyDetails()   • Class 'HodFaculty' extends 
// Faculty: additionalAllowance; method displayHodDetails()  Tasks:   (a) 
// Demonstrate Single (Employee → Person), Multilevel (HodFaculty → Faculty → 
// Employee → Person),       and Hierarchical inheritance (Faculty & AdminStaff 
// both extending Employee)   (b) Create objects for each type and call respective 
// display methods   (c) Use 'super' to call parent constructor from child class

// Base Class
class Person {
    String name;
    int age;
    String contactNo;

    // Constructor
    Person(String name, int age, String contactNo) {
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Contact No: " + contactNo);
    }
}

// Employee extends Person (Single Inheritance)
class Employee extends Person {
    String empId;
    String department;

    Employee(String name, int age, String contactNo, String empId, String department) {
        super(name, age, contactNo); // calling parent constructor
        this.empId = empId;
        this.department = department;
    }

    void displayEmployeeDetails() {
        displayInfo();
        System.out.println("Employee ID: " + empId);
        System.out.println("Department: " + department);
    }
}

// Faculty extends Employee (Multilevel Inheritance)
class Faculty extends Employee {
    String designation;
    String[] subjectsTaught;

    Faculty(String name, int age, String contactNo,
            String empId, String department,
            String designation, String[] subjectsTaught) {

        super(name, age, contactNo, empId, department);
        this.designation = designation;
        this.subjectsTaught = subjectsTaught;
    }

    void displayFacultyDetails() {
        displayEmployeeDetails();
        System.out.println("Designation: " + designation);
        System.out.print("Subjects Taught: ");
        for (String sub : subjectsTaught) {
            System.out.print(sub + " ");
        }
        System.out.println();
    }
}

// HoD Faculty (Multilevel continuation)
class HodFaculty extends Faculty {
    double additionalAllowance;

    HodFaculty(String name, int age, String contactNo,
               String empId, String department,
               String designation, String[] subjectsTaught,
               double additionalAllowance) {

        super(name, age, contactNo, empId, department, designation, subjectsTaught);
        this.additionalAllowance = additionalAllowance;
    }

    void displayHodDetails() {
        displayFacultyDetails();
        System.out.println("HoD Additional Allowance: " + additionalAllowance);
    }
}

// Another class for Hierarchical Inheritance
class AdminStaff extends Employee {
    String role;

    AdminStaff(String name, int age, String contactNo,
               String empId, String department, String role) {

        super(name, age, contactNo, empId, department);
        this.role = role;
    }

    void displayAdminDetails() {
        displayEmployeeDetails();
        System.out.println("Role: " + role);
    }
}

// Main Class
public class UniversitySystem {
    public static void main(String[] args) {

        // Faculty Object (Multilevel)
        String[] subjects = {"Java", "OS"};
        Faculty f1 = new Faculty("Dr. Mehta", 45, "9876543210",
                "F001", "IT", "Professor", subjects);

        System.out.println("----- Faculty Details -----");
        f1.displayFacultyDetails();

        // HoD Faculty Object (Multilevel deep)
        HodFaculty h1 = new HodFaculty("Dr. Mehta", 45, "9876543210",
                "F001", "IT", "Professor", subjects, 5000);

        System.out.println("\n----- HoD Faculty Details -----");
        h1.displayHodDetails();

        // Admin Staff Object (Hierarchical)
        AdminStaff a1 = new AdminStaff("Ravi Kumar", 38, "9123456780",
                "A101", "Administration", "Office Manager");

        System.out.println("\n----- Admin Staff Details -----");
        a1.displayAdminDetails();
    }
}