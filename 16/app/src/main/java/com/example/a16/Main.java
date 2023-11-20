package com.example.a16;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Duration;

public class Main extends AppCompatActivity {
    private EditText et1, et2;
    ToastHelper toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        toast = new ToastHelper(getApplicationContext());
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
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
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_four_btn, (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView tv1 = (TextView) layout.findViewById(R.id.tv1);
        TextView tv2 = (TextView) layout.findViewById(R.id.tv2);
        ImageView img = (ImageView) layout.findViewById(R.id.iv1);

        tv1.setText("Текст для 5 кнопки 1");
        tv2.setText("Текст для 5 кнопки 2");
        tv1.setTextColor(Color.rgb(31,23,121));
        tv1.setBackgroundColor(Color.rgb(41,86,98));
        tv2.setTextColor(Color.rgb(76,23,165));
        tv2.setBackgroundColor(Color.rgb(98,16,43));

        img.setImageResource(R.drawable.notification2);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
    public void clickBtn6(View view){
        String t1 = et1.getText().toString();
        String t2 = et2.getText().toString();

        toast.Show(t1, t2);
    }
}
