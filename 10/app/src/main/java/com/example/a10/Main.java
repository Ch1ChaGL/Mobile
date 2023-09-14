package com.example.a10;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        String[] arr = getResources().getStringArray(R.array.ar1);
        ColorsAdapter adapter = new ColorsAdapter(arr);

        ListView lw = (ListView) findViewById(R.id.lw1);

        lw.setAdapter(adapter);
    }
}
