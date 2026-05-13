// A private bank wants to model its savings account system in Java. Design a
// class 'BankAccount' with: • Member variables: accountNumber (int),
// holderName (String), balance (double) • Parameterized constructor to initialise
// all fields • Methods: deposit(double amt), withdraw(double amt),
// displayBalance() • Method checkMinBalance() — returns a message if balance
// falls below ₹1000 Tasks: (a) Create at least 3 BankAccount objects with
// different initial balances (b) Perform deposit and withdrawal operations on each
// (c) Call checkMinBalance() and display appropriate message (d) Show
// overloaded method: deposit(double, String) where String is a remark

class BankAccount {

    int accountNumber;
    String holderName;
    double balance;

    // Parameterized Constructor
    BankAccount(int accountNumber, String holderName, double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {

        balance = balance + amount;

        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Overloaded Deposit Method
    public void deposit(double amount, String remark) {

        balance = balance + amount;

        System.out.println("₹" + amount + " deposited.");
        System.out.println("Remark: " + remark);
    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (amount <= balance) {

            balance = balance - amount;

            System.out.println("₹" + amount + " withdrawn successfully.");
        }
        else {

            System.out.println("Insufficient balance.");
        }
    }

    // Display Balance Method
    public void displayBalance() {

        System.out.println("Current Balance: ₹" + balance);
    }

    // Check Minimum Balance
    public void checkMinBalance() {

        if (balance < 1000) {

            System.out.println("Warning: Balance below ₹1000");
        }
        else {

            System.out.println("Minimum balance maintained.");
        }
    }
}

public class BankAccountManagementSystem {

    public static void main(String[] args) {

        // Creating 2 objects (changed inputs as required)
        BankAccount b1 = new BankAccount(1001, "Amit", 5000);

        BankAccount b2 = new BankAccount(1002, "Priya", 800);



        // Operations on Account 1
        System.out.println("----- Account 1 -----");

        b1.deposit(2000);

        b1.displayBalance();

        b1.checkMinBalance();



        // Operations on Account 2
        System.out.println("\n----- Account 2 -----");

        b2.withdraw(700);

        b2.displayBalance();

        b2.checkMinBalance();
    }
}