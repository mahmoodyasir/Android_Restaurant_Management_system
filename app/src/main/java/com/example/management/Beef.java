package com.example.management;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Beef extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    Integer num,result;
    String ans,beef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beef);
        setTitle("Beef Bhuna");


        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);
}

    public void methodcart(View view)
    {
        num = Integer.parseInt(editText.getText().toString());
        result = 5*num;
        ans = Integer.toString(result);

        beef = "Beef Bhuna X "+num+" = "+ans;
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("beef",beef);
        editor.commit();

        textView.setText(ans);
    }

}
