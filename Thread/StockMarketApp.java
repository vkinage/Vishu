// A stock market application updates prices of multiple stocks simultaneously. 
// Implement using Threads:    • Class 'StockUpdater' implements Runnable: 
// stockName, price (volatile); run() simulates price update     in a loop (5 iterations) 
// with random fluctuation ±5%; sleeps 500ms between updates   • Class 
// 'StockMonitor' extends Thread: monitors a specific stock, prints alert if price 
// crosses threshold   • Main thread creates 3 StockUpdater threads (RELIANCE, 
// INFY, TCS) and 1 StockMonitor  Tasks:   (a) Start all threads simultaneously; 
// each updater prints updated price every 500ms   (b) StockMonitor prints 
// "ALERT: <stock> crossed ₹<threshold>!" when condition met   (c) Use join() to 
// wait for all updater threads before printing final prices   (d) Demonstrate 
// Runnable interface vs Thread class — use both in this program   (e) Print thread 
// states using Thread.getState() 

// StockUpdater Class (Runnable)
class StockUpdater implements Runnable {

    String stockName;
    volatile double price;

    // Constructor
    StockUpdater(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    // Method to get current price
    double getPrice() {
        return price;
    }

    // Run method
    public void run() {

        for (int i = 1; i <= 5; i++) {

            // Random fluctuation between -5% and +5%
            double fluctuation = (Math.random() * 10) - 5;

            // Update price
            price = price + (price * fluctuation / 100);

            // Print updated price
            System.out.println(
                Thread.currentThread().getName()
                + " -> "
                + stockName
                + " Updated Price: ₹"
                + price
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// StockMonitor Class (Thread)
class StockMonitor extends Thread {

    StockUpdater stock;
    double threshold;

    // Constructor
    StockMonitor(StockUpdater stock, double threshold) {
        this.stock = stock;
        this.threshold = threshold;
    }

    // Run method
    public void run() {

        // Monitor for 5 checks
        for (int i = 1; i <= 5; i++) {

            if (stock.getPrice() > threshold) {

                System.out.println(
                    "ALERT: "
                    + stock.stockName
                    + " crossed ₹"
                    + threshold
                    + "! Current Price: ₹"
                    + stock.getPrice()
                );
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}


// Main Class
public class StockMarketApp {

    public static void main(String[] args) {

        // Create StockUpdater objects
        StockUpdater reliance = new StockUpdater("RELIANCE", 2500);
        StockUpdater infy = new StockUpdater("INFY", 1800);
        StockUpdater tcs = new StockUpdater("TCS", 4000);

        // Create threads using Runnable
        Thread t1 = new Thread(reliance);
        Thread t2 = new Thread(infy);
        Thread t3 = new Thread(tcs);

        // Set thread names
        t1.setName("Thread-RELIANCE");
        t2.setName("Thread-INFY");
        t3.setName("Thread-TCS");

        // Create monitor thread
        StockMonitor monitor = new StockMonitor(reliance, 2600);

        // Print thread states before start
        System.out.println("Before Start:");
        System.out.println("t1 State = " + t1.getState());
        System.out.println("t2 State = " + t2.getState());
        System.out.println("t3 State = " + t3.getState());
        System.out.println("Monitor State = " + monitor.getState());

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        monitor.start();

        // Print thread states after start
        System.out.println("\nAfter Start:");
        System.out.println("t1 State = " + t1.getState());
        System.out.println("t2 State = " + t2.getState());
        System.out.println("t3 State = " + t3.getState());
        System.out.println("Monitor State = " + monitor.getState());

        // Wait for updater threads
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Final prices
        System.out.println("\nFINAL STOCK PRICES");
        System.out.println("RELIANCE : ₹" + reliance.getPrice());
        System.out.println("INFY : ₹" + infy.getPrice());
        System.out.println("TCS : ₹" + tcs.getPrice());

        // Final thread states
        System.out.println("\nAfter Completion:");
        System.out.println("t1 State = " + t1.getState());
        System.out.println("t2 State = " + t2.getState());
        System.out.println("t3 State = " + t3.getState());
        System.out.println("Monitor State = " + monitor.getState());
    }
}