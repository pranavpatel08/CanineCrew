package com.example.sepmproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sepmproject.ui.main.SectionsPagerAdapter;

public class ShopActivity extends AppCompatActivity {

    public void pedOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Pedigree Adult 10kg");
        intent.putExtra("price","₹1799");

        startActivity(intent);

    }
    public void pedigreegravyOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Pedigree Gravy Adult 80gm");
        intent.putExtra("price","₹999");
        startActivity(intent);
    }
    public void royalOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Royal Canine Adult 10kg");
        intent.putExtra("price"," ₹4299");
        startActivity(intent);
    }
    public void canineOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Canine Creek Puppy 1Kg");
        intent.putExtra("price","₹649");
        startActivity(intent);
    }
    public void leashOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Dog Leash");
        intent.putExtra("price","₹460");
        startActivity(intent);
    }
    public void collarOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Dog Collar");
        intent.putExtra("price","₹799");
        startActivity(intent);
    }
    public void dogbowlOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","2 Dog Bowls");
        intent.putExtra("price","₹199");
        startActivity(intent);
    }

    public void whiskasAdult(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Whiskas Adult 7kg");
        intent.putExtra("price","₹1599");
        startActivity(intent);
    }
    public void whiskasKitten(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Whiskas Kitten 1.1kg");
        intent.putExtra("price","₹399");
        startActivity(intent);
    }
    public void catbowl(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","2 Cat Bowls");
        intent.putExtra("price","₹199");
        startActivity(intent);
    }
    public void skylarzOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Skylarz Bird Food 1kg");
        intent.putExtra("price","₹299");
        startActivity(intent);
    }
    public void boltzOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Boltz Bird Food 1.2kg");
        intent.putExtra("price","₹399");
        startActivity(intent);
    }
    public void feederOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Bird Food and Water Feeders");
        intent.putExtra("price","₹155");
        startActivity(intent);
    }

    public void optimumOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Optimum Fish Food 1kg");
        intent.putExtra("price","₹380");
        startActivity(intent);
    }
    public void taiyoOnClick(View view){
        Intent intent = new Intent(getApplicationContext(),PlaceOrderActivity.class);
        intent.putExtra("product","Taiyo Fish Food 500g");
        intent.putExtra("price","₹128");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }
}