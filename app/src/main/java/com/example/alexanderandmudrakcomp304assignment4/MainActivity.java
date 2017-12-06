package com.example.alexanderandmudrakcomp304assignment4;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set action bar text to "Login"
        getSupportActionBar().setTitle("Login");

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
                if(nurseRoleRadioButtonMainActivity.isChecked() && areBothCredentialsEntered() == false){
                    //If this code block is executed then
                    //it means that validation successful
                    //in terms that no fields are empty
                    //-----------------------------------
                    //Now we need to log in the proper user
                    //1) Check if the Nurse table is empty or not


                } else if(doctorRoleRadioButtonMainActivity.isChecked() && areBothCredentialsEntered() == false){
                    //If this code block is executed then
                    //it means that validation successful
                    //in terms that no fields are empty
                    //-----------------------------------
                    //Now we need to log in the proper user

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
            return true;
        } else {
            return false;
        }
    }
}
