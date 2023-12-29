package com.example.sepmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    DBHelper db;
    private String username;
    private String password;
    EditText e1,e2;
    Button signUpButton;

    public void insertUser(){
     signUpButton.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             String s1 = e1.getText().toString();
             String s2 = e2.getText().toString();
             if(s1.equals("")|| s2.equals("")){

             }
             else{
                 Boolean check = db.Checkusername(s1);
                 if(check == true){
                     Boolean insert = db.insert(s1,s2);
                     if(insert==true){
                         Toast.makeText(SignUpActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                         startActivity(intent);

                         finish();
                     }
                 }else{
                     Toast.makeText(SignUpActivity.this, "Username already exists!Please try another username ", Toast.LENGTH_SHORT).show();
                 }
             }

         }
     });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new DBHelper(this);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        signUpButton = findViewById(R.id.signupButton);
        insertUser();






    }
}