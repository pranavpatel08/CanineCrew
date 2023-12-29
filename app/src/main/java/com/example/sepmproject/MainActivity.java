package com.example.sepmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    Button signupButton;
    Button adminLoginButton;
    Button loginButton;
    private String username;
    private String password;
    EditText e1,e2;



    public void login(View view){

        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        Boolean usernamepass = db.checkusernamepassword(s1,s2);
        if(usernamepass == true){
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);

            finish();
        }else{
            Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
        }



    }

    public void adminlogin(View view){
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        Boolean adminpass = db.adminpass(s1,s2);
        if(adminpass == true){
            Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
            Intent intent =  new Intent(getApplicationContext(), AdminActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();

        }




    }

    public void signup(View view){
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        adminLoginButton = findViewById(R.id.adminLoginButton);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        e1 = findViewById(R.id.usernameEditText);
        e2 = findViewById(R.id.passwordEditText);



    }
}