package com.example.management;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(MainActivity.this,"Firebase connection success",Toast.LENGTH_LONG).show();

        drawerLayout = findViewById(R.id.drawerid);

        NavigationView navigationView = findViewById(R.id.navigationid);
        navigationView.setNavigationItemSelectedListener(this);

        //Created toggle icon
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);

        //addesd toggle icon into the drawer layout
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //displayed toggle icon here
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;

        if (menuItem.getItemId() == R.id.menuabout)
        {
            intent = new Intent(this,AboutActivity.class);
            startActivity(intent);

        }
        else if (menuItem.getItemId() == R.id.menufood)
        {
            intent = new Intent(this,FoodActivity.class);
            startActivity(intent);

        }
        else if (menuItem.getItemId() == R.id.menucart)
        {
            intent = new Intent(this,CartActivity.class);
            startActivity(intent);

        }
        else if (menuItem.getItemId() == R.id.menuemail)
        {
            intent = new Intent(this,EmailActivity.class);
            startActivity(intent);

        }
        else if (menuItem.getItemId() == R.id.menuratings)
        {
            intent = new Intent(this,RatingsActivity.class);
            startActivity(intent);

        }

        return false;
    }
}
