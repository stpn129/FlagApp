package com.example.stud1.flagapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_show;
    EditText searchCountry;
    ImageView flagImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button_show = findViewById(R.id.button);
       searchCountry = findViewById(R.id.searchCountry);

       searchCountry.addTextChangedListener(mWatcher);

       flagImage = findViewById(R.id.flagView);
       button_show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (searchCountry.getText().toString().equals("Россия")){
                   flagImage.setImageResource(R.drawable.flag_rf);
               }else{
                   Toast.makeText(MainActivity.this,"This country does not exist:(",Toast.LENGTH_SHORT).show();;
               }

           }
       });

    }
TextWatcher mWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
 if (!searchCountry.getText().toString().isEmpty()){
     button_show.setEnabled(true);
     button_show.setBackgroundResource(R.drawable.btn_gradient);

 }
    }
};
}
