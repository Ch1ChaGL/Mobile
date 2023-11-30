package com.example.a24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a24.API.NoteAPI;

import java.util.List;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);


        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
    }

    public void clickAdd(View view){
        NoteAPI.getAllNotes();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
