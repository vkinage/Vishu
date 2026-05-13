package hospital.service;

import hospital.model.Patient;
import java.util.*;

public class PatientService {

    ArrayList<Patient> list = new ArrayList<>();

    HashMap<String, Patient> map = new HashMap<>();

    LinkedList<Patient> queue = new LinkedList<>();

    TreeSet<String> diseases = new TreeSet<>();

    public void addPatient(Patient p) {

        list.add(p);
        map.put(p.patientId, p);
        queue.add(p);
        diseases.add(p.disease);
    }

    public void displayPatients() {

        for (Patient p : list) {
            System.out.println(p);
        }
    }

    public void searchPatient(String id) {
        System.out.println(map.get(id));
    }

    public void nextPatient() {
        System.out.println("Next Patient: " + queue.poll());
    }

    public void displayDiseases() {
        System.out.println(diseases);
    }
}