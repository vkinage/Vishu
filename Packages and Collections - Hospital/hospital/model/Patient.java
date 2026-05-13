package hospital.model;

public class Patient {

    public String patientId, name, disease;
    public int age;

    public Patient(String patientId, String name, int age, String disease) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String toString() {
        return patientId + " " + name + " " + age + " " + disease;
    }
}