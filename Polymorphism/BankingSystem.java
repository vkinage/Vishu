// A banking application needs to process multiple types of transactions. Implement 
// Polymorphism:    Compile-time (Method Overloading):   • Class 'Transaction': 
// overloaded method processPayment(int), processPayment(double),     
// processPayment(double, String) where String is remarks, 
// processPayment(String upiId, double amt)    Runtime (Method Overriding):   • 
// Base class 'Account': method calculateInterest()   • Class 'SavingsAccount' 
// extends Account: override to compute 4% p.a. interest   • Class 'FixedDeposit' 
// extends Account: override to compute 7% p.a. interest  Tasks:   (a) Demonstrate 
// all 4 overloaded processPayment() calls with different arguments   (b) Create 
// base class reference pointing to SavingsAccount and FixedDeposit objects   (c) 
// Call calculateInterest() via base class reference — show dynamic dispatch   (d) 
// Print which account type is being used at runtime 

// Compile-time Polymorphism (Overloading)
class Transaction {

    void processPayment(int amount) {
        System.out.println("Processing payment (int): " + amount);
    }

    void processPayment(double amount) {
        System.out.println("Processing payment (double): " + amount);
    }

    void processPayment(double amount, String remarks) {
        System.out.println("Processing payment: " + amount + " | Remarks: " + remarks);
    }

    void processPayment(String upiId, double amount) {
        System.out.println("Processing UPI payment: " + amount + " from " + upiId);
    }
}

// Runtime Polymorphism (Overriding)
class Account {

    double balance;

    Account(double balance) {
        this.balance = balance;
    }

    void calculateInterest() {
        System.out.println("Base Account Interest calculation");
    }
}

// Savings Account
class SavingsAccount extends Account {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest = " + interest);
    }
}

// Fixed Deposit Account
class FixedDeposit extends Account {

    FixedDeposit(double balance) {
        super(balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * 0.07;
        System.out.println("Fixed Deposit Interest = " + interest);
    }
}

// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        // =========================
        // (a) Method Overloading
        // =========================
        Transaction t = new Transaction();

        t.processPayment(5000);
        t.processPayment(2500.50);
        t.processPayment(1000.0, "EMI");
        t.processPayment("upi@bank", 3000);

        System.out.println("\nINTEREST CALCULATION");

        // (b) Runtime Polymorphism
        Account acc1 = new SavingsAccount(50000);
        Account acc2 = new FixedDeposit(100000);

        // (c) Dynamic Method Dispatch
        acc1.calculateInterest();
        acc2.calculateInterest();

        // (d) Runtime Type Identification
        System.out.println("\nAccount Type 1: " + acc1.getClass().getSimpleName());
        System.out.println("Account Type 2: " + acc2.getClass().getSimpleName());
    }
}