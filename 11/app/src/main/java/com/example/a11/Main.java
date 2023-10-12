package com.example.a11;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        preferences = getSharedPreferences(
                "settings",
                MODE_PRIVATE
        );
    }
    public void go(View view){
        Intent intent = new Intent(this, Second.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Извлекаем сохраненный цвет из SharedPreferences
        int selectedColor = preferences.getInt("selectedColor", 0);

        // Теперь у вас есть значение цвета, которое вы можете использовать для настройки внешнего вида активности
        // Например, установить его как цвет фона элементов, фона Activity, и т. д.
        getWindow().getDecorView().setBackgroundColor(selectedColor);



    }
}
