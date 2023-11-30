package com.example.a24;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity implements TextWatcher {
    EditText et1;
    Button ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        ok = (Button)findViewById(R.id.ok);
        et1 = (EditText)findViewById(R.id.et);
        et1.addTextChangedListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void clickOk(View view) {

    }


    public void clickCancel(View view) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String text = et1.getText().toString().trim();
        if(text.isEmpty()) ok.setEnabled(false);
        else ok.setEnabled(true);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
