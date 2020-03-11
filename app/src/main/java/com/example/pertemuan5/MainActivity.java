package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pertemuan5.Database.AppDatabase;
import com.example.pertemuan5.Database.DataDiri;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    private Button btnSubmit, btnRead;
    private EditText etName,etAddress,etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.initDb(getApplicationContext());
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etGender = findViewById(R.id.etGender);

        btnRead = findViewById(R.id.btnRead);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }


    public void insert(){
        // Simpan ke variabel
        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        char gender = etGender.getText().toString().charAt(0);

        // Masukkan ke dalam item atau model
        DataDiri item = new DataDiri();
        item.setName(name);
        item.setAddress(address);
        item.setGender(gender);

        // Panggil fungsi insert
        appDatabase.dao().insert(item);

        // Reset Inputan
        etName.setText("");
        etAddress.setText("");
        etGender.setText("");
    }

    public void nextActivity(){
        Intent intent = new Intent(this,TampilActivity.class);
        this.startActivity(intent);
    }
}
