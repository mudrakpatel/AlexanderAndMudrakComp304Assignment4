package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HospitalDatabase.db";
    //Variables for Doctor table
    private static final String TABLE_DOCTOR = "Doctor";
    private static final String DOCTOR_ID = "_doctorID";
    private static final String DOCTOR_FIRSTNAME = "_doctorFirstName";
    private static final String DOCTOR_LASTNAME = "_doctorLastName";
    private static final String DOCTOR_DEPARTMENT = "_doctorDepartment";
    private static final String DOCTOR_PASSWORD = "_doctorPassword";
    //Variables for Nurse table
    private static final String TABLE_NURSE = "Nurse";
    private static final String NURSE_ID = "_nurseID";
    private static final String NURSE_FIRSTNAME = "_nurseFirstName";
    private static final String NURSE_LASTNAME = "_nurseLastName";
    private static final String NURSE_DEPARTMENT = "_nurseDepartment";
    private static final String NURSE_PASSWORD = "_nursePassword";
    //Variables for Patient table
    private static final String TABLE_PATIENT = "Patient";
    private static final String PATIENT_ID = "_patientID";
    private static final String PATIENT_FIRSTNAME = "_patientFirstName";
    private static final String PATIENT_LASTNAME = "_patientLastName";
    private static final String PATIENT_DEPARTMENT = "_patientDepartment";
    private static final String PATIENT_DOCTOR_ID = "_patientDoctorID";
    private static final String PATIENT_ROOM = "_patientRoom";
    //Variables for Test table
    private static final String TABLE_TEST = "Test";
    private static final String TEST_ID = "_testID";
    private static final String TEST_PATIENT_ID = "_testPatientID";
    private static final String TEST_NURSE_ID = "_testNurseID";
    private static final String TEST_BPL = "_testBPL";
    private static final String TEST_BPH = "_testBPH";
    private static final String TEST_TEMPERATURE = "_testTemperature";

    //Constructor

    public MyDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //Overriding onCreate and onUpgrade methods

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create the tables when the database is created
        /*CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (
                column_1 data_type PRIMARY KEY,
                column_2 data_type NOT NULL,
                column_3 data_type DEFAULT 0,
                table_constraint
        ) [WITHOUT ROWID];*/
        String doctorTableQuery = "CREATE TABLE [IF NOT EXISTS] " +
                TABLE_DOCTOR + " (" +
                DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DOCTOR_FIRSTNAME + " TEXT NOT NULL, " +
                DOCTOR_LASTNAME + " TEXT NOT NULL, " +
                DOCTOR_DEPARTMENT + " TEXT NOT NULL, " +
                DOCTOR_PASSWORD + " TEXT NOT NULL " + ");";
        String nurseTableQuery = "CREATE TABLE [IF NOT EXISTS] " +
                TABLE_NURSE + " (" +
                NURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NURSE_FIRSTNAME + " TEXT NOT NULL, " +
                NURSE_LASTNAME + " TEXT NOT NULL, " +
                NURSE_DEPARTMENT + " TEXT NOT NULL, " +
                NURSE_PASSWORD + " TEXT NOT NULL " + ");";
        String patientTableQuery = "CREATE TABLE [IF NOT EXISTS] " +
                TABLE_PATIENT + " (" +
                PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PATIENT_FIRSTNAME + " TEXT NOT NULL, " +
                PATIENT_LASTNAME + " TEXT NOT NULL, " +
                PATIENT_DEPARTMENT + " TEXT NOT NULL, " +
                PATIENT_DOCTOR_ID + " INTEGER NOT NULL " +
                PATIENT_ROOM + " TEXT NOT NULL " + ");";
        String testTableQuery = "CREATE TABLE [IF NOT EXISTS] " +
                TABLE_TEST + " (" +
                TEST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TEST_PATIENT_ID + " INTEGER NOT NULL, " +
                TEST_NURSE_ID + " INTEGER NOT NULL, " +
                TEST_BPL + " TEXT NOT NULL, " +
                TEST_BPH + " TEXT NOT NULL " +
                TEST_TEMPERATURE + " INTEGER NOT NULL " + ");";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
