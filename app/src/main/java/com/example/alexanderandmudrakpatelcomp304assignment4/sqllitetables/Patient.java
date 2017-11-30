package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Patient {
    private int _patientID;
    private String _patientFirstName;
    private String _patientLastName;
    private String _patientDepartment;
    private int _patientDoctorID;
    private String _patientRoom;

    //Constructor
    public Patient(String _firstName, String _lastName) {
        this._patientFirstName = _firstName;
        this._patientLastName = _lastName;
    }
    //Getters

    public int get_patientID() {
        return _patientID;
    }

    public String get_patientFirstName() {
        return _patientFirstName;
    }

    public String get_patientLastName() {
        return _patientLastName;
    }

    public String get_patientDepartment() {
        return _patientDepartment;
    }

    public int get_patientDoctorID() {
        return _patientDoctorID;
    }

    public String get_patientRoom() {
        return _patientRoom;
    }
    //Setters

    public void set_patientID(int _patientID) {
        this._patientID = _patientID;
    }

    public void set_patientFirstName(String _patientFirstName) {
        this._patientFirstName = _patientFirstName;
    }

    public void set_patientLastName(String _patientLastName) {
        this._patientLastName = _patientLastName;
    }

    public void set_patientDepartment(String _patientDepartment) {
        this._patientDepartment = _patientDepartment;
    }

    public void set_patientDoctorID(int _patientDoctorID) {
        this._patientDoctorID = _patientDoctorID;
    }

    public void set_patientRoom(String _patientRoom) {
        this._patientRoom = _patientRoom;
    }
}
