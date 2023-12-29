package com.example.sepmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class book_appoinment extends AppCompatActivity {
    int status = 0;
    int output;
    EditText name,phone,date;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appoinment);

        TextView heading=(TextView)findViewById(R.id.heading2);
        heading.setText("GIVE DETAILS FOR BOOKING");

        //user info gathering store to database
        db = new DBHelper(this);
        name=findViewById(R.id.editTextname);
        phone=findViewById(R.id.editTextPhone);
        date=findViewById(R.id.editTextDate);
        final TextView result=findViewById(R.id.textView2);

        Button Return1=(Button)findViewById(R.id.button3);
        Return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        Button confirm=(Button)findViewById(R.id.button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                output = random.nextInt((1000-65)+1)+65;
                String Name = name.getText().toString();
                String Phone = phone.getText().toString();
                String Date = date.getText().toString();
                if(Name.equals("")|| Phone.equals("")|| Date.equals("")||Phone.length()!=10||Date.length()<5){
                    Toast.makeText(book_appoinment.this, "Invalid Details", Toast.LENGTH_LONG).show();
                }else {
                    Boolean username = db.Checkusername(Name);
                    if (username == true) {
                        Toast.makeText(book_appoinment.this, "Invalid Username", Toast.LENGTH_LONG).show();
                    } else {
                        Boolean insert = db.insertShelter(String.valueOf(output), Name, Phone, Date, status);
                        if (insert == true) {
                            Toast.makeText(book_appoinment.this, "Your Appointment has been booked! Please wait and Check Status Afterwards.", Toast.LENGTH_LONG).show();
                            result.setText(output + " is  your unique appoinment number remember to check status");
                        } else {
                            Toast.makeText(book_appoinment.this, "Some Error, Please try again.", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
        //store output + name + phone + date into db

    }
}