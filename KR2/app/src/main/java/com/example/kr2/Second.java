package com.example.kr2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends BaseActivity {

    EditText firstname, lastname, age;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
    }

    public void ok(View view){
        Intent intent = new Intent(this, Main.class);

        intent.putExtra(FIRSTNAME, firstname.getText().toString());
        intent.putExtra(LASTNAME, lastname.getText().toString());
        intent.putExtra(AGE, age.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }

}
