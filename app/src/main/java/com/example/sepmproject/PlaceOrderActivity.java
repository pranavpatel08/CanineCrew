package com.example.sepmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlaceOrderActivity extends AppCompatActivity {
    DBHelper db;
    EditText editText;
    EditText phoneEditText;
    Intent intent1;
    String product;
    String price;
    TextView priceTextView;
    TextView productTextView;
    private String usernameString;
    private String number;
    private int phone;
    String strDate;
    String data;
    Button button;

    public void placeOrderOnCLick(View view){
        usernameString = editText.getText().toString();
        number = phoneEditText.getText().toString();
         if(usernameString.equals("") || number.length() != 10) {
             Toast.makeText(this, "Invalid Username or Contact Number", Toast.LENGTH_SHORT).show();
         }
         else{
             //Toast.makeText(this, "Order Placed Successfully!", Toast.LENGTH_LONG).show();


             Boolean username = db.Checkusername(usernameString);
             if(username == true){
                 Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
             }else{
                 Date date = Calendar.getInstance().getTime();
                 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                 strDate = dateFormat.format(date);
                 Boolean insert = db.insertOrders(usernameString,number,product,strDate);
                 if(insert == true){
                     //Toast.makeText(this, "Order Succesfully Placed!", Toast.LENGTH_SHORT).show();
                     int stock = Integer.parseInt(data);
                     stock = stock -1;
                     Boolean decrement = db.updatestock(product,stock);
                     if(decrement == true){
                         Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
                         finish();
                     }else{
                         Toast.makeText(this, "Sad", Toast.LENGTH_LONG).show();
                     }


                 }else{
                     Toast.makeText(this, "Some error,Please try again", Toast.LENGTH_SHORT).show();
                 }


             }

         }

    }

    public void cancelOnClick(View view){
           finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBHelper(this);
        setContentView(R.layout.activity_place_order);
        editText = findViewById(R.id.editText);
        productTextView = findViewById(R.id.productTextView);
        priceTextView = findViewById(R.id.priceTextView);
        phoneEditText = findViewById(R.id.editTextPhone);
        button = findViewById(R.id.button);

        intent1 = getIntent();


        product = intent1.getStringExtra("product");
        price = intent1.getStringExtra("price");



        productTextView.setText(product);
        priceTextView.setText(price);

        Cursor c = db.getStock(product);
        if (c.moveToFirst()) {
            do {
                data = c.getString(c.getColumnIndex("Stock"));
            } while (c.moveToNext());
        }
        c.close();
        if(data.equals("0")){
            button.setEnabled(false);
            Toast.makeText(this, "Sorry,This Product is Out Of Stock.", Toast.LENGTH_LONG).show();
        }




    }
}