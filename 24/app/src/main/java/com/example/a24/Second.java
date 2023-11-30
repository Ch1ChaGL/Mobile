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
    MyApp application;
    EditText et1;
    Button ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        ok = (Button)findViewById(R.id.ok);
        et1 = (EditText)findViewById(R.id.et);
        et1.addTextChangedListener(this);
        application = (MyApp) getApplicationContext();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(MyApp.CurrentActionCode == MyApp.EDIT_ACTION){
            et1.setText(application.getNoteById(application.getNoteId()).get_note());
        }
    }

    public void clickOk(View view) {
        setResult(RESULT_OK);
        if (MyApp.CurrentActionCode == MyApp.CREATE_ACTION){
            application.add(new Note("Test",et1.getText().toString(), Note.getCurrentTime()));
        }
        if(MyApp.CurrentActionCode == MyApp.EDIT_ACTION){
            application.set(application.getNoteId(), new Note("Test", et1.getText().toString(), Note.getCurrentTime()));
        }
        finish();
    }


    public void clickCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
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
