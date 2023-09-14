package com.example.a9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    EditText intElem, string1, string2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);

        preferences = getSharedPreferences(
                getString(R.string.preferences),
                MODE_PRIVATE
        );

        intElem = (EditText) findViewById(R.id.num1);

        string1 = (EditText) findViewById(R.id.string1);
        string2 = (EditText) findViewById(R.id.string2);


    }

    @Override
    protected void onResume() {
        super.onResume();

        String intElKey = getString(R.string.intKey1);
        String stringElKey1 = getString(R.string.stringKey1);
        String stringElKey2 = getString(R.string.stringKey2);


        int intEl = preferences.getInt(intElKey, 0);

        String stringEl1 = preferences.getString(stringElKey1, "default value 1");
        String stringEl2 = preferences.getString(stringElKey2, "default value 2");

        intElem.setText(String.valueOf(intEl));

        string1.setText(stringEl1);
        string2.setText(stringEl2);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String text1 = string1.getText().toString();
        String text2 = string2.getText().toString();

        int num = Integer.parseInt(intElem.getText().toString());

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(getString(R.string.intKey1), num);
        editor.putString(getString(R.string.stringKey1), text1);
        editor.putString(getString(R.string.stringKey2), text2);


        editor.commit();
    }
}

