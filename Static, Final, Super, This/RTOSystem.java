// A Regional Transport Office (RTO) manages vehicle registrations. Design a Java 
// program:   • Base class 'Vehicle': vehicleType (final), engineCC (int); constructor 
// uses 'super' from subclass   • Class 'RegisteredVehicle' extends Vehicle: regNo, 
// ownerName; static int totalRegistered   • Static method getTotalRegistered(); 
// instance method displayRegistration()   • final method getVehicleType() in 
// Vehicle — cannot be overridden  Tasks:   (a) Create 4 RegisteredVehicle 
// objects; verify static count increases   (b) Attempt to override getVehicleType() in 
// subclass — explain final method restriction (comment)   (c) Use 'this' to 
// differentiate instance variable from parameter in constructor   (d) Use 
// 'super(vehicleType, engineCC)' in RegisteredVehicle constructor 

class Vehicle {

    // final variable (cannot be changed)
    final String vehicleType;
    int engineCC;

    // Constructor
    Vehicle(String vehicleType, int engineCC) {
        this.vehicleType = vehicleType;
        this.engineCC = engineCC;
    }

    // final method (cannot be overridden)
    final void getVehicleType() {
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

// Subclass
class RegisteredVehicle extends Vehicle {

    String regNo;
    String ownerName;

    static int totalRegistered = 0;

    // Constructor using super + this
    RegisteredVehicle(String vehicleType, int engineCC, String regNo, String ownerName) {

        super(vehicleType, engineCC); // calling parent constructor

        this.regNo = regNo;           // 'this' used for clarity
        this.ownerName = ownerName;

        totalRegistered++; // increment static counter
    }

    static int getTotalRegistered() {
        return totalRegistered;
    }

    void displayRegistration() {

        getVehicleType(); // calling final method from parent

        System.out.println("Engine CC: " + engineCC);
        System.out.println("Registration No: " + regNo);
        System.out.println("Owner Name: " + ownerName);
        System.out.println();
    }

    /*
    (b) Attempt to override final method:

    @Override
    void getVehicleType() {
        System.out.println("Trying to override");
    }

    ERROR:
    Cannot override the final method from Vehicle

    Explanation:
    final methods cannot be overridden in subclasses because they are
    locked by the parent class to ensure consistent behavior.
    */
}

// Main Class
public class RTOSystem {
    public static void main(String[] args) {

        // Creating 4 vehicles
        RegisteredVehicle v1 = new RegisteredVehicle("Car", 1500, "MH12AB1234", "Suresh");
        RegisteredVehicle v2 = new RegisteredVehicle("Bike", 150, "MH12CD5678", "Pooja");
        RegisteredVehicle v3 = new RegisteredVehicle("Truck", 3000, "MH12TR9999", "Ravi");
        RegisteredVehicle v4 = new RegisteredVehicle("Van", 2000, "MH12VN7777", "Anita");

        // Display details
        v1.displayRegistration();
        v2.displayRegistration();
        v3.displayRegistration();
        v4.displayRegistration();

        // Total registered vehicles
        System.out.println("Total Registered = " +
                RegisteredVehicle.getTotalRegistered());
    }
}