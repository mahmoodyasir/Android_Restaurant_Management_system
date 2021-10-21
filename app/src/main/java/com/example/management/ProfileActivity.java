package com.example.management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    EditText editText;
    String image, name, place, price, ans;
    Integer input_num, given_num,result;
    TextView textView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView image_name = findViewById(R.id.item_image);
        TextView item_name = findViewById(R.id.item_name);
        TextView item_place = findViewById(R.id.item_place);
        TextView item_price = findViewById(R.id.item_price);
        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textview);


        image = "image not set";
        name = "name not set";
        place = "place not set";
        price = "price not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            image = extras.getString("image");
            name = extras.getString("name");
            place = extras.getString("place");
            price = extras.getString("price");
        }

        Glide.with(this).load(image).into(image_name);
        item_name.setText(name);
        item_place.setText(place);
        item_price.setText(price);

    }

    public void methodcart(View view) {

        input_num = Integer.parseInt(editText.getText().toString());
        given_num = Integer.parseInt(price);
        result = input_num * given_num;
        ans = Integer.toString(result);
        textView.setText(ans);
    }
}