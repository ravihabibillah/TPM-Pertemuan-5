package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pertemuan5.Database.AppDatabase;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.iniDb(getApplicationContext());
    }
}
