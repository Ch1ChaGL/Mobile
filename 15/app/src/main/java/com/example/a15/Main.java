package com.example.a15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

public class Main extends BaseActivity implements AdapterView.OnItemClickListener {
    private ArrayAdapter<String> arad;
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        lv = (ListView) findViewById(R.id.lv);
        arad = new ArrayAdapter<String>(this, R.layout.le);
        lv.setAdapter(arad);
        lv.setOnItemClickListener(this);
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, Second.class);
        intent.putExtra("REQUEST_CODE", CREATE_ACTION);
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK) return;
        String text = data.getStringExtra(EXTRA_TEXT);
        switch (requestCode){
            case CREATE_ACTION:
                arad.add(text);
                break;
            case EDIT_ACTION:
                int curP = data.getIntExtra(EXTRA_ID,1);
                String item = arad.getItem(curP);
                arad.remove(item);
                arad.insert(text, curP);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_ID, position);
        intent.putExtra(EXTRA_TEXT, arad.getItem(position));
        intent.putExtra("REQUEST_CODE", EDIT_ACTION);
        startActivityForResult(intent, EDIT_ACTION);
    }
}
