package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Doctor {
    private int doctorID;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorDepartment;
    private String doctorPassword;

    //Constructor
    public Doctor(String firstName, String lastName) {
        this.doctorFirstName = firstName;
        this.doctorLastName = lastName;
    }
    //Getters
    public int getDoctorID() {
        return doctorID;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }
    //Setters
    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }
}
