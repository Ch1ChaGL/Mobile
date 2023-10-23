package com.example.a11.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a11.R;

public class MyBaseActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(
                "settings",
                MODE_PRIVATE
        );
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
