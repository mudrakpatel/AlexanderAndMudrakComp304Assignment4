package com.example.alexanderandmudrakcomp304assignment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //Set the Action bar text to "Add new user"
        getSupportActionBar().setTitle("Add new user");
    }
}
