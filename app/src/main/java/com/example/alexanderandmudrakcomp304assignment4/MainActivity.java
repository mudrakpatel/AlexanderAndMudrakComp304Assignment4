package com.example.alexanderandmudrakcomp304assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare required GUI variables for reference
    Button loginButtonMainActivity;
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

                } else if(doctorRoleRadioButtonMainActivity.isChecked() && areBothCredentialsEntered() == false){
                    //If this code block is executed then
                    //it means that validation successful

                } else{
                    //If this code block is executed then
                    //it means that validation unsuccessful
                    Toast.makeText(MainActivity.this, "PLEASE ENTER PROPER CREDENTIALS AND SELECT A USER ROLE TO LOG IN.",
                            Toast.LENGTH_SHORT).show();
                }
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
