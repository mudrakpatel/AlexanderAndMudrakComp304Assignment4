package com.example.alexanderandmudrakcomp304assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.MyDatabaseHandler;

public class MainActivity extends AppCompatActivity {
    //Declare required GUI variables for reference
    Button loginButtonMainActivity, addUserButtonMainActivity;
    RadioButton nurseRoleRadioButtonMainActivity;
    RadioButton doctorRoleRadioButtonMainActivity;
    public EditText editTextUserName;
    public EditText editTextPassword;
    MyDatabaseHandler db;
    public SharedPreferences sharedPreferences;
    //public Editor sharedPreferencesEditor; //Just in case


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set action bar text to "Login"
        getSupportActionBar().setTitle("Login");
        db = new MyDatabaseHandler(getApplicationContext());
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        //Initialize the loginButtonMainActivity Button
        loginButtonMainActivity = (Button) findViewById(R.id.loginButtonMainActivity);
        loginButtonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nurseRoleRadioButtonMainActivity =
                        (RadioButton) findViewById(R.id.nurseRoleRadioButtonMainActivity);
                doctorRoleRadioButtonMainActivity =
                        (RadioButton) findViewById(R.id.doctorRoleRadioButtonMainActivity);

                //Check which radioButton is checked
                if(nurseRoleRadioButtonMainActivity.isChecked() && areBothCredentialsEntered() == true){
                    try {
                        //If this code block is executed then
                        //it means that validation successful
                        //in terms that no fields are empty
                        //-----------------------------------
                        //Now we need to log in the proper user
                        //File dbFile = getDatabasePath("HospitalDatabase"); //For debugging
                        db = new MyDatabaseHandler(MainActivity.this);
                        if(db.loginNurse(editTextUserName.getText().toString(), editTextPassword.getText().toString()) == true){
                            //Save the user credentials to the Shared Preferences
                            sharedPreferences = getSharedPreferences("loginSharedPreferences", MODE_PRIVATE);
                            sharedPreferences.edit().putString("preferencesUsername", editTextUserName.getText().toString());
                            sharedPreferences.edit().putString("preferencesPassword", editTextPassword.getText().toString());
                            //Check if the credentials are saved to SHared Preferences
                            if(sharedPreferences.edit().commit() == false){
                                //Display error message
                                Toast.makeText(MainActivity.this, "ERROR: CREDENTIALS NOT SAVED.\nENTER CREDENTIALS AGAIN.", Toast.LENGTH_SHORT).show();
                                //Clear the EditTexts
                                editTextUserName.getText().clear();
                                editTextPassword.getText().clear();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ERROR: NO SUCH USER FOUND!", Toast.LENGTH_SHORT).show();
                            //Clear the EditTexts
                            editTextUserName.getText().clear();
                            editTextPassword.getText().clear();
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else if(doctorRoleRadioButtonMainActivity.isChecked() && areBothCredentialsEntered() == true){
                    try {
                        //If this code block is executed then
                        //it means that validation successful
                        //in terms that no fields are empty
                        //-----------------------------------
                        //Now we need to log in the proper user
                        //File dbFile = getDatabasePath("HospitalDatabase"); //For debugging
                        db = new MyDatabaseHandler(MainActivity.this);
                        if(db.loginDoctor(editTextUserName.getText().toString(), editTextPassword.getText().toString()) == true){
                            //Save the user credentials to the Shared Preferences
                            sharedPreferences = getSharedPreferences("loginSharedPreferences", MODE_PRIVATE);
                            sharedPreferences.edit().putString("preferencesUsername", editTextUserName.getText().toString());
                            sharedPreferences.edit().putString("preferencesPassword", editTextPassword.getText().toString());
                            //Check if the credentials are saved to SHared Preferences
                            if(sharedPreferences.edit().commit() == false){
                                //Display error message
                                Toast.makeText(MainActivity.this, "ERROR: CREDENTIALS NOT SAVED.\nENTER CREDENTIALS AGAIN.", Toast.LENGTH_SHORT).show();
                                //Clear the EditTexts
                                editTextUserName.getText().clear();
                                editTextPassword.getText().clear();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ERROR: NO SUCH USER FOUND!", Toast.LENGTH_SHORT).show();
                            //Clear the EditTexts
                            editTextUserName.getText().clear();
                            editTextPassword.getText().clear();
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else{
                    //If this code block is executed then
                    //it means that validation unsuccessful
                    //It means that some fields are empty
                    Toast.makeText(MainActivity.this, "PLEASE ENTER PROPER CREDENTIALS AND SELECT A USER ROLE TO LOG IN.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        addUserButtonMainActivity = (Button) findViewById(R.id.addUserButtonMainActivity);
        addUserButtonMainActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, AddUserActivity.class));
            }
        });
    }

    /*
    * areCredentialsEntered() : boolean
    * */
    public boolean areBothCredentialsEntered(){
        //Initialize the EditTexts
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        if(editTextUserName.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
