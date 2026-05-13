// An insurance company offers different policies. Model using Abstract Class, 
// Interface and Lambda:    • Abstract class 'InsurancePolicy': policyNo, 
// holderName, sumInsured;     abstract method calculatePremium(); concrete 
// method displayPolicy()   • Class 'HealthInsurance' extends InsurancePolicy: 
// implements calculatePremium() as 2% of sumInsured   • Class 
// 'VehicleInsurance' extends InsurancePolicy: implements calculatePremium() as 
// 3% of sumInsured   • Interface 'Taxable': method applyGST(double premium) — 
// returns premium + 18% GST   • Both classes implement Taxable    Lambda:   • 
// Use lambda to sort a list of InsurancePolicy objects by sumInsured (ascending)   
// • Use lambda with Predicate<InsurancePolicy> to filter policies where premium > 
// ₹5000  Tasks:   (a)–(d) Create 3 health and 2 vehicle policies, display all, sort by 
// sumInsured, filter high-premium 

import java.util.*;
import java.util.function.Predicate;

interface Taxable {

    double applyGST(double premium);
}

// Abstract Class
abstract class InsurancePolicy {

    String policyNo, holderName;
    double sumInsured;

    InsurancePolicy(String policyNo, String holderName, double sumInsured) {

        this.policyNo = policyNo;
        this.holderName = holderName;
        this.sumInsured = sumInsured;
    }

    abstract double calculatePremium();

    void displayPolicy() {

        System.out.println(this.policyNo + " " + this.holderName + " " + this.sumInsured);
    }
}

// Health Insurance
class HealthInsurance extends InsurancePolicy implements Taxable {

    HealthInsurance(String policyNo, String holderName, double sumInsured) {

        super(policyNo, holderName, sumInsured);
    }

    double calculatePremium() {

        return this.sumInsured * 0.02;
    }

    public double applyGST(double premium) {

        return premium + premium * 0.18;
    }
}

// Vehicle Insurance
class VehicleInsurance extends InsurancePolicy
        implements Taxable {

    VehicleInsurance(String policyNo, String holderName, double sumInsured) {

        super(policyNo, holderName, sumInsured);
    }

    double calculatePremium() {

        return this.sumInsured * 0.03;
    }

    public double applyGST(double premium) {

        return premium + premium * 0.18;
    }
}

public class InsurancePremiumCalculator {

    public static void main(String[] args) {

        ArrayList<InsurancePolicy> list =
                new ArrayList<>();

        list.add(new HealthInsurance(
                "H001", "Asha", 250000));

        list.add(new HealthInsurance(
                "H002", "Raj", 500000));

        list.add(new VehicleInsurance(
                "V001", "Priya", 150000));

        list.add(new VehicleInsurance(
                "V002", "Amit", 400000));

        // Display
        System.out.println("Policies:\n");

        for (InsurancePolicy p : list) {

            p.displayPolicy();

            double premium = p.calculatePremium();

            double total = ((Taxable) p).applyGST(premium);

            System.out.println("Premium with GST = " + total);
        }

        // Sort using Lambda
        list.sort((a, b) -> Double.compare(a.sumInsured, b.sumInsured));

        System.out.println("\nSorted Policies:\n");

        for (InsurancePolicy p : list) {

            p.displayPolicy();
        }

        // Filter Premium > 5000
        Predicate<InsurancePolicy> high = p -> p.calculatePremium() > 5000;

        System.out.println("\nHigh Premium Policies:\n");

        for (InsurancePolicy p : list) {

            if (high.test(p)) {

                p.displayPolicy();
            }
        }
    }
}