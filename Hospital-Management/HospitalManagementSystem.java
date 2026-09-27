import java.util.ArrayList;
import java.util.Scanner;

class Patient {

    String name;
    int age;
    String disease;
    String doctor;
    boolean admitted;

    Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = "Not Assigned";
        this.admitted = true;
    }

        void assignDoctor(String doctorName) {
        this.doctor = doctorName;
        System.out.println("Doctor Assigned: " + doctorName);
    }

        void display() {
        System.out.println("Name: " + name +
                " | Age: " + age +
                " | Disease: " + disease +
                " | Doctor: " + doctor +
                " | Admitted: " + admitted);
    }
}

public class HospitalSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addPatient() {

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Disease: ");
        String disease = sc.next();

        patients.add(new Patient(name, age, disease));

        System.out.println("Patient Added Successfully 🏥");
    }

        static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found!");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }

        static Patient findPatient(String name) {

        for (Patient p : patients) {
            if (p.name.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

        static void assignDoctor() {

        System.out.print("Enter Patient Name: ");
        String name = sc.next();

        Patient p = findPatient(name);

        if (p != null) {
            System.out.print("Enter Doctor Name: ");
            String doc = sc.next();
            p.assignDoctor(doc);
        } else {
            System.out.println("Patient not found!");
        }
    }

    static void updateDisease() {

        System.out.print("Enter Patient Name: ");
        String name = sc.next();

        Patient p = findPatient(name);

        if (p != null) {
            System.out.print("Enter New Disease: ");
            String disease = sc.next();
            p.disease = disease;
            System.out.println("Disease Updated");
        } else {
            System.out.println("Patient not found!");
        }
    }

        static void dischargePatient() {

        System.out.print("Enter Patient Name: ");
        String name = sc.next();

        Patient p = findPatient(name);

        if (p != null) {
            patients.remove(p);
            System.out.println("Patient Discharged 🏥");
        } else {
            System.out.println("Patient not found!");
        }
    }

        public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Assign Doctor");
            System.out.println("4. Update Disease");
            System.out.println("5. Discharge Patient");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    assignDoctor();
                    break;

                case 4:
                    updateDisease();
                    break;

                case 5:
                    dischargePatient();
                    break;

                case 6:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}
