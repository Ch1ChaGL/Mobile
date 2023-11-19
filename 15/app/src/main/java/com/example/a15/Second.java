package com.example.a15;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class Second extends BaseActivity implements TextWatcher {
    EditText et;
    Button ok;
    int position = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        et = (EditText) findViewById(R.id.et);
        ok = (Button) findViewById(R.id.ok);
        et.addTextChangedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        et.setText(intent.getStringExtra(EXTRA_TEXT));
        position = intent.getIntExtra(EXTRA_ID, 1);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = et.getText().toString().trim();
        if(text.isEmpty()) ok.setEnabled(false);
        else ok.setEnabled(true);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    public void clickOk(View view){
        Bundle ex = getIntent().getExtras();
        int requestCode = ex.getInt("REQUEST_CODE");
        Intent intent = new Intent(this,Main.class);
        if (requestCode == CREATE_ACTION) intent.putExtra(EXTRA_TEXT, et.getText().toString());
        else {
            intent.putExtra(EXTRA_TEXT, et.getText().toString());
            intent.putExtra(EXTRA_ID, position);
        }
        setResult(RESULT_OK, intent);
        finish();
    }
    public void clickCancel(View view){
        Intent intent = new Intent(this,Main.class);
        intent.putExtra(EXTRA_TEXT, et.getText().toString());
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
