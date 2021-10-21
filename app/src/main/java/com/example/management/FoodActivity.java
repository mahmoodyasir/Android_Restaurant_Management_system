package com.example.management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements FoodAdapter.OnContactClickListener{

    private static final String FOOD_URL = "http://192.168.137.1/MyApi/api.php";

    RecyclerView recyclerView;

    ArrayList<ModelFood> foodList;
    FoodAdapter.OnContactClickListener onContactClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().setTitle("Select Food Items");
        onContactClickListener=this;

        recyclerView = findViewById(R.id.rv);

        foodList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        loadFoodItems();


//        foodList.add(new ModelFood(R.drawable.biryani,"Biryani","Savar"," ৳ 4"));
//        foodList.add(new ModelFood(R.drawable.beefbhuna,"Beef Bhuna","Dhanmondi"," ৳ 5"));
//        foodList.add(new ModelFood(R.drawable.chickenroast,"Chicken Roast","Mohammadpur"," ৳ 6"));
//        foodList.add(new ModelFood(R.drawable.friedrice,"Fried Rice","Hatirpul"," ৳ 7"));
//        foodList.add(new ModelFood(R.drawable.berger1,"Burger","Jhigatola"," ৳ 15"));



    }

    private void loadFoodItems() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, FOOD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray foods = new JSONArray(response);

                    for (int i = 0; i < foods.length(); i++)
                    {
                        JSONObject foodObject = foods.getJSONObject(i);

                        int id = foodObject.getInt("id");
                        String image = foodObject.getString("image");
                        String name = foodObject.getString("name");
                        String place = foodObject.getString("place");
                        String price = foodObject.getString("price");

                        ModelFood mFood = new ModelFood(image, name, place, price);
                        foodList.add(mFood);
                    }
                    FoodAdapter adapter = new FoodAdapter(FoodActivity.this,foodList,onContactClickListener);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FoodActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }


    @Override
    public void onContactClick(View v, int position) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        intent.putExtra("image", foodList.get(position).getImage());
        intent.putExtra("name", foodList.get(position).getName());
        intent.putExtra("place", foodList.get(position).getPlace());
        intent.putExtra("price", foodList.get(position).getPrice());
        startActivity(intent);
    }
}
