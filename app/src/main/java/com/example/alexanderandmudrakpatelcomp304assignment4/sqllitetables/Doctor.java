package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Doctor {
    private int _doctorID;
    private String _doctorFirstName;
    private String _doctorLastName;
    private String _doctorDepartment;
    private String _doctorPassword;

    //Constructor
    public Doctor(String _firstName, String _lastName) {
        this._doctorFirstName = _firstName;
        this._doctorLastName = _lastName;
    }
    //Getters
    public int get_doctorID() {
        return _doctorID;
    }

    public String get_doctorFirstName() {
        return _doctorFirstName;
    }

    public String get_doctorLastName() {
        return _doctorLastName;
    }

    public String get_doctorDepartment() {
        return _doctorDepartment;
    }

    public String get_doctorPassword() {
        return _doctorPassword;
    }
    //Setters
    public void set_doctorID(int _doctorID) {
        this._doctorID = _doctorID;
    }

    public void set_doctorFirstName(String _doctorFirstName) {
        this._doctorFirstName = _doctorFirstName;
    }

    public void set_doctorLastName(String _doctorLastName) {
        this._doctorLastName = _doctorLastName;
    }

    public void set_doctorDepartment(String _doctorDepartment) {
        this._doctorDepartment = _doctorDepartment;
    }

    public void set_doctorPassword(String _doctorPassword) {
        this._doctorPassword = _doctorPassword;
    }
}
