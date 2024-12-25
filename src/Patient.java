//package clinic;

import java.util.HashSet;

class Patient {
    private String name;
    private int age;
    private String gender;
    private String symptoms;
    private String treatment;
    private String appointmentDate;

    // Constructor
    public Patient(String name, int age, String gender, String symptoms) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.symptoms = symptoms;
        this.treatment = null;
        this.appointmentDate = null;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    
    // Override equals() to compare Patient objects based on name, age, and gender
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Patient patient = (Patient) obj;
        return age == patient.age && name.equals(patient.name) && gender.equals(patient.gender);
    }

    // Override hashCode() to generate hash code based on name and age
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age + gender.hashCode();
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', age=" + age + ", gender=" + gender + "}";
    }
}