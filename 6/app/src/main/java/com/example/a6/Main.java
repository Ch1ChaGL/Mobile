package com.example.a6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
    }

    public void openSecondForm(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    public void openThirdForm(View view){
        Intent intent = new Intent(this, Third.class);
        startActivity(intent);
    }
}
