package com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.alexanderandmudrakcomp304assignment4.MainActivity;

import static android.content.Context.MODE_PRIVATE;

public class MyDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HospitalDatabase.db";
    //Variables for Doctor table
    private static final String TABLE_DOCTOR = "Doctor";
    private static final String DOCTOR_ID = "doctorID";
    private static final String DOCTOR_FIRSTNAME = "doctorFirstName";
    private static final String DOCTOR_LASTNAME = "doctorLastName";
    private static final String DOCTOR_DEPARTMENT = "doctorDepartment";
    private static final String DOCTOR_PASSWORD = "doctorPassword";
    //Variables for Nurse table
    private static final String TABLE_NURSE = "Nurse";
    private static final String NURSE_ID = "nurseID";
    private static final String NURSE_FIRSTNAME = "nurseFirstName";
    private static final String NURSE_LASTNAME = "nurseLastName";
    private static final String NURSE_DEPARTMENT = "nurseDepartment";
    private static final String NURSE_PASSWORD = "nursePassword";
    //Variables for Patient table
    private static final String TABLE_PATIENT = "Patient";
    private static final String PATIENT_ID = "patientID";
    private static final String PATIENT_FIRSTNAME = "patientFirstName";
    private static final String PATIENT_LASTNAME = "patientLastName";
    private static final String PATIENT_DEPARTMENT = "patientDepartment";
    private static final String PATIENT_DOCTOR_ID = "patientDoctorID";
    private static final String PATIENT_ROOM = "patientRoom";
    //Variables for Test table
    private static final String TABLE_TEST = "Test";
    private static final String TEST_ID = "testID";
    private static final String TEST_PATIENT_ID = "testPatientID";
    private static final String TEST_NURSE_ID = "testNurseID";
    private static final String TEST_BPL = "testBPL";
    private static final String TEST_BPH = "testBPH";
    private static final String TEST_TEMPERATURE = "testTemperature";

    //Constructor
    public MyDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
        //Store the queries in an array
        String[] queries = {doctorTableQuery, nurseTableQuery, patientTableQuery, testTableQuery};
        //Loop through the array to execute each query in the array
        for(String query : queries){
            try {
                sqLiteDatabase.execSQL(query);
            } catch (SQLException e) {
                System.out.println(">>>DATABASE EXCEPTION>>> " + e.getMessage() + "\n---FOUND AT>>> " + e.getStackTrace());
            }
        }

    }

    public void addNewNurse(Nurse nurse){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NURSE_FIRSTNAME, nurse.getNurseFirstName());
        contentValues.put(NURSE_LASTNAME, nurse.getNurseLastName());
        contentValues.put(NURSE_DEPARTMENT, nurse.getNurseDepartment());
        contentValues.put(NURSE_PASSWORD, nurse.getNursePassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NURSE, null, contentValues);
        db.close();
    }

    public int getNurseID(Nurse nurse){
        int idToReturn = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put("nurseID", nurse.getNurseID());
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT nurseID from NURSE WHERE nurseFirstName = \"" + nurse.getNurseFirstName()
                + "\" AND nurseLastName = \"" + nurse.getNurseLastName() + "\" AND "
                + "nurseDepartment = \"" + nurse.getNurseDepartment()
                + "\" AND nursePassword = \"" + nurse.getNursePassword() + "\";";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            idToReturn = cursor.getInt(cursor.getColumnIndex("nurseID"));
        }
        db.close();
        return idToReturn;
    }

    public void addNewDoctor(Doctor doctor){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DOCTOR_FIRSTNAME, doctor.getDoctorFirstName());
        contentValues.put(DOCTOR_LASTNAME, doctor.getDoctorLastName());
        contentValues.put(DOCTOR_DEPARTMENT, doctor.getDoctorDepartment());
        contentValues.put(DOCTOR_PASSWORD, doctor.getDoctorPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_DOCTOR, null, contentValues);
        db.close();
    }

    public boolean loginNurse(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT nurseID, nursePassword FROM Nurse WHERE nurseID = \"" +
                Integer.parseInt(username) + "\"" + " AND nursePassword = \"" + password + "\";";
        Cursor cursor = db.rawQuery(selectQuery,null);
        //Check if cursor has nay data
        if(cursor.getCount() != 0){
            cursor.moveToNext();
            int cursorUsername = cursor.getInt(cursor.getColumnIndex("nurseID"));
            String cursorPassword = cursor.getString(cursor.getColumnIndex("nursePassword"));
            //now check the values obtained from the cursor
            if(Integer.toString(cursorUsername).equals(username) && cursorPassword.equals(password)){
                db.close();
                return true;
            } else {
                db.close();
                return false;
            }
        } else {
            db.close();
            return false;
        }
    }

    public boolean loginDoctor(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT doctorID, doctorPassword FROM Doctor WHERE doctorID = \"" +
                Integer.parseInt(username) + "\"" + " AND doctorPassword = \"" + password + "\";";
        Cursor cursor = db.rawQuery(selectQuery,null);
        //Check if cursor has nay data
        if(cursor.getCount() != 0){
            cursor.moveToNext();
            int cursorUsername = cursor.getInt(cursor.getColumnIndex("doctorID"));
            String cursorPassword = cursor.getString(cursor.getColumnIndex("doctorPassword"));
            //now check the values obtained from the cursor
            if(Integer.toString(cursorUsername).equals(username) && cursorPassword.equals(password)){
                db.close();
                return true;
            } else {
                db.close();
                return false;
            }
        } else {
            db.close();
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String[] dropQueriesArray = {"DROP TABLE IF EXISTS " + TABLE_DOCTOR + ";",
                                "DROP TABLE IF EXISTS " + TABLE_NURSE + ";",
                                "DROP TABLE IF EXISTS " + TABLE_PATIENT + ";",
                                "DROP TABLE IF EXISTS " + TABLE_TEST + ";"};
        //Loop through the dropQueries array to drop all the tables
        for(String dropQuery : dropQueriesArray) {
            sqLiteDatabase.execSQL(dropQuery);
        }
        //Recreate all the tables to complete the upgrade
        this.onCreate(sqLiteDatabase);
    }
}
