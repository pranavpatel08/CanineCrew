package com.example.sepmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Shelter extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);

        TextView heading=(TextView)findViewById(R.id.heading);
        heading.setText("WELCOME TO Appointment Booking");


        Button book=(Button)findViewById(R.id.bookappoinment);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent start = new Intent(getApplicationContext(), book_appoinment.class);
                    startActivity(start);


            }
        });
        Button check=(Button)findViewById(R.id.checkdetails);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent start=new Intent(getApplicationContext(),check_details.class);
               startActivity(start);
            }
        });


    }
}