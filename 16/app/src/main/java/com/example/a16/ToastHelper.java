package com.example.a16;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastHelper {
    Context context;
    public ToastHelper(Context context){
        this.context = context;
    }
    public void Show(String message1, String message2){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast_four_btn, null);
        Toast toast = new Toast(context);

        TextView tv1 = layout.findViewById(R.id.tv1);
        TextView tv2 = layout.findViewById(R.id.tv2);

        tv1.setText(message1);
        tv2.setText(message2);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();
    }
}
