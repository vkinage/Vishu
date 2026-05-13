// An IT company needs a payroll system. Design a class 'Employee' with: •
// Member variables: empId (int), name (String), basicSalary (double), department
// (String) • Default and parameterized constructors • Methods: calculateHRA()
// — 20% of basic, calculateDA() — 11% of basic, calculateNetSalary() —
// basic + HRA + DA, displayPayslip() • Overloaded method
// displayPayslip(boolean showDeductions) — if true, show tax (10% of net)
// Tasks: (a) Create 3 Employee objects using parameterised constructor (b)
// Display payslip for each employee (c) Display payslip with deductions for
// employees earning > ₹50,000 net (d) Demonstrate use of 'this' keyword inside
// constructor

class Employee {

    int empId;
    String name;
    double basicSalary;
    String department;

    // Default Constructor
    Employee() {
        this.empId = 0;
        this.name = "Not Assigned";
        this.basicSalary = 0;
        this.department = "Not Assigned";
    }

    // Parameterized Constructor (uses 'this' keyword)
    Employee(int empId, String name, double basicSalary, String department) {

        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.department = department;
    }

    // HRA = 20%
    public double calculateHRA() {
        return 0.20 * basicSalary;
    }

    // DA = 11%
    public double calculateDA() {
        return 0.11 * basicSalary;
    }

    // Net Salary
    public double calculateNetSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    // Basic Payslip
    public void displayPayslip() {

        double hra = calculateHRA();
        double da = calculateDA();
        double net = calculateNetSalary();

        System.out.println("\n----- Payslip -----");
        System.out.println("Emp ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Basic Salary: ₹" + basicSalary);
        System.out.println("HRA (20%): ₹" + hra);
        System.out.println("DA (11%): ₹" + da);
        System.out.println("Net Salary: ₹" + net);
    }

    // Overloaded Payslip with deductions
    public void displayPayslip(boolean showDeductions) {

        displayPayslip(); // reuse base payslip

        double net = calculateNetSalary();

        if (showDeductions) {

            double tax = 0.10 * net;

            System.out.println("Tax Deduction (10%): ₹" + tax);
            System.out.println("Final Salary after Tax: ₹" + (net - tax));
        }
    }
}

public class EmployeePayrollCalculator  {

    public static void main(String[] args) {

        // Creating 3 employees using parameterized constructor
        Employee e1 = new Employee(201, "Rohit", 40000, "IT");

        Employee e2 = new Employee(202, "Sneha", 60000, "HR");

        Employee e3 = new Employee(203, "Karan", 30000, "Finance");

        // (b) Display payslip for each employee
        e1.displayPayslip();

        e2.displayPayslip();

        e3.displayPayslip();

        // (c) Show deductions only for employees earning > 50000
        System.out.println("\n----- Payslip with Deductions -----");

        if (e1.calculateNetSalary() > 50000)
            e1.displayPayslip(true);

        if (e2.calculateNetSalary() > 50000)
            e2.displayPayslip(true);

        if (e3.calculateNetSalary() > 50000)
            e3.displayPayslip(true);
    }
}