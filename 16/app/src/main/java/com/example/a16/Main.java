package com.example.a16;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
    }

    public void clickBtn1(View view){
       Toast.makeText(getApplicationContext(), "Пример для кнопки 1", Toast.LENGTH_SHORT).show();
    }

    public void clickBtn2(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Пример для кнопки 2", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0,0);
        toast.show();
    }
}
