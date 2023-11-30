package com.example.a24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {
    MyApp application;
    List<Note> list;
    ListView lv;
    MyAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        lv = (ListView) findViewById(R.id.lv);
        application = (MyApp) getApplicationContext();
        lv.setOnItemClickListener(this);

        adapter = new MyAdapter(application);
        lv.setAdapter(adapter);

        list = application.getNotes();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        lv.invalidateViews();
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, Second.class);
        MyApp.CurrentActionCode = MyApp.CREATE_ACTION;
        startActivityForResult(intent, MyApp.CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, Second.class);
        MyApp.CurrentActionCode = MyApp.EDIT_ACTION;
        application.setNoteId(i);
        startActivityForResult(intent, MyApp.EDIT_ACTION);
    }
}
