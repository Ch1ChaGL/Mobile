package com.example.a16;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Duration;

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
        Toast toast = Toast.makeText(getApplicationContext(), "Пример для кнопки 2 (по центру)", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();
    }
    public void clickBtn3(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Пример с картинкой", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0,0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.notification);
        toastContainer.addView(img, 0);
        toast.show();
    }

    public void clickBtn4(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_four_btn, (ViewGroup) findViewById(R.id.custom_toast_container));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void clickBtn5(View view){

    }
    public void clickBtn6(View view){
        
    }
}
