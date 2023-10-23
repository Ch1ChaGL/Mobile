package com.example.a11.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a11.R;
import com.example.a11.adapters.ColorsAdapter;

public class Second extends MyBaseActivity implements AdapterView.OnItemClickListener {
    ColorsAdapter adapter;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose_colors_act);

        String[] colorsName = getResources().getStringArray(R.array.colors_name);
        String[] colorsInt = getResources().getStringArray(R.array.colors_int);

        adapter = new ColorsAdapter(colorsName, colorsInt);

        ListView lw = (ListView) findViewById(R.id.lw1);

        lw.setAdapter(adapter);
        lw.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }
    public void goBack(View view){
        onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int color = adapter.getColors()[position];

        // Сохраните выбранный цвет в SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("selectedColor", color);
        editor.commit();

        // Перейдите во вторую активность
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);

    }

}
