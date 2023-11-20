package com.example.a18;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    EditText et1, et2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }
    public void first(View view){
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textView = (TextView) inflater.inflate(R.layout.text_view_layout, null);
        textView.setText(et1.getText().toString() + " : " + et2.getText().toString());
        container.addView(textView);
    }
    public void second(View view){
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout note = (LinearLayout) inflater.inflate(R.layout.user_view_layout, null);

        TextView name = note.findViewById(R.id.name);
        TextView age = note.findViewById(R.id.age);

        name.setText(et1.getText().toString());
        age.setText(et2.getText().toString());

        container.addView(note);
    }
}
