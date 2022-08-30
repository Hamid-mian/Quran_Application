package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class surahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);
        ListView surahListView = findViewById(R.id.surahList);
        DBHelper dbHelper  = new DBHelper(surahList.this,"quran_database");
        ArrayList<surahModel>  s =  dbHelper.getAllSurahs();
        surahAdapter adapter = new surahAdapter(this, s);

        surahListView.setAdapter(adapter);
    }
}