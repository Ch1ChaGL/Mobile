package com.example.a3;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView textView1, textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        linearLayout = (LinearLayout) findViewById(R.id.mainLL);
        textView1 = (TextView) findViewById(R.id.tv1);
        textView2 = (TextView) findViewById(R.id.tv2);


    }


    public void toRed(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.RED));
    }

    public void toBlue(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.BLUE));
    }

    public void toBlack(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
    }

    public void toRedGreen(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.RED));
        textView1.setTextColor(ContextCompat.getColor(this, R.color.GREEN));

        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.RED));
        textView2.setTextColor(ContextCompat.getColor(this, R.color.GREEN));
    }

    public void toYellowBlue(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.YELLOW));
        textView1.setTextColor(ContextCompat.getColor(this, R.color.BLUE));

        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.YELLOW));
        textView2.setTextColor(ContextCompat.getColor(this, R.color.BLUE));
    }

    public void toBlackWhite(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        textView1.setTextColor(ContextCompat.getColor(this, R.color.white));
        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        textView2.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

}
