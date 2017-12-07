package com.example.alexanderandmudrakcomp304assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddUserActivity extends AppCompatActivity {
    //Required variables
    EditText firstNameEditTextAddUserActivity,
            lastNameEditTextAddUserActivity,
            departmentEditTextAddUserActivity,
            passwordEditTextAddUserActivity;
    RadioButton nurseOptionRadioButtonAddUserActivity,
            doctorOptionRadioButtonAddUserActivity;
    Button addNewUserButtonAddUserActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //Set the Action bar text to "Add new user"
        getSupportActionBar().setTitle("Add new user");
        //Add an click event listener on the button
        addNewUserButtonAddUserActivity = (Button) findViewById(R.id.addNewUserButtonAddUserActivity);
        addNewUserButtonAddUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize the required variables
                firstNameEditTextAddUserActivity = (EditText) findViewById(R.id.firstNameEditTextAddUserActivity);
                lastNameEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
                departmentEditTextAddUserActivity = (EditText) findViewById(R.id.lastNameEditTextAddUserActivity);
                passwordEditTextAddUserActivity = (EditText) findViewById(R.id.passwordEditTextAddUserActivity);
                nurseOptionRadioButtonAddUserActivity = (RadioButton) findViewById(R.id.nurseOptionRadioButtonAddUserActivity);
                doctorOptionRadioButtonAddUserActivity = (RadioButton) findViewById(R.id.doctorOptionRadioButtonAddUserActivity);
                //Validate user input (Basic validation)
                if(nurseOptionRadioButtonAddUserActivity.isChecked() && validateAllEditTexts() == false){
                    //Validation successful
                    //Add a new Nurse to the database

                } else if(doctorOptionRadioButtonAddUserActivity.isChecked() && validateAllEditTexts() == false){
                    //Validation successful
                    //Add a new Doctor to the database

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
