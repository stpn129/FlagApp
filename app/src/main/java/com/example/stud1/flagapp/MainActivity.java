package com.example.stud1.flagapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_show;
    EditText searchCountry;
    ImageView flagImage;
    int image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagImage = findViewById(R.id.flagView);
        if (savedInstanceState != null) {
            image = savedInstanceState.getInt("image_key");
            flagImage.setImageResource(image);
        }
        button_show = findViewById(R.id.button);
        searchCountry = findViewById(R.id.searchCountry);

        searchCountry.addTextChangedListener(mWatcher);


        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchCountry.getText().toString().equals("Россия")) {
                    flagImage.setImageResource(R.drawable.flag_rf);
                    flagImage.setOnClickListener(imgListener);
                } else if (searchCountry.getText().toString().equals("Аргентина")) {
                    flagImage.setImageResource(R.drawable.arg);
                } else if (searchCountry.getText().toString().equals("Ямайка")) {
                    flagImage.setImageResource(R.drawable.yam);
                } else {
                    Toast.makeText(MainActivity.this, "This country does not exist:(", Toast.LENGTH_SHORT).show();

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
            button_show.setEnabled(!searchCountry.getText().toString().isEmpty());

        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        image = R.drawable.flagimage;
        outState.putInt("image_key", image);
        super.onSaveInstanceState(outState, outPersistentState);
    }
    View.OnClickListener imgListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,InfoActivity.class);
            intent.putExtra("country",searchCountry.getText().toString());
            startActivity(intent);

        }
    };
}
