package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

public class Test {
    private int testID;
    private int testPatientID;
    private int testNurseID;
    private int testBPL;
    private int testBPH;
    private int testTemperature;

    //Constructor

    public Test(int patientID, int nurseID) {
        this.testPatientID = patientID;
        this.testNurseID = nurseID;
    }
    //Getters
    public int getTestID() {
        return testID;
    }

    public int getTestPatientID() {
        return testPatientID;
    }

    public int getTestNurseID() {
        return testNurseID;
    }

    public int getTestBPL() {
        return testBPL;
    }

    public int getTestBPH() {
        return testBPH;
    }

    public int getTestTemperature() {
        return testTemperature;
    }

    //Setters
    public void setTestID(int testID) {
        this.testID = testID;
    }

    public void setTestPatientID(int testPatientID) {
        this.testPatientID = testPatientID;
    }

    public void setTestNurseID(int testNurseID) {
        this.testNurseID = testNurseID;
    }

    public void setTestBPL(int testBPL) {
        this.testBPL = testBPL;
    }

    public void setTestBPH(int testBPH) {
        this.testBPH = testBPH;
    }

    public void setTestTemperature(int testTemperature) {
        this.testTemperature = testTemperature;
    }
}
