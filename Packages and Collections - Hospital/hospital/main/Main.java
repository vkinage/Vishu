package hospital.main;

import hospital.model.Patient;
import hospital.service.PatientService;

public class Main {

    public static void main(String[] args) {

        PatientService ps = new PatientService();

        ps.addPatient(new Patient("P001", "Asha", 32, "Fever"));

        ps.addPatient(new Patient("P002", "Raj", 45, "Diabetes"));

        ps.addPatient(new Patient("P003", "Priya", 28, "Fever"));

        ps.addPatient(new Patient("P004", "Dev", 60, "BP"));

        ps.addPatient(new Patient("P005", "Neha", 35, "Asthma"));

        // Display All
        System.out.println("Patients:");
        ps.displayPatients();

        // Search by ID
        System.out.println("\nSearch:");
        ps.searchPatient("P002");

        // Queue
        System.out.println("\nQueue:");
        ps.nextPatient();

        // Diseases
        System.out.println("\nDiseases:");
        ps.displayDiseases();
    }
}