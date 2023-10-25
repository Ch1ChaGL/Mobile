package com.example.a13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity implements TextWatcher {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(this);
        button = (Button) findViewById(R.id.ok);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = editText.getText().toString().trim();
        if(!text.isEmpty()){
            button.setEnabled(true);
        }
        else
        {
            button.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void pressOk(View view){
        String text = editText.getText().toString().trim();
        textView.setText(text);
    }
}
