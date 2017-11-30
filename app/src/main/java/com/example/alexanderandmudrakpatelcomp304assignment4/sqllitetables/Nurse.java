package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Nurse {
    private int nurseID;
    private String nurseFirstName;
    private String nurseLastName;
    private String nurseDepartment;
    private String nursePassword;

    //Constructor
    public Nurse(String firstName, String lastName) {
        this.nurseFirstName = firstName;
        this.nurseLastName = lastName;
    }
    //Getters
    public int getNurseID() {
        return nurseID;
    }

    public String getNurseFirstName() {
        return nurseFirstName;
    }

    public String getNurseLastName() {
        return nurseLastName;
    }

    public String getNurseDepartment() {
        return nurseDepartment;
    }

    public String getNursePassword() {
        return nursePassword;
    }
    //Setters
    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public void setNurseFirstName(String nurseFirstName) {
        this.nurseFirstName = nurseFirstName;
    }

    public void setNurseLastName(String nurseLastName) {
        this.nurseLastName = nurseLastName;
    }

    public void setNurseDepartment(String nurseDepartment) {
        this.nurseDepartment = nurseDepartment;
    }

    public void setNursePassword(String nursePassword) {
        this.nursePassword = nursePassword;
    }
}
