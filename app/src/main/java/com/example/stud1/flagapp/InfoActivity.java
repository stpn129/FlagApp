package com.example.stud1.flagapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {
    String country;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        country = Objects.requireNonNull(getIntent().getExtras()).getString("country");
        Toast toast = new Toast(InfoActivity.this);
        Toast.makeText(InfoActivity.this,country,Toast.LENGTH_SHORT).show();

    }
}
