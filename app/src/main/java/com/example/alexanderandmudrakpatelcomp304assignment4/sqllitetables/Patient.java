package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Patient {
    private int patientID;
    private String patientFirstName;
    private String patientLastName;
    private String patientDepartment;
    private int patientDoctorID;
    private String patientRoom;

    //Constructor
    public Patient(String firstName, String lastName) {
        this.patientFirstName = firstName;
        this.patientLastName = lastName;
    }
    //Getters

    public int getPatientID() {
        return patientID;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientDepartment() {
        return patientDepartment;
    }

    public int getPatientDoctorID() {
        return patientDoctorID;
    }

    public String getPatientRoom() {
        return patientRoom;
    }
    //Setters

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setPatientDepartment(String patientDepartment) {
        this.patientDepartment = patientDepartment;
    }

    public void setPatientDoctorID(int patientDoctorID) {
        this.patientDoctorID = patientDoctorID;
    }

    public void setPatientRoom(String patientRoom) {
        this.patientRoom = patientRoom;
    }
}
