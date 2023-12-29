package com.example.sepmproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeTextView;
    TextView welcome2TextView;
    Button shelterButton;
    Button shopButton;
    TextView shelterTextView;
    TextView shopTextView;

    public void openShop(View view){
        Intent intent = new Intent(getApplicationContext(),ShopActivity.class);
        startActivity(intent);
    }
    public void openShelter(View view){
        Intent intent = new Intent(getApplicationContext(), Shelter.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.logout :
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
                return true;
            default:
                return false;
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        welcome2TextView = findViewById(R.id.welcome2TextView);
        shelterTextView = findViewById(R.id.shelterTextView);
        shopTextView = findViewById(R.id.shopTextView);
        shelterButton = findViewById(R.id.shelterButton);
        shopButton = findViewById(R.id.shopButton);

        welcomeTextView.setY(-500);
        welcome2TextView.setY(-500);
        welcomeTextView.setAlpha(0);
        welcome2TextView.setAlpha(0);
        shelterTextView.setAlpha(0);
        shopTextView.setAlpha(0);
        shopButton.setAlpha(0);
        shelterButton.setAlpha(0);

        welcomeTextView.animate().translationYBy(500).alpha(1).setDuration(1500);
        welcome2TextView.animate().translationYBy(500).alpha(1).setDuration(1500);

        shopButton.animate().alpha(1).setDuration(3000);
        shelterButton.animate().alpha(1).setDuration(3000);
        shelterTextView.animate().alpha(1).setDuration(3000);
        shopTextView.animate().alpha(1).setDuration(3000);
    }
}