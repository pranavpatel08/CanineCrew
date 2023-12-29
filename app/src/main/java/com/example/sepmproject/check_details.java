// counter variable tell number of times user can try their status
package com.example.sepmproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class check_details extends AppCompatActivity {
    private int counter=5;
    private Button confirm;
    EditText appno,name;
    DBHelper db;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_details);
        db = new DBHelper(this);


        TextView heading3=(TextView)findViewById(R.id.textView6);
        heading3.setText("ENTER THE STATUS NUMBER");

        name = findViewById(R.id.username5editText);
        appno = findViewById(R.id.editTextAppNo);

        confirm=(Button)findViewById(R.id.button2);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String AppNo = appno.getText().toString();
                Cursor c = db.getStatus(AppNo, username);
                if (c.getCount() == 0) {

                    TextView subheading=(TextView)findViewById(R.id.statusreport);
                    TextView result=(TextView)findViewById(R.id.statusresult);
                    subheading.setText("INVALID DETAILS");
                    result.setText("");
                } else {
                    if (c.moveToFirst()) {
                        do {
                            data = c.getString(c.getColumnIndex("Status"));
                        } while (c.moveToNext());
                    }
                    c.close();

                    TextView subheading=(TextView)findViewById(R.id.statusreport);
                    TextView result=(TextView)findViewById(R.id.statusresult);

                    subheading.setText("STATUS REPORT");

                    if(data.equals("0")) {
                        result.setText("pending");

                    }
                    // need to match the condition of status with ==1
                    else if(data.equals("1")) {
                        result.setText("approved");
                    }
                    else if(data.equals("-1"))
                        result.setText("denied");

                }
            }
        });

        Button Return=(Button)findViewById((R.id.button4));
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });




    }


}