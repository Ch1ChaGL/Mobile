package com.example.kr2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Main extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
    }

    public void add(View view){
        Intent intent = new Intent(this, Second.class);
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK) return;
        switch (requestCode){
            case CREATE_ACTION:
                String firstName = data.getStringExtra(FIRSTNAME);
                String lastName = data.getStringExtra(LASTNAME);
                String age = data.getStringExtra(AGE);

                addToLinearLayout(firstName,lastName, age);
            break;
        }
    }

    private void addToLinearLayout(String FirstName, String LastName, String Age){
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout note = (LinearLayout) inflater.inflate(R.layout.user_view_layout, null);

        TextView firstname = note.findViewById(R.id.firstnameTV);
        TextView lastname = note.findViewById(R.id.lastnameTV);
        TextView age = note.findViewById(R.id.ageTV);

        firstname.setText(FirstName);
        lastname.setText(LastName);
        age.setText(Age);

        container.addView(note);
    }
}
