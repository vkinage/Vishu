// A railway booking system must handle multiple passengers booking 
// simultaneously. Implement Multithreading:    • Class 'SeatReservation': shared 
// variable availableSeats = 10 (shared resource)   • Class 'BookingAgent' extends 
// Thread: each agent tries to book a specified number of seats   • Use 
// 'synchronized' method bookSeats(int count, String agentName) to prevent race 
// condition   • Show what happens WITHOUT synchronization (race condition) — 
// comment that version  Tasks:   (a) Create 4 BookingAgent threads: Agent1 
// books 3, Agent2 books 4, Agent3 books 2, Agent4 books 3   (b) Run all threads; 
// verify total booked never exceeds 10   (c) Print booking confirmation or "Seats 
// not available" for each agent   (d) Use Thread.sleep() to simulate network delay 
// between bookings   (e) Display thread name and seats booked using 
// Thread.currentThread().getName() 

// Shared Resource Class
class SeatReservation {

    int availableSeats = 10;

    // Synchronized method
    synchronized void bookSeats(int count, String agentName) {

        System.out.println(agentName + " trying to book " + count + " seats");

        try {
            Thread.sleep(1000); // simulate network delay
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        if (count <= availableSeats) {

            System.out.println(Thread.currentThread().getName()
                    + " booked " + count + " seats");

            availableSeats -= count;

            System.out.println("Seats left: " + availableSeats);

        } else {

            System.out.println(Thread.currentThread().getName()
                    + " -> Seats not available");
        }

        System.out.println();
    }

    /*
    WITHOUT synchronized:

    void bookSeats(int count, String agentName)

    Problem:
    Multiple threads access availableSeats simultaneously,
    causing race condition and overbooking.
    */
}

// Thread Class
class BookingAgent extends Thread {

    SeatReservation sr;
    int seats;

    BookingAgent(SeatReservation sr, int seats, String name) {

        this.sr = sr;
        this.seats = seats;

        setName(name);
    }

    public void run() {
        sr.bookSeats(seats, getName());
    }
}

// Main Class
public class RailwayBookingSystem {

    public static void main(String[] args) {

        SeatReservation sr = new SeatReservation();

        // Creating threads
        BookingAgent a1 = new BookingAgent(sr, 3, "Agent1");
        BookingAgent a2 = new BookingAgent(sr, 4, "Agent2");
        BookingAgent a3 = new BookingAgent(sr, 2, "Agent3");
        BookingAgent a4 = new BookingAgent(sr, 3, "Agent4");

        // Starting threads
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}