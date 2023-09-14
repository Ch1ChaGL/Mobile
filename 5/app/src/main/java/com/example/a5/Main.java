package com.example.a5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {


    int currentPosition = -1;
    private View currentView = null;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;
    EditText editText;

    private Button del, edit;

    boolean enable = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.le);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);


        del = (Button) findViewById(R.id.del);
        edit = (Button) findViewById(R.id.edit);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        arrayAdapter.add("First");
        arrayAdapter.add("Second");
    }

    public void toAdd(View view){
       String text = editText.getText().toString();
       arrayAdapter.add(text);
    }

    public void toClear(View view){
        arrayAdapter.clear();
    }

    public void toEdit(View view){
        String s = arrayAdapter.getItem(currentPosition);
        arrayAdapter.remove(s);
        arrayAdapter.insert(editText.getText().toString(), currentPosition);

        edit.setEnabled(false);
    }

    public void toDel(View view){
        if (currentPosition == -1) return;
        arrayAdapter.remove(arrayAdapter.getItem(currentPosition));
        currentView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        currentView = null;
        
        edit.setEnabled(false);
        del.setEnabled(false);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        enable = true;
        if(currentView != null){
            currentView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }

        del.setEnabled(true);
        edit.setEnabled(true);

        String textOnItem = arrayAdapter.getItem(position);
        currentPosition = position;
        editText.setText(textOnItem);


        view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500));
        currentView = view;
    }
}
