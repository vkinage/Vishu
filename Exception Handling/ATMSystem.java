// An ATM system must handle errors gracefully. Implement Exception Handling in 
// Java:    Custom Exceptions:   • InsufficientFundsException (checked) — thrown 
// when withdrawal > balance   • InvalidAmountException (unchecked) — thrown 
// when withdrawal amount ≤ 0 or not multiple of 100   • 
// DailyLimitExceededException (checked) — thrown when total daily withdrawal > 
// ₹20,000    Class 'ATM':   • Method withdraw(double amount) throws 
// InsufficientFundsException, DailyLimitExceededException   • Validates amount 
// using InvalidAmountException (unchecked — no throws clause needed)   • finally 
// block: always prints "Transaction log saved."  Tasks:   (a) Perform 4 withdrawals: 
// valid, insufficient funds, invalid amount (–500), daily limit breach   (b) Catch each 
// exception separately and print a user-friendly message   (c) Show use of try
// with-multiple-catch and finally   (d) Re-throw InsufficientFundsException after 
// logging 

// Custom Exception (Checked)
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

// Custom Exception (Checked)
class DailyLimitExceededException extends Exception {
    DailyLimitExceededException(String msg) {
        super(msg);
    }
}

// Custom Exception (Unchecked)
class InvalidAmountException extends RuntimeException {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

// ATM Class
class ATM {

    double balance = 15000;
    double limit = 20000;
    double withdrawn = 0;

    void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException {

        try {
            // Invalid amount check
            if (amount <= 0 || amount % 100 != 0)
                throw new InvalidAmountException("Invalid amount");

            // Balance check
            if (amount > balance)
                throw new InsufficientFundsException("No enough balance");

            // Daily limit check
            if (withdrawn + amount > limit)
                throw new DailyLimitExceededException("Daily limit exceeded");

            // Success
            balance -= amount;
            withdrawn += amount;

            System.out.println("Withdraw success: " + amount);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            throw e; // rethrow

        } finally {
            System.out.println("Transaction log saved\n");
        }
    }
}

// Main Class
public class ATMSystem {
    public static void main(String[] args) {

        ATM atm = new ATM();

        double[] arr = {5000, 12000, -500, 8000};

        for (double amt : arr) {
            try {
                System.out.println("Trying: " + amt);
                atm.withdraw(amt);

            } catch (InvalidAmountException e) {
                System.out.println("Invalid Amount");

            } catch (DailyLimitExceededException e) {
                System.out.println("Limit Exceeded");

            } catch (InsufficientFundsException e) {
                System.out.println("Handled in main");
            }

            System.out.println();
        }
    }
}