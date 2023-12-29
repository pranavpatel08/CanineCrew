package com.example.sepmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {
    DBHelper db;
    String username;
    String amount;
    String product;
    Button deleteButton,updateButton,shelterReq;
    EditText usernameAdminEditText,productEditText,amountEditText;

    public void deleteButtonOnClick(View view) {
        String uname = usernameAdminEditText.getText().toString();
        Boolean delete = db.deleteuserdata(uname);
        if (delete == true) {
            Toast.makeText(this, "Deleted.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Wrong Username.", Toast.LENGTH_LONG).show();
        }
    }
    public void shelterReqOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),AdminRequestActivity.class);
        startActivity(intent);


    }


    public void updateButtonOnClick(View view){
        String product_name = productEditText.getText().toString();
        int stock =  Integer.parseInt(amountEditText.getText().toString());
        Boolean update = db.updatestock(product_name,stock);
        if(update == true){
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = new DBHelper(this);
        deleteButton = findViewById(R.id.deleteButton);
        updateButton = findViewById(R.id.updateButton);
        usernameAdminEditText = findViewById(R.id.usernameadminEditTtext);
        productEditText = findViewById(R.id.productEditText);
        amountEditText = findViewById(R.id.amountEditText);
        shelterReq = findViewById(R.id.shelterReqButton);
    }
}