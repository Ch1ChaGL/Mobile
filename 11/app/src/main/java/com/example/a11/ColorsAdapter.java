package com.example.a11;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class ColorsAdapter extends BaseAdapter {

    public  ColorsAdapter(String[] arr, String[] colors){
        this.names = arr;
        this.colors = toIntFromStringColor(colors);
    }
    private String[] names;
    private int[] colors;
    @Override
    public int getCount() {
        return names.length;
    }
    private  int[] toIntFromStringColor(String[] colors) {
        int[] newColors = new int[colors.length];
        for (int i = 0; i < colors.length; i++){
            newColors[i] = Color.parseColor(colors[i]);
        }
        return newColors;
    }
    public int[] getColors(){
        return colors;
    }
    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.le, parent, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(names[position]);
        textView.setBackgroundColor(colors[position]);

        return convertView;
    }
}