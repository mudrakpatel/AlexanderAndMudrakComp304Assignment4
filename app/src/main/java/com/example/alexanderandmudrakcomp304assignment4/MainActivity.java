package com.example.alexanderandmudrakcomp304assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.MyDatabaseHandler;
import com.example.alexanderandmudrakpatelcomp304assignment4.sqllitetables.Nurse;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    //Declare required GUI variables for reference
    Button loginButtonMainActivity, addUserButtonMainActivity;
    RadioButton nurseRoleRadioButtonMainActivity;
    RadioButton doctorRoleRadioButtonMainActivity;
    public EditText editTextUserName;
    public EditText editTextPassword;
    MyDatabaseHandler db;
    public SharedPreferences sharedPreferences;
    public Editor sharedPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set action bar text to "Login"
        getSupportActionBar().setTitle("Login");
        db = new MyDatabaseHandler(getApplicationContext());
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        String username = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
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
                    try {
                        //If this code block is executed then
                        //it means that validation successful
                        //in terms that no fields are empty
                        //-----------------------------------
                        //Now we need to log in the proper user
                        File dbFile = getDatabasePath("HospitalDatabase");

                        /*String selectQuery = "SELECT nurseID, nursePassword FROM Nurse WHERE nurseID = \"" + editTextUserName.getText().toString()
                                            + "\"" + " AND nursePassword = \"" + editTextPassword.getText().toString() + "\";";*/
                        /*Cursor cursor = writableDatabase.rawQuery(selectQuery,null);*/
                        sharedPreferences = getSharedPreferences("loginSharedPreferences", MODE_PRIVATE);
                        //Check if cursor has nay data
                        //If no data, then Display a Toast message
                        if(cursor.moveToNext()){
                            sharedPreferencesEditor = sharedPreferences.edit();
                            sharedPreferencesEditor.putInt("savedNurseID", cursor.getInt(cursor.getColumnIndex("nurseID")));
                            sharedPreferencesEditor.putInt("savedNursePassword", cursor.getInt(cursor.getColumnIndex("nursePassword")));
                            //Launch the next Activity
                            //startActivity(new Intent(MainActivity.this, MenuActivity.class));
                            Toast.makeText(MainActivity.this, "LOGGED IN", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "ERROR: NO SUCH USER FOUND!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


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
