package com.example.a14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    EditText editText1, editText2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        editText1 = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);

        // Получение данных из Intent, если они есть
        Intent intent = getIntent();
        if (intent != null) {
            editText1.setText(intent.getStringExtra("editText1"));
            editText2.setText(intent.getStringExtra("editText2"));
        }
    }

    protected void onResume() {
        super.onResume();

        // Получение данных из Intent, если они есть
        Intent intent = getIntent();
        if (intent != null) {
            editText1.setText(intent.getStringExtra("editText1"));
            editText2.setText(intent.getStringExtra("editText2"));
        }
    }

    public void show (View view){
        Intent intent = new Intent(this, Second.class);

        intent.putExtra("editText1", editText1.getText().toString());
        intent.putExtra("editText2", editText2.getText().toString());

        startActivity(intent);
    }
}
