package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Test {
    private int _testID;
    private int _testPatientID;
    private int _testNurseID;
    private boolean _testBPL;
    private boolean _testBPH;
    private int _testTemperature;

    //Constructor

    public Test(int _patientID, int _nurseID) {
        this._testPatientID = _patientID;
        this._testNurseID = _nurseID;
    }
    //Getters
    public int get_testID() {
        return _testID;
    }

    public int get_testPatientID() {
        return _testPatientID;
    }

    public int get_testNurseID() {
        return _testNurseID;
    }

    public boolean is_testBPL() {
        return _testBPL;
    }

    public boolean is_testBPH() {
        return _testBPH;
    }

    public int get_testTemperature() {
        return _testTemperature;
    }

    //Setters
    public void set_testID(int _testID) {
        this._testID = _testID;
    }

    public void set_testPatientID(int _testPatientID) {
        this._testPatientID = _testPatientID;
    }

    public void set_testNurseID(int _testNurseID) {
        this._testNurseID = _testNurseID;
    }

    public void set_testBPL(boolean _testBPL) {
        this._testBPL = _testBPL;
    }

    public void set_testBPH(boolean _testBPH) {
        this._testBPH = _testBPH;
    }

    public void set_testTemperature(int _testTemperature) {
        this._testTemperature = _testTemperature;
    }
}
