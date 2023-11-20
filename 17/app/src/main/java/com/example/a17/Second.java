package com.example.a17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    MyApp application;
    EditText et1, et2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        application = (MyApp) getApplicationContext();

        et1 = (EditText) findViewById(R.id.et11);
        et2 = (EditText) findViewById(R.id.et22);
    }

    @Override
    protected void onResume() {
        super.onResume();

        et1.setText(application.getStr1());
        et2.setText(application.getStr2());
    }

    public void ok(View view){
        Intent intent = new Intent(this, Main.class);
        application.setStr1(et1.getText().toString());
        application.setStr2(et2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
    public void cancel(View view){
        Intent intent = new Intent(this, Main.class);
        setResult(RESULT_CANCELED, intent);
        finish();

    }
}
