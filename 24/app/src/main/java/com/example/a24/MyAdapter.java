package com.example.a24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    MyApp application;
    List<Note> notes;


    public MyAdapter(MyApp application){
        this.application = application;
        notes = application.getNotes();
    }

    @Override
    public int getCount() {
        return notes.size();
    }
    @Override
    public Object getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.le, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.textViewLE);
        textView.setText(application.getNoteById(i).get_note());

        return view;
    }
}
