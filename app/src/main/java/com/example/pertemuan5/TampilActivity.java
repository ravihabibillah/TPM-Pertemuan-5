package com.example.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pertemuan5.Database.AppDatabase;
import com.example.pertemuan5.Database.DataDiri;

import java.util.ArrayList;

public class TampilActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private ArrayList<DataDiri> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        // init database
        appDatabase = AppDatabase.initDb(getApplicationContext());

        recyclerView = findViewById(R.id.rvData);
        recyclerView.setHasFixedSize(true);

        // panggil read
        read();
    }

    private void read() {

        list.addAll(appDatabase.dao().getData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataDiriAdapter adapter = new DataDiriAdapter(this, new DataDiriListener() {
            @Override
            public void onButtonDelete(DataDiri item) {
               appDatabase.dao().delete(item);
               list.clear();
               read();
            }
        });

        adapter.setDataDiris(list);
        recyclerView.setAdapter(adapter);
    }
}
