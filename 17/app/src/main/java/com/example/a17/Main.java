package com.example.a17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    final int START_ACTION = 1;
    MyApp application;
    EditText et1, et2;
    Button button1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        application = (MyApp) getApplicationContext();

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        button1 = (Button) findViewById(R.id.button1);

        String res1 = getString(R.string.res1);
        String res2 = getString(R.string.res2);

        et1.setText(res1);
        et2.setText(res2);

        application.setStr1(res1);
        application.setStr2(res2);
    }



    public void show(View view){
        Intent intent = new Intent(this, Second.class);
        startActivityForResult(intent, START_ACTION);
    }
}
