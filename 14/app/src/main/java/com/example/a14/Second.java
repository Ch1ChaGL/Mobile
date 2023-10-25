package com.example.a14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    EditText editText1, editText2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        editText1 = (EditText) findViewById(R.id.et11);
        editText2 = (EditText) findViewById(R.id.et22);
    }
    public void ok(View view) {
        Intent intent = new Intent(this, Main.class);

        intent.putExtra("editText1", editText1.getText().toString());
        intent.putExtra("editText2", editText2.getText().toString());
        
        startActivity(intent);
    }

    public void cancel(View view) {
        onBackPressed();
    }


}
