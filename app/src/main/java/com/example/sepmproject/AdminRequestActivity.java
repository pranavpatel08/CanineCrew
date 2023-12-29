package com.example.sepmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminRequestActivity extends AppCompatActivity {
    Button acceptButton,rejectButton;
    EditText shelterUsername,appnumber;
    DBHelper db;
    int status;

    public void acceptOnClick(View view){
        String username = shelterUsername.getText().toString();
        String appno = appnumber.getText().toString();
        status = 1;
        Boolean update = db.updateStatus(status,appno,username);
        if(update == true){
            Toast.makeText(this, "Accepted!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void rejectOnClick(View view){
        String username = shelterUsername.getText().toString();
        String appno = appnumber.getText().toString();
        status = -1;
        Boolean update = db.updateStatus(status,appno,username);
        if(update == true){
            Toast.makeText(this, "Rejected!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_request);
        shelterUsername = findViewById(R.id.shelterUsernameEditText);
        appnumber = findViewById(R.id.appnoEditText);
        acceptButton = findViewById(R.id.acceptButton);
        rejectButton = findViewById(R.id.rejectButton);
        db = new DBHelper(this);
    }
}