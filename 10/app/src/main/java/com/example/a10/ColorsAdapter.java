package com.example.a10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class ColorsAdapter extends BaseAdapter {

    public  ColorsAdapter(String[] arr){
        this.names = arr;
    }
    private String[] names;

    @Override
    public int getCount() {
        return names.length;
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

        if(position % 2 == 0){
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.chet));
        }
        else{
            textView.setBackgroundColor(ContextCompat.getColor(context, R.color.nechet));
        }

        return convertView;
    }
}
