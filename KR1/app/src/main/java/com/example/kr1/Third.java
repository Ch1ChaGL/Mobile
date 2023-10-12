package com.example.kr1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Third extends AppCompatActivity {
    TextView textView1, textView2;
    Button button1, button2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);
        textView1 = (TextView) findViewById(R.id.tv1);
        textView2 = (TextView) findViewById(R.id.tv2);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
    }

    public void onAdd(View view){
        String s = textView1.getText().toString();

        textView1.setText(s + "*");
    }
    public void onCopy(View view){
        String s = textView1.getText().toString();
        textView2.setText(s);
    }
}
