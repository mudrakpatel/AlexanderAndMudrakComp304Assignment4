package com.example.alexanderandmudrakcomp304assignment4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.Doctor;
import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.MyDatabaseHandler;
import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.Nurse;

public class AddUserActivity extends AppCompatActivity {
    //Required variables
    MyDatabaseHandler db;
    EditText firstNameEditTextAddUserActivity,
            lastNameEditTextAddUserActivity,
            departmentEditTextAddUserActivity,
            passwordEditTextAddUserActivity,
            showIDEditTextAddUserActivity;
    RadioButton nurseOptionRadioButtonAddUserActivity,
            doctorOptionRadioButtonAddUserActivity;
    Button addNewUserButtonAddUserActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //Set the Action bar text to "Add new user"
        getSupportActionBar().setTitle("Add new user");
        //Initialize the required variables
        db = new MyDatabaseHandler(AddUserActivity.this);
        firstNameEditTextAddUserActivity = (EditText) findViewById(R.id.firstNameEditTextAddUserActivity);
        lastNameEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
        departmentEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
        passwordEditTextAddUserActivity = (EditText) findViewById(R.id.passwordEditTextAddUserActivity);
        nurseOptionRadioButtonAddUserActivity = (RadioButton) findViewById(R.id.nurseOptionRadioButtonAddUserActivity);
        doctorOptionRadioButtonAddUserActivity = (RadioButton) findViewById(R.id.doctorOptionRadioButtonAddUserActivity);
        //Add an click event listener on the button
        addNewUserButtonAddUserActivity = (Button) findViewById(R.id.addNewUserButtonAddUserActivity);
        addNewUserButtonAddUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validate user input (Basic validation)
                if(nurseOptionRadioButtonAddUserActivity.isChecked() && validateAllEditTexts() == false){
                    try {
                        //Validation successful
                        //Add a new Nurse to the database
                        Nurse tempNurse = new Nurse(firstNameEditTextAddUserActivity.getText().toString(),
                                                    lastNameEditTextAddUserActivity.getText().toString());
                        tempNurse.setNursePassword(passwordEditTextAddUserActivity.getText().toString());
                        tempNurse.setNurseDepartment(departmentEditTextAddUserActivity.getText().toString());
                        db.addNewNurse(tempNurse);
/*                        SQLiteDatabase writableDatabase = db.getWritableDatabase();
                        String generatedID;
                        String selectQuery = "SELECT nurseID from NURSE WHERE nurseFirstName = \"" + tempNurse.getNurseFirstName()
                                             + "\" AND nurseLastName = \"" + tempNurse.getNurseLastName() + "\" AND "
                                             + "nurseDepartment = \"" + tempNurse.getNurseDepartment()
                                             + "\" AND nursePassword = \"" + tempNurse.getNursePassword() + "\";";
                        Cursor cursor = writableDatabase.rawQuery(selectQuery, null);
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            if(Integer.toString(cursor.getInt(cursor.getColumnIndex("nurseID"))) != null){
                                generatedID = Integer.toString(cursor.getInt(cursor.getColumnIndex("nurseID")));
                                showIDEditTextAddUserActivity = (EditText) findViewById(R.id.showIDEditTextAddUserActivity);
                                showIDEditTextAddUserActivity.setText(generatedID);
                                showIDEditTextAddUserActivity.setKeyListener(null);
                            }
                        }*/
                        showIDEditTextAddUserActivity = (EditText) findViewById(R.id.showIDEditTextAddUserActivity);
                        showIDEditTextAddUserActivity.setText(""+db.getNurseID(tempNurse));
                        showIDEditTextAddUserActivity.setKeyListener(null);
                        Toast.makeText(AddUserActivity.this, "NEW USER ADDED.", Toast.LENGTH_SHORT).show();
                        /*onBackPressed();*/
                    } catch (Exception e) {
                        Toast.makeText(AddUserActivity.this, "SOMETHING WENT WRONG!", Toast.LENGTH_SHORT).show();
                        System.out.println("EXCEPTION >>> " + e.getMessage());
                    }

                } else if(doctorOptionRadioButtonAddUserActivity.isChecked() && validateAllEditTexts() == false){
                    try {
                        //Validation successful
                        //Add a new Doctor to the database
                        Doctor tempDoctor = new Doctor(firstNameEditTextAddUserActivity.getText().toString(),
                                lastNameEditTextAddUserActivity.getText().toString());
                        tempDoctor.setDoctorPassword(passwordEditTextAddUserActivity.getText().toString());
                        tempDoctor.setDoctorDepartment(departmentEditTextAddUserActivity.getText().toString());
                        db = new MyDatabaseHandler(AddUserActivity.this);
                        db.addNewDoctor(tempDoctor);
                        Toast.makeText(AddUserActivity.this, "NEW USER ADDED.", Toast.LENGTH_SHORT).show();
                        /*onBackPressed();*/
                    } catch (Exception e) {
                        Toast.makeText(AddUserActivity.this, "SOMETHING WENT WRONG!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(AddUserActivity.this, "PLEASE ENTER PROPER VALUES IN ALL FIELDS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
    * validateAllEditTexts() : boolean
    * */
    public boolean validateAllEditTexts(){
        //Initialize the required variables
        /*firstNameEditTextAddUserActivity = (EditText) findViewById(R.id.firstNameEditTextAddUserActivity);
        lastNameEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
        departmentEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
        passwordEditTextAddUserActivity = (EditText) findViewById(R.id.passwordEditTextAddUserActivity);*/
        //////////////////////////////////////////////
        ///Check if any of these EditText's are empty
        ///If empty then return true else return false
        if(firstNameEditTextAddUserActivity.getText().toString().isEmpty() ||
                lastNameEditTextAddUserActivity.getText().toString().isEmpty() ||
                departmentEditTextAddUserActivity.getText().toString().isEmpty() ||
                passwordEditTextAddUserActivity.getText().toString().isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}
