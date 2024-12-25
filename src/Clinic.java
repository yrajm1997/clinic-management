import java.util.*;

class Clinic {

    private Queue<Patient> patientQueue;
    private List<Patient> admittedPatients;
    private int dayCount;

    // Constructor to initialize the clinic with a queue and list of admitted patients
    public Clinic() {
        this.patientQueue = new LinkedList<>();
        this.admittedPatients = new ArrayList<>();
        this.dayCount = 1; // Start with Day 1
    }

    // Admit a patient to the clinic
    public void admitPatient(Patient patient) {
        patientQueue.offer(patient);
        System.out.println("Patient " + patient.getName() + " admitted.");
    }

    // Discharge a patient from the clinic
    public void dischargePatient(Patient patient) {
        admittedPatients.remove(patient);
        System.out.println("Patient " + patient.getName() + " discharged.");
    }

    // Schedule appointments (maximum 3 patients per day)
    public void getSchedule() {
        System.out.println("Scheduling appointments for Day " + dayCount + "...");
        int patientsScheduled = 0;
        while (!patientQueue.isEmpty() && patientsScheduled < 3) {
            Patient patient = patientQueue.poll();
            patient.setAppointmentDate("Day " + dayCount);
            admittedPatients.add(patient);
            patientsScheduled++;
            System.out.println("Scheduled " + patient.getName() + " on " + patient.getAppointmentDate());
        }

        // If there are still patients left, they will be scheduled for the next day
        if (patientsScheduled > 0) {
            dayCount++;
        }
    }

    // Provide treatment or prescription for a patient after their appointment
    public void providedTreatment(Patient patient, String treatment) {
        if (admittedPatients.contains(patient)) {
            patient.setTreatment(treatment);
            System.out.println("Treatment provided to " + patient.getName() + ": " + treatment);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    // Get the details of a patient
    public void getPatientDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Patient Details: " + patient);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    // Get the appointment details of a patient
    public void getAppointmentDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Appointment Details: " + patient.getName() + " is scheduled on " + patient.getAppointmentDate());
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }
}