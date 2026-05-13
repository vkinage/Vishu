// A smart home app controls different devices. Implement Polymorphism in Java:    
// Compile-time (Overloading):   • Class 'DeviceController': overloaded method 
// setTimer(int minutes),     setTimer(int hours, int minutes), setTimer(String 
// schedule)    Runtime (Overriding):   • Base class 'SmartDevice': method 
// activate()   • Class 'SmartLight' extends SmartDevice: override activate() — 
// "Turning lights ON at X% brightness"   • Class 'SmartAC' extends SmartDevice: 
// override activate() — "Setting AC to Y°C"   • Class 'SmartFan' extends 
// SmartDevice: override activate() — "Fan speed set to Z"  Tasks:   (a) 
// Demonstrate all 3 overloaded setTimer() calls   (b) Create SmartDevice array, 
// store SmartLight, SmartAC, SmartFan objects   (c) Loop through array, call 
// activate() — show polymorphic behaviour   (d) Use instanceof to identify device 
// type at runtime 

// Compile-time Polymorphism (Overloading)
class DeviceController {

    void setTimer(int minutes) {
        System.out.println("Timer set for " + minutes + " minutes");
    }

    void setTimer(int hours, int minutes) {
        System.out.println("Timer set for " + hours + " hour(s) " + minutes + " minute(s)");
    }

    void setTimer(String schedule) {
        System.out.println("Timer scheduled for: " + schedule);
    }
}

// Runtime Polymorphism (Overriding)
class SmartDevice {
    void activate() {
        System.out.println("Activating device...");
    }
}

// Smart Light
class SmartLight extends SmartDevice {
    int brightness;

    SmartLight(int brightness) {
        this.brightness = brightness;
    }

    @Override
    void activate() {
        System.out.println("Turning lights ON at " + brightness + "% brightness");
    }
}

// Smart AC
class SmartAC extends SmartDevice {
    int temperature;

    SmartAC(int temperature) {
        this.temperature = temperature;
    }

    @Override
    void activate() {
        System.out.println("Setting AC to " + temperature + "°C");
    }
}

// Smart Fan
class SmartFan extends SmartDevice {
    int speed;

    SmartFan(int speed) {
        this.speed = speed;
    }

    @Override
    void activate() {
        System.out.println("Fan speed set to " + speed);
    }
}

// Main Class
public class SmartHomeSystem {

    public static void main(String[] args) {

        // (a) Compile-time Polymorphism
        DeviceController dc = new DeviceController();

        dc.setTimer(30);
        dc.setTimer(1, 30);
        dc.setTimer("Morning 6AM");

        System.out.println("\n DEVICE ACTIVATION");

        // (b) SmartDevice array (Runtime Polymorphism)
        SmartDevice[] devices = new SmartDevice[3];

        devices[0] = new SmartLight(75);
        devices[1] = new SmartAC(22);
        devices[2] = new SmartFan(3);

        // (c) Polymorphic loop
        for (SmartDevice d : devices) {
            d.activate();

            // (d) instanceof check
            if (d instanceof SmartLight) {
                System.out.println("Device Type: SmartLight");
            } else if (d instanceof SmartAC) {
                System.out.println("Device Type: SmartAC");
            } else if (d instanceof SmartFan) {
                System.out.println("Device Type: SmartFan");
            }

            System.out.println();
        }
    }
}