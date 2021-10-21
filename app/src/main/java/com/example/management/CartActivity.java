package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {

    TextView display,display1,display2,display3;
    String chicken,beef,fried,biryani;
    Member member = new Member();

    public static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setTitle("Your Cart Items");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        chicken = settings.getString("chicken",chicken);
        biryani = settings.getString("biryani",biryani);
        beef = settings.getString("beef",beef);
        fried = settings.getString("fried",fried);


        display = findViewById(R.id.display);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);
        display3 = findViewById(R.id.display3);
        display.setText(chicken);
        display1.setText(biryani);
        display2.setText(beef);
        display3.setText(fried);
    }

    public void cartmethod(View view)
    {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();

        Toast.makeText(CartActivity.this,"Order Successful",Toast.LENGTH_LONG).show();
    }


}
