package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Nurse {
    private int _nurseID;
    private String _nurseFirstName;
    private String _nurseLastName;
    private String _nurseDepartment;
    private String _nursePassword;

    //Constructor
    public Nurse(String _firstName, String _lastName) {
        this._nurseFirstName = _firstName;
        this._nurseLastName = _lastName;
    }
    //Getters
    public int get_nurseID() {
        return _nurseID;
    }

    public String get_nurseFirstName() {
        return _nurseFirstName;
    }

    public String get_nurseLastName() {
        return _nurseLastName;
    }

    public String get_nurseDepartment() {
        return _nurseDepartment;
    }

    public String get_nursePassword() {
        return _nursePassword;
    }
    //Setters
    public void set_nurseID(int _nurseID) {
        this._nurseID = _nurseID;
    }

    public void set_nurseFirstName(String _nurseFirstName) {
        this._nurseFirstName = _nurseFirstName;
    }

    public void set_nurseLastName(String _nurseLastName) {
        this._nurseLastName = _nurseLastName;
    }

    public void set_nurseDepartment(String _nurseDepartment) {
        this._nurseDepartment = _nurseDepartment;
    }

    public void set_nursePassword(String _nursePassword) {
        this._nursePassword = _nursePassword;
    }
}
